package org.axazeano;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.axazeano.effects.EffectsHolder;
import org.axazeano.view.EffectsLayoutController;
import org.axazeano.view.HistogramLayoutController;
import org.axazeano.view.RootLayoutController;

import java.io.IOException;

public class Main extends Application {

    private Stage primaryStage;
    private AnchorPane rootLayout;
    private RootLayoutController rootLayoutController;
    private EffectsLayoutController effectsLayoutController;
    private HistogramLayoutController histogramLayoutController;
    private ImagesHolder imagesHolder = ImagesHolder.INSTANCE;
    private Histogram histogram = Histogram.INSTANCE;
    private EffectsHolder effectsHolder = EffectsHolder.INSTANCE;


    @Override
    public void start(Stage primaryStage) throws Exception{

        imagesHolder.addObserver(histogram);
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Image Editor Beta");


        initRootLayout();
        initEffectsLayout();
        initHistogramLayout();
        effectsHolder.setMainApp(this);

    }

    private void initRootLayout() {
        try {
            // Загружаем сведения об адресатах.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/RootLayout.fxml"));
            rootLayout = (AnchorPane) loader.load();

            // Отображаем сцену, содержащую корневой макет.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            rootLayoutController = loader.getController();
            imagesHolder.addObserver(rootLayoutController);
            rootLayoutController.setMainApp(this);

            primaryStage.show();

            // Помещаем сведения об адресатах в центр корневого макета.
//            rootLayout.setCenter(personOverview);
//
//            PersonOverviewController controller = loader.getController();
//            controller.setMainApp(this);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void initEffectsLayout() {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("view/EffectsLayout.fxml"));
        try {
            AnchorPane effectsTab = (AnchorPane) loader.load();
            rootLayoutController.effectsTab.setContent(effectsTab);

            effectsLayoutController = loader.getController();
            effectsLayoutController.setMainApp(this);

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private void initHistogramLayout() {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("view/HistogramLayout.fxml"));
        try {
            AnchorPane histogramTab = (AnchorPane) loader.load();
            rootLayoutController.histogramTab.setContent(histogramTab);

            histogramLayoutController = loader.getController();
            histogramLayoutController.setMainApp(this);
            histogram.addObserver(histogramLayoutController);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }
}
