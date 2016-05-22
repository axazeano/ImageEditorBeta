package org.axazeano.effects;

import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import org.axazeano.ImagesHolder;
import org.axazeano.history.HistoryHolder;
import org.axazeano.history.HistoryItem;

/**
 * Created by vladimir on 15.05.2016.
 */
public class BaseEffect {
    protected PixelReader pixelReader;
    protected PixelWriter pixelWriter;
    protected WritableImage writableImage;
    protected Image modifiedImage;
    protected Selection selection = Selection.INSTANCE;
    protected HistoryHolder history = HistoryHolder.INSTANCE;

    public static String description ;
    public static String name ;

    public BaseEffect(Image modifiedImage) {
        this.modifiedImage = modifiedImage;
        pixelReader = history.getCurrentImage().getPixelReader();
        writableImage = new WritableImage(
                (int)history.getCurrentImage().getWidth(),
                (int)history.getCurrentImage().getHeight());
        pixelWriter = writableImage.getPixelWriter();
    }

    public void applyEffect() {
        history.add(new HistoryItem(name, proceedEffect(), true));
    }

    protected Image proceedEffect() {
        return null;
    }
}
