package org.axazeano.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import org.axazeano.effects.BaseEffect;
import org.axazeano.history.HistoryHolder;

/**
 * Created by vladimir on 15.05.2016.
 */
public class SimpleEffectSettingsLayoutController {
    protected BaseEffect effect;

    private HistoryHolder history = HistoryHolder.INSTANCE;

    public void setParent(Pane parent) {
        this.parent = parent;
    }

    protected Pane parent;

    @FXML
    protected AnchorPane pane;

    @FXML
    protected ProgressIndicator progressIndicator;

    @FXML
    protected Button okButton;

    @FXML
    protected Button cancelButton;

    @FXML
    protected Button previewButton;

    @FXML
    protected Label effectName;

    @FXML
    protected Label effectDescription;

    @FXML
    public void initialize() {
        cancelButton.setStyle("-fx-base: red;");
        effectName.setText("Rotate");
        effectDescription.setText("Rotate image");
    }

    @FXML
    public void handlePreview() {
        effect.applyEffect();
    }

    @FXML
    public void handleApply() {
        if (history.getCurrentItem().isTemporary()) {
            history.applyEffect();
        } else {
            effect.applyEffect();
            history.applyEffect();
        }
    }

    @FXML
    public void handleCancel() {
        parent.getChildren().remove(0);
        if (history.getCurrentItem().isTemporary()) {
            history.removeCurrentElement();
        }
    }

    public void setEffect(BaseEffect effect) {
        this.effect = effect;
        effectName.setText(this.effect.name);
        effectDescription.setText(this.effect.description);
    }
}
