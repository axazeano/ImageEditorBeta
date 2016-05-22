package org.axazeano.history;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.image.Image;

/**
 * Created by vladimir on 18.05.2016.
 */
public class HistoryItem {
    private SimpleStringProperty name;
    private SimpleBooleanProperty isTemporary;
    private Image state;

    public void setTemporary(boolean temporary) {
        isTemporary = new SimpleBooleanProperty(temporary);
    }

    public String getName() {
        return name.getValue();
    }

    public Image getState() {
        return state;
    }

    public boolean isTemporary() {
        return isTemporary.getValue();
    }

    public HistoryItem(String name, Image state, boolean isTemporary) {
        this.name = new SimpleStringProperty(name);
        this.state = state;
        this.isTemporary = new SimpleBooleanProperty(isTemporary);
    }
}
