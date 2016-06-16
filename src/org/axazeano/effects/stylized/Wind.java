package org.axazeano.effects.stylized;

import org.axazeano.EditableImage;
import org.axazeano.effects.BaseEffectOneParam;
import org.axazeano.effects.Direction;
import org.axazeano.effects.EffectInterface;

import java.util.Random;

/**
 * Created by vladimir on 24.05.2016.
 */
public class Wind extends BaseEffectOneParam implements EffectInterface {
    static {
        name = "Wind";
        description = "Wind noize";
        firstParameter = "strength";
    }

    private Direction direction;
    private int size;
    private Random random;

    public Wind(EditableImage inputImage) {
        super(inputImage);
    }

    public void setValues(Direction direction, int size) {
        this.direction = direction;
        this.size = size;
    }

    @Override
    public void setValues() {

    }

    @Override
    public int[] performEffect() {
        return new int[0];
    }
}
