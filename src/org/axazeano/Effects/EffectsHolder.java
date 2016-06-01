package org.axazeano.effects;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import org.axazeano.effects.colorCorrection.*;
import org.axazeano.Main;
import org.axazeano.effects.colorCorrection.transform.Rotate;
import org.axazeano.view.OneControlEffectSettingsController;
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

        effectsList.put("Rotate", (AnchorPane parent) -> {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(mainApp.getClass().getResource(EffectsSettingLayouts.OneControlEffectSettings));
            try {
                AnchorPane effect = loader.load();
                OneControlEffectSettingsController controller = loader.getController();
                Rotate rotate = new Rotate();
                controller.setEffect(rotate);
                parent.getChildren().add(effect);
                controller.setParent(parent);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        effectsList.put("Linear Correction", (AnchorPane parent) -> {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(mainApp.getClass().getResource(EffectsSettingLayouts.SimpleEffectSettingsLayout));
            try {
                AnchorPane effect = loader.load();
                SimpleEffectSettingsLayoutController controller = loader.getController();
                controller.setEffect(new LinearCorrection());
                parent.getChildren().add(effect);
                controller.setParent(parent);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        effectsList.put("Root Correction", (AnchorPane parent) -> {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(mainApp.getClass().getResource(EffectsSettingLayouts.SimpleEffectSettingsLayout));
            try {
                AnchorPane effect = loader.load();
                SimpleEffectSettingsLayoutController controller = loader.getController();
                controller.setEffect(new RootCorrection());
                parent.getChildren().add(effect);
                controller.setParent(parent);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        effectsList.put("Log Correction", (AnchorPane parent) -> {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(mainApp.getClass().getResource(EffectsSettingLayouts.SimpleEffectSettingsLayout));
            try {
                AnchorPane effect = loader.load();
                SimpleEffectSettingsLayoutController controller = loader.getController();
                controller.setEffect(new LogCorrection());
                parent.getChildren().add(effect);
                controller.setParent(parent);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        effectsList.put("Square Correction", (AnchorPane parent) -> {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(mainApp.getClass().getResource(EffectsSettingLayouts.SimpleEffectSettingsLayout));
            try {
                AnchorPane effect = loader.load();
                SimpleEffectSettingsLayoutController controller = loader.getController();
                controller.setEffect(new SquareCorrection());
                parent.getChildren().add(effect);
                controller.setParent(parent);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        effectsList.put("Cube Correction", (AnchorPane parent) -> {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(mainApp.getClass().getResource(EffectsSettingLayouts.SimpleEffectSettingsLayout));
            try {
                AnchorPane effect = loader.load();
                SimpleEffectSettingsLayoutController controller = loader.getController();
                controller.setEffect(new CubeCorrection());
                parent.getChildren().add(effect);
                controller.setParent(parent);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
