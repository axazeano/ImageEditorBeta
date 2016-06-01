package org.axazeano.effects.colorCorrection;



import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import org.axazeano.effects.BaseEffect;

/**
 * Created by vladimir on 15.05.2016.
 */
public class Greyscale extends BaseEffect {

    static {
        description = "Convert image to greyscale format";
        name = "Greyscale";
    }

    public Greyscale() {
        super();
    }

    @Override
    protected void proceedEffect() {
        for (int y = selection.getStartY(); y < selection.getHeight(); y++) {
            for (int x = selection.getStartX(); x < selection.getWidth(); x++) {
                Color originalColor = pixelReader.getColor(x, y);
                int newColorValue = (int) ((originalColor.getRed() + originalColor.getGreen() + originalColor.getBlue()) / 3 * 255);
                pixelWriter.setColor(x, y, Color.rgb(newColorValue, newColorValue, newColorValue));
            }
        }
    }
}
