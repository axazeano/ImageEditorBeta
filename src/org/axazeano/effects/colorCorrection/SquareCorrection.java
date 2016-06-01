package org.axazeano.effects.colorCorrection;

import javafx.scene.paint.Color;

/**
 * Created by vladimir on 01.06.2016.
 */
public class SquareCorrection extends FunctionalCorrection {
    static {
        description = "Square correction";
        name = "Square correction";
    }

    @Override
    protected void preEvaluating() {
        coefRed = maxRed / (255 * 255);
        coefGreen = maxGreen / (255 * 255);
        coefBlue = maxBlue / (255 * 255);
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
                resultRed = (int) (Math.pow((currentPixel.getRed() * 255), 2) * coefRed);
                resultGreen = (int) (Math.pow((currentPixel.getGreen() * 255), 2) * coefGreen);
                resultBlue = (int) (Math.pow((currentPixel.getBlue() * 255), 2) * coefBlue);

                pixelWriter.setColor(x, y, Color.rgb(resultRed < 256 ? resultRed : 255,
                        resultGreen < 256 ? resultGreen : 255,
                        resultBlue < 255 ? resultBlue : 255));
            }
        }
    }
}
