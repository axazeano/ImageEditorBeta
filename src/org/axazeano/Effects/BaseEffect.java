package org.axazeano.effects;

import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import org.axazeano.ImagesHolder;

/**
 * Created by vladimir on 15.05.2016.
 */
public class BaseEffect {
    protected PixelReader pixelReader;
    protected PixelWriter pixelWriter;
    protected WritableImage writableImage;
    protected ImagesHolder imagesHolder = ImagesHolder.INSTANCE;
    protected Selection selection = Selection.INSTANCE;

    public static String description = "Base effect";

    public static String name = "Base Effect";


    public static String getName() {
        return name;
    }

    public static String getDescription() {
        return description;
    }




    public BaseEffect() {
        pixelReader = imagesHolder.getModifiedImage().getPixelReader();
        writableImage = new WritableImage(
                (int)imagesHolder.getModifiedImage().getWidth(),
                (int)imagesHolder.getModifiedImage().getHeight());
        pixelWriter = writableImage.getPixelWriter();
    }

    public void applyEffect() {
        proceedEffect();
    }

    protected void proceedEffect() {

    }
}
