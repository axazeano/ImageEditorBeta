package org.axazeano.effects.colorCorrection;

import javafx.scene.paint.Color;

/**
 * Created by vladimir on 01.06.2016.
 */
public class RootCorrection extends FunctionalCorrection {
    static {
        description = "Root correction";
        name = "Root correction";
    }

    @Override
    protected void preEvaluating() {
        coefRed = maxRed / 15.95;
        coefGreen = maxGreen / 15.95;
        coefBlue = maxBlue / 15.95;
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
                resultRed = (int) Math.sqrt((currentPixel.getRed() * 255) * coefRed);
                resultGreen = (int) Math.sqrt((currentPixel.getGreen() * 255) * coefGreen);
                resultBlue = (int) Math.sqrt((currentPixel.getBlue() * 255) * coefBlue);

                pixelWriter.setColor(x, y, Color.rgb(resultRed < 256 ? resultRed : 255,
                        resultGreen < 256 ? resultGreen : 255,
                        resultBlue < 255 ? resultBlue : 255));
            }
        }
    }
}
