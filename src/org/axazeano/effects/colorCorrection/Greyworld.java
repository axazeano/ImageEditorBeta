package org.axazeano.effects.colorCorrection;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import org.axazeano.effects.BaseEffect;

/**
 * Created by vladimir on 16.05.2016.
 */
public class Greyworld extends BaseEffect {

    private double redSum, greenSum, blueSum;
    private double redGlobal, greenGlobal, blueGlobal;
    private double redDiv, greenDiv, blueDiv;
    private int redNew, greenNew, blueNew;
    private double avg;

    static {
        name = "Grey world";
        description = "Grey world normalization";
    }

    public Greyworld() {
        super();
    }

    @Override
    protected void proceedEffect() {
        calculateDivValues();
        for (int y =  selection.getStartY(); y < selection.getHeight(); y++)
        {
            for (int x = selection.getStartX(); x < selection.getWidth(); x++)
            {
                Color color = pixelReader.getColor(x, y);
                redNew = (int)(color.getRed() * 256 * redDiv);
                greenNew = (int)(color.getGreen() * 256 * greenDiv);
                blueNew = (int)(color.getBlue() * 256 * blueDiv);
                pixelWriter.setColor(x, y, Color.rgb(redNew, greenNew, blueNew));
            }
        }
    }

    private void calculateSumValues()
    {
        for (int y = selection.getStartY(); y < selection.getHeight(); y++)
        {
            for (int x = selection.getStartX(); x < selection.getWidth(); x++)
            {
                Color color = pixelReader.getColor(x, y);
                redSum += (int) (color.getRed() * 256);
                greenSum += (int) (color.getGreen() * 256);
                blueSum += (int) (color.getBlue() * 256);
            }
        }
    }

    private void calculateGlobalValues()
    {
        calculateSumValues();

        int size = (int) (history.getOriginalImage().getHeight() * history.getOriginalImage().getWidth());
        redGlobal = 1d / size * redSum;
        greenGlobal = 1d / size * greenSum;
        blueGlobal = 1d / size * blueSum;
        avg = (redGlobal + greenGlobal + blueGlobal) / 3;
    }

    private void calculateDivValues()
    {
        calculateGlobalValues();
        redDiv = avg / redGlobal;
        greenDiv = avg / greenGlobal;
        blueDiv = avg / blueGlobal;
    }
}
