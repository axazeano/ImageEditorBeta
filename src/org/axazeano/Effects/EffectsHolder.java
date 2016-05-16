package org.axazeano.effects;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import org.axazeano.effects.stylized.Greyscale;
import org.axazeano.effects.stylized.Greyworld;
import org.axazeano.Main;
import org.axazeano.view.SimpleEffectSettingsLayoutController;

import java.io.IOException;
import java.util.HashMap;


/**
 * Created by vladimir on 16.05.2016.
 */
public class EffectsHolder {

    private Main mainApp;

    public void setMainApp(Main mainApp) {
        this.mainApp = mainApp;
    }
    public HashMap<String, EffectAction> effectsList = new HashMap<>();

    public static final EffectsHolder INSTANCE = new EffectsHolder();

    private EffectsHolder() {
        effectsList.put("Greyscale", (AnchorPane parent) -> {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(mainApp.getClass().getResource(EffectsSettingLayouts.SimpleEffectSettingsLayout));
            try {
                AnchorPane effect = loader.load();
                SimpleEffectSettingsLayoutController controller = loader.getController();
                controller.setEffect(new Greyscale());
                parent.getChildren().add(effect);
                controller.setParent(parent);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        );

        effectsList.put("Greyworld", (AnchorPane parent) -> {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(mainApp.getClass().getResource(EffectsSettingLayouts.SimpleEffectSettingsLayout));
            try {
                AnchorPane effect = loader.load();
                SimpleEffectSettingsLayoutController controller = loader.getController();
                controller.setEffect(new Greyworld());
                parent.getChildren().add(effect);
                controller.setParent(parent);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
