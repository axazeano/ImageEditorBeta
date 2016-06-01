package org.axazeano.view;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import org.axazeano.effects.EffectAction;
import org.axazeano.effects.EffectsHolder;
import org.axazeano.ImagesHolder;
import org.axazeano.Main;
import org.axazeano.history.HistoryHolder;

import java.util.Optional;

/**
 * Created by vladimir on 15.05.2016.
 */
public class EffectsLayoutController {
    private Main mainApp;
    private HistoryHolder history = HistoryHolder.INSTANCE;
    private EffectsHolder effectsHolder = EffectsHolder.INSTANCE;
    private static final ObservableList<String> transformEffects =
            FXCollections.observableArrayList();

    public static final ObservableList<String> stylizedEffects =
            FXCollections.observableArrayList();

    public static final ObservableList colorCorrectionEffects =
            FXCollections.observableArrayList();



    @FXML
    private ListView<String> colorCorrection;

    @FXML
    ListView stylized;

    @FXML
    ListView transform;

    @FXML
    private AnchorPane effectSettings;



    private void showCancelDialog() {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Confirmation Dialog");
        alert.setHeaderText("Cancel dialog");
        alert.setContentText("Do you want cancel this effect?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
            history.removeCurrentElement();
        } else {
            alert.close();
        }
    }

    @FXML
    public void initialize() {

        colorCorrection.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (history.getCurrentItem().isTemporary()) {
                    showCancelDialog();
                }
            }
        });

        transformEffects.addAll("Rotate", "Scale");
        transform.setItems(transformEffects);

        colorCorrectionEffects.addAll("Greyscale", "Greyworld", "Linear Correction", "Root Correction", "Log Correction", "Square Correction", "Cube Correction");
        colorCorrection.setItems(colorCorrectionEffects);


        transform.getSelectionModel()
                .selectedItemProperty()
                .addListener((observable, oldValue, newValue) -> loadEffectLayout((String) newValue));

        colorCorrection.getSelectionModel()
                .selectedItemProperty()
                .addListener((observable, oldValue, newValue) -> loadEffectLayout((String) newValue));

    }

    public void setMainApp(Main mainApp) {
        this.mainApp = mainApp;
    }

    private void loadEffectLayout(String name) {
        effectSettings.getChildren().clear();
        EffectAction effect = null;
        switch (name) {
            case "Greyscale":
                effect = effectsHolder.effectsList.get("Greyscale");
                break;
            case "Greyworld":
                effect = effectsHolder.effectsList.get("Greyworld");
                break;
            case "Rotate":
                effect = effectsHolder.effectsList.get("Rotate");
                break;
            case "Linear Correction":
                effect = effectsHolder.effectsList.get("Linear Correction");
                break;
            case "Root Correction":
                effect = effectsHolder.effectsList.get("Root Correction");
                break;
            case "Log Correction":
                effect = effectsHolder.effectsList.get("Log Correction");
                break;
            case "Square Correction":
                effect = effectsHolder.effectsList.get("Square Correction");
                break;
            case "Cube Correction":
                effect = effectsHolder.effectsList.get("Cube Correction");
                break;
        }
        effect.operation(effectSettings);
    }
}
