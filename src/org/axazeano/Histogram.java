package org.axazeano;

import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import javafx.scene.paint.Color;
import org.axazeano.history.HistoryHolder;

import java.lang.reflect.Array;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by vladimir on 15.05.2016.
 */
public class Histogram extends Observable implements Observer {
    public int[] getRed() {
        return red;
    }

    public int[] getGreen() {
        return green;
    }

    public int[] getBlue() {
        return blue;
    }

    public int[] getLightness() {
        return lightness;
    }

    private int[] red;
    private int[] green;
    private int[] blue;
    private int[] lightness;
    private PixelReader pixelReader;
    private HistoryHolder history = HistoryHolder.INSTANCE;
    
    public static final Histogram INSTANCE = new Histogram();


    public Histogram() {
        cleanHistogram();
    }

    private void cleanHistogram() {
        red = new int[256];
        green = new int[256];
        blue = new int[256];
        lightness = new int[256];
    }

    @Override
    public void update(Observable o, Object arg) {
        cleanHistogram();
        pixelReader = history.getCurrentImage().getPixelReader();
        recalculateHistogram();
        setChanged();
        notifyObservers();
    }

    private void recalculateHistogram() {
        Image image = history.getCurrentImage();
        int height = (int) image.getHeight();
        int width = (int) image.getWidth();
        for (int y=0; y < height; y++) {
            for (int x=0; x < width; x++) {
                Color color = pixelReader.getColor(x, y);
                red[(int) (color.getRed() * 255)]++;
                green[(int) (color.getGreen() * 255)]++;
                blue[(int) (color.getBlue() * 255)]++;
                lightness[Math.min((int) ((color.getRed() + color.getGreen() + color.getBlue()) / 3  * 255), 255)]++;
            }
        }
    }
}
