package org.axazeano.effects;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import org.axazeano.effects.colorCorrection.*;
import org.axazeano.Main;
import org.axazeano.effects.colorCorrection.transform.Rotate;
import org.axazeano.effects.stylized.Glass;
import org.axazeano.view.OneControlEffectSettingsController;
import org.axazeano.view.SimpleEffectSettingsLayoutController;
import org.bytedeco.javacpp.presets.opencv_core;

import java.io.IOException;
import java.util.HashMap;


/**
 * Created by vladimir on 16.05.2016.
 */
/**
 * HoHoHo!
 * Singleton, which knows all effects and returns configured pane by effect name
 */
public class EffectsHolder {
    public static class EffectsNames {
        // Color correction effects
        public static final String greyscale = "Greyscale";
        public static final String greyworld = "Grey world";
        public static final String linearCorrection = "Linear Correction";
        public static final String rootCorrection = "Root Correction";
        public static final String logCorrection = "Log Correction";
        public static final String squareCorrection = "Square Correction";
        public static final String cubeCorrection = "Cube Correction";

        // Stylized effects
        public static final String glass = "Glass";
        public static final String pixelezation = "Pizelezation";
        public static final String randomJitter = "Random Jitter";
        public static final String waves = "Waves";
        public static final String wind = "Wind";

        //Transform effects
        public static final String rotate = "Rotate";
    }
    /**
     * Link to main app
     */
    private Main mainApp;

    public void setMainApp(Main mainApp) {
        this.mainApp = mainApp;
    }
    public HashMap<String, EffectAction> effectsList = new HashMap<>();

    public static final EffectsHolder INSTANCE = new EffectsHolder();

    /**
     * All effects will be added in the constructor
     */
    private EffectsHolder() {
        effectsList.put(EffectsNames.greyscale, (AnchorPane parent) -> {
            // Load FXML
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(mainApp.getClass().getResource(EffectsSettingLayouts.SimpleEffectSettingsLayout));
            try {
                // Create pane with effect
                AnchorPane effect = loader.load();
                // Create a controller for pane
                SimpleEffectSettingsLayoutController controller = loader.getController();
                // Add an effect
                controller.setEffect(new Greyscale());
                // Pass a link to parent pane. It use for dismiss this pane.
                parent.getChildren().add(effect);
                controller.setParent(parent);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        );

        effectsList.put(EffectsNames.greyworld, (AnchorPane parent) -> {
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

        effectsList.put(EffectsNames.rotate, (AnchorPane parent) -> {
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

        effectsList.put(EffectsNames.linearCorrection, (AnchorPane parent) -> {
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

        effectsList.put(EffectsNames.rootCorrection, (AnchorPane parent) -> {
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

        effectsList.put(EffectsNames.logCorrection, (AnchorPane parent) -> {
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

        effectsList.put(EffectsNames.squareCorrection, (AnchorPane parent) -> {
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

        effectsList.put(EffectsNames.cubeCorrection, (AnchorPane parent) -> {
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

        effectsList.put(EffectsNames.glass, (AnchorPane parent) -> {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(mainApp.getClass().getResource(EffectsSettingLayouts.SimpleEffectSettingsLayout));
            try {
                AnchorPane effect = loader.load();
                SimpleEffectSettingsLayoutController controller = loader.getController();
                controller.setEffect(new Glass());
                parent.getChildren().add(effect);
                controller.setParent(parent);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
