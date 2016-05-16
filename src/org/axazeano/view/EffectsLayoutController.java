package org.axazeano.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import org.axazeano.effects.EffectAction;
import org.axazeano.effects.EffectsHolder;
import org.axazeano.ImagesHolder;
import org.axazeano.Main;

/**
 * Created by vladimir on 15.05.2016.
 */
public class EffectsLayoutController {
    private Main mainApp;
    private ImagesHolder imagesHolder = ImagesHolder.INSTANCE;
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


    @FXML
    public void initialize() {
        transformEffects.addAll("Rotate", "Scale");
        transform.setItems(transformEffects);

        colorCorrectionEffects.addAll("Greyscale", "Greyworld");
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
        }
        effect.operation(effectSettings);
    }
}
