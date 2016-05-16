package org.axazeano.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import org.axazeano.effects.BaseEffect;

/**
 * Created by vladimir on 15.05.2016.
 */
public class SimpleEffectSettingsLayoutController {
    public void setEffect(BaseEffect effect) {
        this.effect = effect;
        effectName.setText(this.effect.name);
        effectDescription.setText(this.effect.description);
    }

    private BaseEffect effect;
    private String name;
    private String description;

    public void setParent(Pane parent) {
        this.parent = parent;
    }

    private Pane parent;

    @FXML
    private AnchorPane pane;

    @FXML
    private ProgressIndicator progressIndicator;

    @FXML
    private Button okButton;

    @FXML
    private Button cancelButton;

    @FXML
    private Button previewButton;

    @FXML
    private Label effectName;

    @FXML
    private Label effectDescription;

//    public SimpleEffectSettingsLayoutController(BaseEffect effect) {
//        this.name = effect.name;
//        this.description = effect.description;
//        this.effect = effect;
//    }

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

    @FXML void handleCancel() {
        parent.getChildren().remove(0);
    }
}
