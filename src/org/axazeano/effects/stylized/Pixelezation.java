package org.axazeano.effects.stylized;

import javafx.scene.paint.Color;
import org.axazeano.effects.BaseEffectOneParam;

/**
 * Created by vladimir on 24.05.2016.
 */
public class Pixelezation extends BaseEffectOneParam {
    static {
        name = "Pixelezation";
        description = "Pixelezation effect";
        firstParameter = "Blocks";
    }
    private int blocksCount;

    public Pixelezation() {
        super();
    }

    public void setValues(int blocksCount) {
            this.blocksCount = blocksCount;
    }

    @Override
    protected void proceedEffect() {
        for (int x = selection.getStartX(); x < selection.getWidth() / blocksCount; x++) {
            for (int y = selection.getStartY(); y < selection.getHeight() / blocksCount; y++) {
                int totalRed = 0;
                int totalGreen = 0;
                int totalBlue = 0;
                int totalCount = 0;

                for (int xx = 0; xx < blocksCount; xx++) {
                    for (int yy = 0; yy < blocksCount; yy++, totalCount++) {
                        Color currentPixel = pixelReader.getColor(x * blocksCount + xx, y * blocksCount + yy);
                        totalRed += currentPixel.getRed() * 256;
                        totalGreen += currentPixel.getGreen() * 256;
                        totalBlue += currentPixel.getBlue() * 255;
                    }
                }

                totalRed /= totalCount;
                totalGreen /= totalCount;
                totalBlue /= totalCount;

                for (int xx = 0; xx < blocksCount; xx++) {
                    for (int yy = 0; yy < blocksCount; yy++) {
                        pixelWriter.setColor(x * blocksCount + xx,
                                y * blocksCount + yy,
                                Color.rgb(totalRed, totalGreen, totalBlue));
                    }
                }
            }
        }
    }
}
