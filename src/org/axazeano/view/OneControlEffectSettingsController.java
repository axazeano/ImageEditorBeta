package org.axazeano.view;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import org.axazeano.effects.BaseEffect;
import org.axazeano.effects.BaseEffectOneParam;

/**
 * Created by vladimir on 17.05.2016.
 */
public class OneControlEffectSettingsController extends SimpleEffectSettingsLayoutController{

    protected BaseEffectOneParam effect;
    @FXML
    private Label parameterName;

    @FXML
    private Spinner<Integer> parameterValue;

    @FXML
    public void initialize() {
        cancelButton.setStyle("-fx-base: red;");
    }

    public void setEffect(BaseEffectOneParam effect) {

        this.effect = effect;
        effectName.setText(this.effect.name);
        effectDescription.setText(this.effect.description);
        parameterName.setText(this.effect.firstParameter);
    }

    public void handlePreview() {
        int value = parameterValue.getValue();
//        effect.setValues(value);
        super.handlePreview();
    }

}
