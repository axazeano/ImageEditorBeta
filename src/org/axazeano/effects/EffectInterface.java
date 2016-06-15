package org.axazeano.effects;

import org.axazeano.EditableImage;

/**
 * Created by vladimir on 15.06.16.
 */
public interface EffectInterface {
    default void applyEffect(EditableImage inputImage) {
        inputImage.setImageByPixelsArray(performEffect());
    }

    int[] performEffect();
}
