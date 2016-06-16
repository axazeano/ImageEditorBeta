package org.axazeano.effects;

import org.axazeano.EditableImage;

/**
 * Created by vladimir on 15.05.2016.
 */
public abstract class BaseEffect {
    protected Selection selection = Selection.INSTANCE;
    protected EditableImage inputImage;
    protected int[] sourcePixelArray;
    protected int[] targetPixelArray;

    public static String description;
    public static String name;

    public BaseEffect(EditableImage image) {
        inputImage = image;
        sourcePixelArray = inputImage.getPixelsArray();
        targetPixelArray = inputImage.getPixelsArray();
    }
}
