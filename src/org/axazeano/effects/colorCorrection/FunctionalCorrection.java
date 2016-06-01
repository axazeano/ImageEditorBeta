package org.axazeano.effects.colorCorrection;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import org.axazeano.effects.BaseEffect;
import org.axazeano.history.HistoryItem;

/**
 * Created by vladimir on 24.05.2016.
 */
public class FunctionalCorrection extends BaseEffect {
    int minRed = 255;
    int minGreen = 255;
    int minBlue = 255;
    int maxRed = 0;
    int maxGreen = 0;
    int maxBlue = 0;
    double coefRed;
    double coefGreen;
    double coefBlue;

    protected void getMinColors() {
        for (int y=0; y<selection.getHeight(); y++) {
            for (int x=0; x<selection.getWidth(); x++) {
                Color color = pixelReader.getColor(x, y);
                int currentRed = (int) (color.getRed() * 255);
                int currentGreen = (int) (color.getGreen() * 255);
                int currentBlue = (int) (color.getBlue() * 255);
                if (currentRed < minRed) {
                    minRed = currentRed;
                }
                if (currentGreen < minGreen) {
                    minGreen = currentGreen;
                }
                if (currentBlue < minBlue) {
                    minBlue = currentBlue;
                }
            }
        }
    }

    protected void getMaxColors() {
        for (int y = selection.getStartY(); y < selection.getHeight(); y++) {
            for (int x = selection.getStartX(); x < selection.getWidth();  x++) {
                Color color = pixelReader.getColor(x, y);
                int currentRed = (int) (color.getRed() * 255);
                int currentGreen = (int) (color.getGreen() * 255);
                int currentBlue = (int) (color.getBlue() * 255);

                if (currentRed > maxRed) {
                    maxRed = currentRed;
                };
                if (currentGreen > maxGreen) {
                    maxGreen = currentGreen;
                }
                if (currentBlue > maxBlue) {
                    maxBlue = currentBlue;
                }
            }
        }
    }

    protected void preEvaluating() {
    }

    @Override
    protected void proceedEffect() {
        getMaxColors();
        getMinColors();
        preEvaluating();
    }
}
