package org.axazeano.effects;

import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import org.axazeano.history.HistoryHolder;
import org.axazeano.history.HistoryItem;

/**
 * Created by vladimir on 15.05.2016.
 */
public class BaseEffect {
    /**
     * Source for pixels
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
    protected Selection selection = Selection.INSTANCE;
    protected HistoryHolder history = HistoryHolder.INSTANCE;

    public static String description ;
    public static String name ;

    /**
     * Set pixelReader, pixelWriter and writableImage
     */
    public BaseEffect() {
        pixelReader = history.getCurrentImage().getPixelReader();
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
