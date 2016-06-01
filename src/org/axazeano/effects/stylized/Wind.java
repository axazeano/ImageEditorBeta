package org.axazeano.effects.stylized;

import org.axazeano.effects.BaseEffectOneParam;
import org.axazeano.effects.Direction;

import java.util.Random;

/**
 * Created by vladimir on 24.05.2016.
 */
public class Wind extends BaseEffectOneParam{
    static {
        name = "Wind";
        description = "Wind noize";
        firstParameter = "strength";
    }

    private Direction direction;
    private int size;
    private Random random;

    public Wind() {
        super();
    }

    public void setValues(Direction direction, int size) {

    }
}
