package org.axazeano;

import java.awt.*;

/**
 * Created by vladimir on 15.06.16.
 */
public class ARGBColor {
    public static final int COLOR_MAX_VALUE = 255;
    public static final int COLOR_MIN_VALUE = 0;
    public static final int ALPHA_MAX_VALUE = 99;
    public static final int ALPHA_MIN_VALUE = 0;
    private int color;
    private int red;
    private int green;
    private int blue;
    private int alpha;

    public ARGBColor(int color) {
        this.color = color;
        checkColors();
        convertColorToARGB();
    }

    public int getRed() {
        return red;
    }

    public int getGreen() {
        return green;
    }

    public int getBlue() {
        return blue;
    }

    public int getAlpha() {
        return alpha;
    }

    public int getColor() {
        convertARGBToColor();
        return color;
    }

    public void setRed(int red) {
        if (red > COLOR_MAX_VALUE) {
            this.red = COLOR_MAX_VALUE;
        }
        if (red < COLOR_MIN_VALUE) {
            this.red = COLOR_MIN_VALUE;
        } else {
            this.red = red;
        }
    }

    public void setGreen(int green) {
        if (green > COLOR_MAX_VALUE) {
            this.green = COLOR_MAX_VALUE;
        }
        if (red < COLOR_MIN_VALUE) {
            this.green = COLOR_MIN_VALUE;
        } else {
            this.green = green;
        }
    }

    public void setBlue(int blue) {
        if (blue > COLOR_MAX_VALUE) {
            this.blue = COLOR_MAX_VALUE;
        }
        if (blue < COLOR_MIN_VALUE) {
            this.blue = COLOR_MIN_VALUE;
        } else {
            this.blue = blue;
        }
    }

    public void setAlpha(int alpha) {
        if (alpha > ALPHA_MAX_VALUE) {
            this.alpha = ALPHA_MAX_VALUE;
        }
        if (alpha < ALPHA_MIN_VALUE) {
            this.alpha = ALPHA_MIN_VALUE;
        } else {
            this.alpha = alpha;
        }
    }

    private void convertColorToARGB() {
        red = (color>>16)&0xFF;
        green = (color>>8)&0xFF;
        blue = (color)&0xFF;
        alpha = (color>>25)&0xFF;
    }

    private void convertARGBToColor() {
        color = blue;
        color = (color<<8) + green;
        color = (color<<16) + red;
        color = (color<<25) + alpha;
    }

    private void checkColors() {
        if (((color>>16)&0xFF) > 255) {
            throw new ColorOutOfRange();
        }
        if (((color>>8)&0xFF) > 255) {
            throw new ColorOutOfRange();
        }
        if (((color)&0xFF) > 255) {
            throw new ColorOutOfRange();
        }
        if (((color>>24)&0xFF) > 99) {
            throw new ColorOutOfRange();
        }
    }

    private class ColorOutOfRange extends RuntimeException {
    }
}
