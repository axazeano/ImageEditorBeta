package org.axazeano.effects.transform;

import javafx.scene.image.Image;
import org.axazeano.effects.BaseEffect;
import org.axazeano.effects.BaseEffectOneParam;

/**
 * Created by vladimir on 17.05.2016.
 */
public class Rotate extends BaseEffectOneParam{
    private double degrees;
    private int centerX;
    private int centerY;

    static {
        name = "Rotate";
        description = "Rotate image";
        firstParameter = "Angle";
    }

    public Rotate() {
        super();
        centerX = selection.getWidth() / 2;
        centerY = selection.getHeight() / 2;
    }

    public void setValues(int angle) {
        degrees = Math.PI * angle / 180.0;
    }

    @Override
    protected Image proceedEffect() {
        for (int y = selection.getStartY(); y < selection.getHeight(); ++y)
        {
            for (int x = selection.getStartX(); x < selection.getWidth(); ++x)
            {
                int newX = (int) (Math.cos(degrees) * (x - centerX) - Math.sin(degrees) * (y - centerY) + centerX);
                if (newX >= selection.getWidth() || newX < 0) { continue; }
                int newY = (int) (Math.sin(degrees) * (x - centerX) + Math.cos(degrees) * (y - centerY) + centerY);
                if (newY >= selection.getHeight() || newY < 0) { continue; }

                pixelWriter.setColor(newX, newY, pixelReader.getColor(x, y));
            }
        }
        return null;
    }


}
