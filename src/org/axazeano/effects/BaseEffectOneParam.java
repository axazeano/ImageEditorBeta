package org.axazeano.effects;

/**
 * Created by vladimir on 17.05.2016.
 */
/**
 * The effect, which takes one parameter
 */
public class BaseEffectOneParam extends BaseEffect {
    public static String firstParameter;

    /**
     * Set parameters via this method, because constructor will be fired when effect will selected from list.
     * Override it!
     */
    public void setValues() {
    }
}
