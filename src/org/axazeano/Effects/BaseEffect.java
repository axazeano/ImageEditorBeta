package org.axazeano.effects;

import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.image.WritablePixelFormat;
import org.axazeano.history.HistoryHolder;
import org.axazeano.history.HistoryItem;

import java.nio.IntBuffer;

/**
 * Created by vladimir on 15.05.2016.
 */
public class BaseEffect {
    /**
     * Source for pixels
     * @see BaseEffect#pixels
     * @deprecated
     */
    protected PixelReader pixelReader;
    /**
     * Destination for pixels
     */
    protected PixelWriter pixelWriter;
    /**
     * Destination image. Set pixels using {@link BaseEffect#pixelWriter}. Get pixels using {@link BaseEffect#pixelReader}
     */
    protected WritableImage writableImage;
    /**
     * Array with pixels. Faster that pixelReader
     */
    protected int[] pixels;
    protected Selection selection = Selection.INSTANCE;
    protected HistoryHolder history = HistoryHolder.INSTANCE;

    public static String description ;
    public static String name ;

    /**
     * Sets pixelReader, pixelWriter and writableImage. Fills pixels array.
     */
    public BaseEffect() {
        pixelReader = history.getCurrentImage().getPixelReader();
        WritablePixelFormat<IntBuffer> format = WritablePixelFormat.getIntArgbInstance();
        pixelReader.getPixels(0, 0, selection.getWidth(), selection.getHeight(), format, pixels, 0, selection.getWidth());
        writableImage = new WritableImage(
                (int)history.getCurrentImage().getWidth(),
                (int)history.getCurrentImage().getHeight());
        pixelWriter = writableImage.getPixelWriter();
    }

    /**
     * This method will apply effect and add new temp item to history
     */
    public void applyEffect() {
        proceedEffect();
        history.add(new HistoryItem(name, writableImage, true));
    }

    /**
     * The main logic of effect. Fired int applyEffect
     * @see BaseEffect#applyEffect
     */
    protected void proceedEffect() {
    }
}
