package org.axazeano.effects.colorCorrection;


import org.axazeano.ARGBColor;
import org.axazeano.EditableImage;
import org.axazeano.effects.BaseEffect;
import org.axazeano.effects.EffectInterface;

/**
 * Created by vladimir on 15.05.2016.
 */
public class Greyscale extends BaseEffect implements EffectInterface {

    static {
        description = "Convert image to greyscale format";
        name = "Greyscale";
    }

    public Greyscale(EditableImage image) {
        super(image);
    }

    @Override
    public int[] performEffect() {
        int[] pixelsArray = this.inputImage.getPixelsArray();

        for (int i = 0; i < pixelsArray.length; i++) {
            ARGBColor color = new ARGBColor(pixelsArray[i]);
            color.setRed((int) (color.getRed() * 0.2989));
            color.setGreen((int) (color.getGreen() * 0.5870));
            color.setBlue((int) (color.getBlue() * 0.1140));
            pixelsArray[i] = color.getColor();
        }
        return pixelsArray;
    }
}
