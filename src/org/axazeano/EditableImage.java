package org.axazeano;

import javafx.scene.image.*;

import java.nio.IntBuffer;

/**
 * Created by vladimir on 15.06.16.
 */
public class EditableImage {
    private Image image;
    private PixelWriter pixelWriter;
    private PixelReader pixelReader;
    private final WritablePixelFormat<IntBuffer> format =
            WritablePixelFormat.getIntArgbInstance();

    public Image getImage() {
        return image;
    }

    public int[] getPixelsArray() {
        int[] result = new int[(int) (image.getWidth() * image.getHeight())];
        pixelReader = image.getPixelReader();
        pixelReader.getPixels(0, 0, (int) image.getWidth(), (int) image.getHeight(), format, result, 0,
                (int) image.getWidth());
        return result;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public void setImageByPixelsArray(int[] pixelsArray) {
        WritableImage writableImage = new WritableImage((int) image.getWidth(),
                (int) image.getHeight());
        pixelWriter = writableImage.getPixelWriter();
        pixelWriter.setPixels(0, 0, (int) image.getWidth(), (int) image.getHeight(), format, pixelsArray, 0,
                (int) image.getWidth());
        this.image = writableImage;
    }
}
