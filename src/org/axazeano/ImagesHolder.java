package org.axazeano;

import javafx.scene.image.Image;
import org.axazeano.effects.Selection;

import java.util.Observable;

/**
 * Created by vladimir on 14.05.2016.
 */

public class ImagesHolder extends Observable {

    private Image originalImage;
    private Image modifiedImage;
    public boolean shouldBeUpdatedBoth;
    private Selection selection = Selection.INSTANCE;

    public Image getOriginalImage() {
        return originalImage;
    }

    public Image getModifiedImage() {
        return modifiedImage;
    }

    public void setModifiedImage(Image modifiedImage) {
        this.modifiedImage = modifiedImage;
        shouldBeUpdatedBoth = false;
        setChanged();
        notifyObservers();
    }

    public static final ImagesHolder INSTANCE = new ImagesHolder();

    public void loadImage(String filePath) {
        originalImage = new Image("file:"+filePath);
        modifiedImage = new Image("file:"+filePath);
        shouldBeUpdatedBoth = true;
        selection.updateSelection(0, 0, (int) modifiedImage.getWidth(), (int) modifiedImage.getHeight());
        setChanged();
        notifyObservers();
    }
}
