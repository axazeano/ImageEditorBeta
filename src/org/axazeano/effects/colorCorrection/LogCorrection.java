package org.axazeano.effects.colorCorrection;

import javafx.scene.paint.Color;

/**
 * Created by vladimir on 01.06.2016.
 */
public class LogCorrection extends FunctionalCorrection {
    static {
        description = "Log correction";
        name = "Log correction";
    }

    @Override
    protected void preEvaluating() {
        coefRed = maxRed / 2.412;
        coefGreen = maxGreen / 2.412;
        coefBlue = maxBlue / 2.412;
    }

    @Override
    public void proceedEffect(){
        super.proceedEffect();
        int resultRed;
        int resultGreen;
        int resultBlue;

        for (int y=0; y < selection.getHeight(); y++) {
            for (int x=0; x < selection.getWidth(); x++) {
                Color currentPixel = pixelReader.getColor(x, y);
                resultRed = (int) Math.log((currentPixel.getRed() * 255) * coefRed);
                resultGreen = (int) Math.log((currentPixel.getGreen() * 255) * coefGreen);
                resultBlue = (int) Math.log((currentPixel.getBlue() * 255) * coefBlue);

                pixelWriter.setColor(x, y, Color.rgb(resultRed < 256 ? resultRed : 255,
                        resultGreen < 256 ? resultGreen : 255,
                        resultBlue < 255 ? resultBlue : 255));
            }
        }
    }
}
