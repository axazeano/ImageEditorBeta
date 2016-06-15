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
public abstract class BaseEffect {
    protected Selection selection = Selection.INSTANCE;

    public static String description ;
    public static String name ;

    public BaseEffect() {
    }

    public void applyEffect() {
        proceedEffect();
    }

    abstract protected void proceedEffect();
}
