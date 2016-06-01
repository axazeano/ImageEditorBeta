package org.axazeano.effects.stylized;

import javafx.scene.paint.Color;
import org.axazeano.effects.BaseEffectOneParam;
import org.axazeano.effects.Direction;

import java.util.Random;

/**
 * Created by vladimir on 01.06.2016.
 */
public class Glass extends BaseEffectOneParam {
    static {
        name = "Glass";
        description = "Glass effect";
        firstParameter = "Strength";
    }

    private int strength;
    private Direction direction;
    private Random random;

    public void setValues(int strength) {
        this.strength = strength;
    }

    public Glass() {
        super();
        random = new Random();
    }

    @Override
    protected void proceedEffect() {
        for (int x = selection.getStartX(); x < selection.getWidth(); x++) {
            for (int y = selection.getStartY(); y < selection.getHeight(); y++) {
                switch (direction) {
                    case UP:
                        up();
                        break;
                    case DOWN:
                        down();
                        break;
                    case RIGHT:
                        right();
                        break;
                    case LEFT:
                        left();
                        break;
                }
            }
        }
    }

    private void left() {
        for (int x = selection.getStartX(); x < selection.getWidth(); x++) {
            for (int y = selection.getStartY(); y < selection.getHeight(); y++) {
                // Random shift.
                int newX = x - (random.nextInt() % this.strength + 1);
                // Getting color of current pixel
                Color color = pixelReader.getColor(x, y);
                // Applying color for new prepared matrix's pixel.
                if (newX > 0 && newX < selection.getWidth() && y > 0 && y < selection.getHeight()) {
                    pixelWriter.setColor(newX, y, color);
                }
            }
        }
    }

    private void right() {
        for (int x = selection.getWidth() - 1; x > selection.getStartX(); x--) {
            for (int y = selection.getStartY(); y < selection.getHeight(); y++) {
                // Random shift.
                int newX = x + (random.nextInt() % strength + 1);
                // Getting color of current pixel
                Color color = pixelReader.getColor(x, y);
                // Applying color for new prepared matrix's pixel.
                if (newX > 0 && newX < selection.getWidth() && y > 0 && y < selection.getHeight()) {
                    pixelWriter.setColor(newX, y, color);
                }
            }
        }
    }

    private void up() {
        for (int x = selection.getStartX(); x < selection.getWidth(); x++) {
            for (int y = selection.getStartY(); y < selection.getHeight(); y++) {
                // Random shift.
                int newY = y - (random.nextInt() % strength + 1);
                // Getting color of current pixel
                Color color = pixelReader.getColor(x,y);
                // Applying color for new prepared matrix's pixel.
                if (x > 0 && x < selection.getWidth() && newY > 0 && newY < selection.getHeight()) {
                    pixelWriter.setColor(x, newY, color);
                }
            }
        }
    }

    private void down() {
        for (int x = selection.getStartX(); x < selection.getWidth(); x++) {
            for (int y = selection.getHeight() - 1; y > selection.getStartY(); y--) {
                // Random shift.
                int newY = y + (random.nextInt() % this.strength + 1);
                // Getting color of current pixel
                Color color = pixelReader.getColor(x,y);
                // Applying color for new prepared matrix's pixel.
                if (x > 0 && x < selection.getWidth() && newY > 0 && newY < selection.getHeight()) {
                    pixelWriter.setColor(x, newY, color);
                }
            }
        }
    }

//    private int approximate() {
//        for (int x = 0; x < selection.getWidth(); x++) {
//            for (int y = 0; y < selection.getHeight(); y++) {
//                // Checking pixel.
//                Color color = pixelReader.getColor(x, y);
//                if (color.getOpacity() == 0) {
//                    // Approximating pixel by source.
//                    color = tempImageToProcess.pixel(x, y);
//                    resultImage.setPixel(x, y, color);
//                }
//            }
//        }
//
//    }

}
