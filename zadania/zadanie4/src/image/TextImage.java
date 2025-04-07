package image;

import manipulation.RotationDirection;
import manipulation.Rotatable;
import manipulation.Substitutable;
import java.awt.image.BufferedImage;
import java.io.*;

/**
 * This class represents a textual image, for instance ascii art.
 * It implements {@link Substitutable}, {@link Rotatable} and {@link Savable}.
 */
public class TextImage implements Savable, Rotatable, Substitutable{
    private char[][] image;

    /**
     * Construct a TextImage from the specified text file.
     * @param imagePath path to the text file to load
     * @throws IllegalArgumentException if the imagePath is invalid or the file is empty.
     */
    public TextImage(String imagePath) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(imagePath));
            int rowNum = 0;
            while (reader.readLine() != null) {
                rowNum++;
            }
            reader.close();

            if (rowNum == 0) {
                throw new IllegalArgumentException("Súbor je prázdny.");
            }

            image = new char[rowNum][];
            reader = new BufferedReader(new FileReader(imagePath));
            String line;
            int i = 0;
            while ((line = reader.readLine()) != null) {
                image[i] = line.toCharArray();
                i++;
            }
            reader.close();

        } catch (IOException e) {
            throw new IllegalArgumentException("Chyba pri čítaní súboru: " + e.getMessage());
        }
    }

    /**
     * Get the image.
     * @return image
     */
    public char[][] getImage() {
        return image;
    }

    /**
     * Get the image's width.
     * @return width
     */
    public int getWidth() {
        int maxWidth = 0;
        for (char[] row : image) {
            if (row.length > maxWidth) {
                maxWidth = row.length;
            }
        }
        return maxWidth;
    }

    /**
     * Get the image's height.
     * @return height
     */
    public int getHeight() {
        return image.length;

    }

    /**
     * Get the character at the specified coordinates.
     * @param x the x coordinate
     * @param y the y coordinate
     * @return the symbol at the position (x, y)
     * @throws IllegalArgumentException if the coordinates are out of bounds
     */
    public char getSymbol(int x, int y) {
        if (y < 0 || y >= image.length || x < 0 || x >= image[y].length) {
            throw new IllegalArgumentException("Coordinates (" + x + ", " + y + ") are out of bounds.");
        }

        return image[y][x];
    }

    @Override
    public void save(String path) {
        if (path == null || path.isEmpty()) {
            throw new IllegalArgumentException("Image path cannot be null or empty");
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
            for (char[] row : image) {
                writer.write(row);
                writer.newLine();
            }
        } catch (IOException e) {
            throw new IllegalArgumentException("Could not save image " + path);
        }
    }

    @Override
    public void substituteSymbol(char oldSymbol, char newSymbol) {
        for (int y = 0; y < image.length; y++) {
            for (int x = 0; x < image[y].length; x++) {
                if (image[y][x] == oldSymbol) {
                    image[y][x] = newSymbol;
                }
            }
        }
    }

    @Override
    public void rotate(RotationDirection direction) {
        if (direction == null) {
            throw new IllegalArgumentException("Direction cannot be null.");
        }

        int height = getHeight();
        int width = getWidth();
        char[][] rotatedImage = new char[width][height];

        if (direction == RotationDirection.LEFT) {
            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    rotatedImage[width - 1 - x][y] = image[y][x];
                }
            }
        } else {
            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    rotatedImage[x][height - 1 - y] = image[y][x];
                }
            }
        }

        this.image = rotatedImage;
    }
}
