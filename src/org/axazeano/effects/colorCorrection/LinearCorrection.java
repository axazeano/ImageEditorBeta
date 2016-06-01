package org.axazeano.effects.colorCorrection;

import javafx.scene.paint.Color;
import org.axazeano.effects.BaseEffect;

/**
 * Created by vladimir on 24.05.2016.
 */
public class LinearCorrection extends FunctionalCorrection {
    static {
        description = "Linear stretching";
        name = "Linear Correction";
    }

    @Override
    protected void preEvaluating() {
        coefRed = (maxRed - minRed) / 255;
        coefGreen = (maxGreen - minGreen) / 255;
        coefBlue = (maxBlue - minBlue) / 255;
    }

    @Override
    public void proceedEffect(){
        super.proceedEffect();
        int resultRed = 0;
        int resultGreen = 0;
        int resultBlue = 0;

        for (int y=0; y < selection.getHeight(); y++) {
            for (int x=0; x < selection.getWidth(); x++) {
                Color currentPixel = pixelReader.getColor(x, y);
                resultRed = (int) ((currentPixel.getRed() * 255 - minRed) * coefRed);
                resultGreen = (int) ((currentPixel.getGreen() * 255 - minGreen) * coefGreen);
                resultBlue = (int) ((currentPixel.getBlue() * 255 - minBlue) * coefBlue);

                pixelWriter.setColor(x, y, Color.rgb(resultRed, resultGreen, resultBlue));
            }
        }
    }
}
