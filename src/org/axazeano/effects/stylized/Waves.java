package org.axazeano.effects.stylized;

import javafx.scene.paint.Color;
import org.axazeano.effects.BaseEffect;
import org.axazeano.effects.BaseEffectThreeParam;

import java.util.Random;

import static org.bytedeco.javacpp.avutil.M_PI;

/**
 * Created by vladimir on 01.06.2016.
 */


/**
 * Wave effects
 */
public class Waves extends BaseEffectThreeParam {
    static {
        name = "Waves";
        description = "Waves efffect";
        firstParameter = "Count";
        secondParameter = "Strength";
        thirdParameter = "Type";
    }
    public enum WaveType {
        Horizontal,
        Vertical,
        ZigZag
    }


    /**
     * Count of waves
     */
    private int count;
    /**
     * Strength of waves
     */
    private int strength;
    /**
     * Type of waves. Can be Horizontal, Vertical, ZigZag
     */
    private WaveType waveType;
    private Random random;


    public Waves() {
        super();
        random = new Random();
    }

    public void setValues(int count, int strength, WaveType waveType) {
        this.count = count;
        this.strength = strength;
        this.waveType = waveType;
    }

    @Override
    protected void proceedEffect() {
        for (int y = selection.getStartY(); y < selection.getHeight(); y++) {
            for (int x = selection.getStartX(); y < selection.getWidth(); x++) {
                switch (waveType) {
                    case Horizontal:
                        Horizontal();
                        break;
                    case Vertical:
                        Vertical();
                        break;
                    case ZigZag:
                        ZigZag();
                        break;
                }
            }
        }
    }

    private void Horizontal() {
        int newCoordinate;
        for (int y = selection.getStartY(); y < selection.getHeight(); y++) {
            for (int x = selection.getStartX(); y < selection.getWidth(); x++) {
                newCoordinate = (int) (x + strength * Math.sin(2 * M_PI * y / count));
                Color color  = pixelReader.getColor(x, y);
                if (newCoordinate < selection.getHeight() && newCoordinate >= selection.getStartY()) // out of bounds checks
                    pixelWriter.setColor(x, y, color);
            }
        }
    }

    private void Vertical() {
        int newCoordinate;
        for (int y = selection.getStartY(); y < selection.getHeight(); y++) {
            for (int x = selection.getStartX(); y < selection.getWidth(); x++) {
                newCoordinate = (int) (y + strength * Math.sin(2 * M_PI * x / count));
                Color color  = pixelReader.getColor(x, y);
                if (newCoordinate < selection.getWidth() && newCoordinate >= selection.getStartX()) // out of bounds checks
                    pixelWriter.setColor(x, y, color);
            }
        }

    }

    private void ZigZag() {
        int newCoordinate;
        for (int y = selection.getStartY(); y < selection.getHeight(); y++) {
            for (int x = selection.getStartX(); y < selection.getWidth(); x++) {
                newCoordinate = (int) (y + strength * Math.cos(2 * M_PI * x / count));
                Color color  = pixelReader.getColor(x, y);
                if (newCoordinate < selection.getWidth() && newCoordinate >= selection.getStartX()) // out of bounds checks
                    pixelWriter.setColor(x, y, color);
            }
        }
        approximateZigZag();
    }

    private void approximateZigZag() {
        for (int y = selection.getStartY(); y < selection.getHeight(); y++) {
            for (int x = selection.getStartX(); y < selection.getWidth(); x++) {

                // Getting color of current pixel
                Color color = pixelReader.getColor(x, y);

                // Looking for empty pixels.
                if (color.getOpacity() == 0) {
                    // Approximating this pixel.
                    int coordinateOfSource = (int) (x - this.strength * Math.cos(2 * M_PI * x / this.count));
                    // Out of bounds check.
                    if (coordinateOfSource >= selection.getWidth() || coordinateOfSource < 0 ||
                            y >= selection.getHeight() || y < 0)
                        continue;

                    // Applying approximation for pixel.
                    color = pixelReader.getColor(coordinateOfSource, y);
                    pixelWriter.setColor(x, y, color);
                }
            }
        }
    }
}
