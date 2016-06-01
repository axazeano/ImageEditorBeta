package org.axazeano.view;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Tab;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.FileChooser;
import org.axazeano.ImagesHolder;
import org.axazeano.Main;
import org.axazeano.effects.Selection;
import org.axazeano.history.HistoryHolder;
import org.axazeano.history.HistoryItem;

import java.util.Objects;
import java.util.Observable;
import java.util.Observer;

import static java.lang.Math.abs;

/**
 * Created by vladimir on 14.05.2016.
 */
public class RootLayoutController implements Observer {

    private Main mainApp;
    private ImagesHolder imagesHolder = ImagesHolder.INSTANCE;
    private HistoryHolder history = HistoryHolder.INSTANCE;
    private Selection selection = Selection.INSTANCE;

    @FXML
    private ImageView originalImage;

    @FXML
    private ImageView modifiedImage;

    @FXML
    public Tab effectsTab;

    @FXML
    public Tab histogramTab;

    @FXML
    public Tab historyTab;

    @FXML
    public AnchorPane rootPane;


    public void setMainApp(Main mainApp) {
        this.mainApp = mainApp;
    }

    private Rectangle selectionRectangle;

    private double initX;
    private double initY;
    private double endX;
    private double endY;
    private double scaleX;
    private double scaleY;


    @FXML
    public void initialize() {
        originalImage.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent me) {
                if (me.getSceneX() > 0 && me.getSceneY() > 0) {
                    initX = me.getSceneX();
                    initY = me.getSceneY();
                    me.consume();
                }
            }
        });
        originalImage.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent me) {
                // Normalize values
                if (me.getSceneX() > originalImage.getBoundsInParent().getMaxX()) {
                    endX = originalImage.getBoundsInParent().getMaxX();
                } else if (me.getSceneX() < 0) {
                    endX = 0;
                } else {
                    endX = me.getSceneX();
                }

                if (me.getSceneY() > originalImage.getBoundsInParent().getMaxY()) {
                    endY = originalImage.getBoundsInParent().getMaxY();
                } else if (me.getSceneY() < 0) {
                    endY = 0;
                } else {
                    endY = me.getSceneY();
                }

//                if (endY < initY) {
//                    double tmp = endY;
//                    endY = initY;
//                    initY = tmp;
//                }
//
//                if (endX < initX) {
//                    double tmp = endX;
//                    endX = initX;
//                    initX = tmp;
//                }
                drawSelectionRectangle();
            }
        });
    }

    @FXML
    private void handleRemoveSelection() {
        removeSelectionRectangle();
    }

    private void removeSelectionRectangle() {
        rootPane.getChildren().remove(selectionRectangle);
    }

    private void calculateScaleFactor() {
        scaleX = imagesHolder.getOriginalImage().getWidth() / originalImage.getBoundsInParent().getWidth();
        scaleY = imagesHolder.getOriginalImage().getHeight() / originalImage.getBoundsInParent().getHeight();
    }

    private void drawSelectionRectangle() {
        removeSelectionRectangle();

        selectionRectangle = new Rectangle(initX, initY, abs(endX - initX), abs(endY - initY));
        selectionRectangle.setFill(null);
        selectionRectangle.setStroke(Color.RED);
        selectionRectangle.setStrokeWidth(2);

        rootPane.getChildren().add(selectionRectangle);
    }

    @FXML
    private void handleOpen() {
        FileChooser fileChooser = new FileChooser();
        String fileName = fileChooser.showOpenDialog(mainApp.getPrimaryStage()).getAbsolutePath();
        if (!Objects.equals(fileName, "")) {
            loadImage(fileName);
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        modifiedImage.setImage(history.getCurrentImage());
    }

    private void loadImage(String filePath) {
        history.add(new HistoryItem("Load image", new Image("file:"+filePath), false));
        originalImage.setImage(history.getOriginalImage());
        modifiedImage.setImage(history.getOriginalImage());
        selection.updateSelection(0, 0, (int) history.getCurrentImage().getWidth(), (int) history.getCurrentImage().getHeight());
    }
}
