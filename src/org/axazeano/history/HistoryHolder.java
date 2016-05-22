package org.axazeano.history;

import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

/**
 * Created by vladimir on 18.05.2016.
 */
public class HistoryHolder extends Observable {
    private List<HistoryItem> history;

    private int head;
    public static HistoryHolder INSTANCE = new HistoryHolder();
    private HistoryHolder() {
        history = new ArrayList<HistoryItem>();
        head = -1;
    }

    public void undo() {
        if (head > 0) {
            head--;
            setChanged();
            notifyObservers();
        }
    }

    public List<HistoryItem> getHistory() {
        return history;
    }

    public void redo() {
        if (head < history.size()) {
            head++;
            setChanged();
            notifyObservers();
        }
    }
    public void add(HistoryItem newItem) {
        head++;
        history.add(newItem);
        setChanged();
        notifyObservers();
    }

    public void clear() {
        head = 0;
        history.clear();
        setChanged();
        notifyObservers();
    }

    public HistoryItem getCurrentItem() {
        return history.get(head);
    }

    public Image getCurrentImage() {
        return history.get(head).getState();
    }

    public HistoryItem getOriginalItem() {
        return history.get(0);
    }

    public Image getOriginalImage() {
        return history.get(0).getState();
    }

    public void applyEffect() {
        history.get(head).setTemporary(false);
    }

    public void removeCurrentElement() {
        history.remove(head);
        head--;
    }
}
