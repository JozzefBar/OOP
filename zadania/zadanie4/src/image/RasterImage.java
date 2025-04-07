package image;

import manipulation.Normalizable;
import manipulation.Rotatable;
import manipulation.RotationDirection;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * This class is a wrapper for the BufferedImage.
 * It implements additional manipulation interfaces: {@link Normalizable}, {@link Rotatable},
 * as well as {@link Savable}.
 */
public class RasterImage implements Savable, Rotatable, Normalizable {

    // contents, do not change
    private BufferedImage image;

    /**
     * Constructs the object by loading a specified PNG image.
     * @param imagePath Path to the PNG image.
     * @throws IllegalArgumentException If the imagePath is null or empty, or the path does not exist, or the path is not an image.
     */
    public RasterImage(String imagePath) {
        // do not change the constructor

        if (imagePath == null || imagePath.isEmpty()) {
            throw new IllegalArgumentException("Image path cannot be null or empty");
        }
        // load the image
        BufferedImage tmpImage;
        try (FileInputStream fis = new FileInputStream(imagePath)) {
            tmpImage = ImageIO.read(fis);
        } catch (IOException e) {
            throw new IllegalArgumentException("Could not load image " + imagePath);
        }
        image = tmpImage;
    }

    /**
     * Get the underlying BufferedImage.
     * @return image
     */
    public BufferedImage getImage() {
        // do not change this method

        return image;
    }

    /**
     * Convert rgn value to an array.
     * @param rgb value to convert
     * @return array with R, G and B values respectively-
     * @throws IllegalArgumentException if the value is invalid
     */
    private static int[] rgbToArray(int rgb) {
        // do not change this method

        if (rgb < 0) throw new IllegalArgumentException("Invalid RGB value");
        else return new int[]{(rgb >> 16) & 0xFF, (rgb >> 8) & 0xFF, rgb & 0xFF};
    }

    /**
     * Convert rgb array to a value.
     * @param array an rgb array
     * @return converted value
     * @throws IllegalArgumentException if the array is invalid or contains invalid values.
     */
    private static int arrayToRgb(int[] array) {
        // do not change this method

        if (array == null || array.length != 3 ||
                array[0] < 0 || array[1] < 0 || array[2] < 0 ||
                array[0] > 255 || array[1] > 255 || array[2] > 255)
            throw new IllegalArgumentException("Invalid RGB array!");
        else return (array[0] << 16) | (array[1] << 8) | array[2];
    }

    /**
     * Save the image to the specified path in the PNG format.
     * @param path Path to save the object's content to.
     * @throws IllegalArgumentException if the path is invalid.
     */
    @Override
    public void save(String path) {
        // do not change this method

        if (path == null || path.isEmpty()) {
            throw new IllegalArgumentException("Image path cannot be null or empty");
        }
        try(FileOutputStream fos = new FileOutputStream(path)) {
            ImageIO.write(image, "png", fos);
        } catch (IOException e) {
            throw new IllegalArgumentException("Could not save image " + path);
        }
    }

    @Override
    public void rotate(RotationDirection direction) {
        if (direction == null) {
            throw new IllegalArgumentException("Direction cannot be null.");
        }

        int width = image.getWidth();
        int height = image.getHeight();
        BufferedImage rotatedImage = new BufferedImage(height, width, image.getType());

        if (direction == RotationDirection.RIGHT) {
            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    rotatedImage.setRGB(height - 1 - y, x, image.getRGB(x, y));
                }
            }
        } else if (direction == RotationDirection.LEFT) {
            // Rotace o 90° vlevo (proti směru hodinových ručiček)
            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    rotatedImage.setRGB(y, width - 1 - x, image.getRGB(x, y));
                }
            }
        }

        this.image = rotatedImage;
    }

    @Override
    public void normalize() {
        int width = image.getWidth();
        int height = image.getHeight();

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int rgb = image.getRGB(x, y);
                int[] rgbArray = rgbToArray(rgb);

                int sum = rgbArray[0] + rgbArray[1] + rgbArray[2];

                if (sum > 0) {
                    int newR = (rgbArray[0] * 255) / sum;
                    int newG = (rgbArray[1] * 255) / sum;
                    int newB = (rgbArray[2] * 255) / sum;

                    rgbArray[0] = newR;
                    rgbArray[1] = newG;
                    rgbArray[2] = newB;

                    image.setRGB(x, y, arrayToRgb(rgbArray));
                }
            }
        }
    }
}
