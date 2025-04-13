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
public class TextImage implements Savable, Rotatable, Substitutable {
    private char[][] image;
    private int width;
    private int height;

    /**
     * Construct a TextImage from the specified text file.
     * @param imagePath path to the text file to load
     * @throws IllegalArgumentException if the imagePath is invalid or the file is empty.
     */
    public TextImage(String imagePath) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(imagePath));
            String line;
            int rowCount = 0;
            int maxWidth = 0;

            while ((line = reader.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    rowCount++;
                    if (line.length() > maxWidth) {
                        maxWidth = line.length();
                    }
                }
            }
            reader.close();

            if (rowCount == 0) {
                throw new IllegalArgumentException("Súbor je prázdny.");
            }

            image = new char[rowCount][maxWidth];
            reader = new BufferedReader(new FileReader(imagePath));
            int i = 0;
            while ((line = reader.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    char[] rowChars = line.toCharArray();
                    for (int j = 0; j < maxWidth; j++) {
                        if (j < rowChars.length) {
                            image[i][j] = rowChars[j];
                        } else {
                            image[i][j] = ' ';
                        }
                    }
                    i++;
                }
            }
            reader.close();

            this.width = maxWidth;
            this.height = rowCount;

        } catch (IOException e) {
            throw new IllegalArgumentException("Chyba pri čítaní súboru: " + e.getMessage());
        }
    }

    public char[][] getImage() {
        return image;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public char getSymbol(int x, int y) {
        if (y < 0 || y >= height || x < 0 || x >= width) {
            throw new IllegalArgumentException("Pozícia mimo rozsah obrázka.");
        }

        if (x >= image[y].length) {
            return ' ';
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

        char[][] rotatedImage = new char[width][height];

        if (direction == RotationDirection.LEFT) {
            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    rotatedImage[width - 1 - x][y] = (x < image[y].length) ? image[y][x] : ' ';
                }
            }
        } else {
            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    rotatedImage[x][height - 1 - y] = (x < image[y].length) ? image[y][x] : ' ';
                }
            }
        }

        image = rotatedImage;
        int temp = width;
        width = height;
        height = temp;
    }
}
