package sample;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane anchor;

    @FXML
    private Button buttonStart;

    @FXML
    private Pane pane;

    @FXML
    private Button buttonStop;

    @FXML
    private Slider sliderSpeed;

    @FXML
    private Button buttonEarth;

    @FXML
    private Label labelSpeed;

    @FXML
    void initialize() throws MalformedURLException {
        StarPane starPane = new StarPane(75, sliderSpeed.getValue());
        starPane.draw();
        pane.getChildren().add(starPane);


        sliderSpeed.setOnMouseDragged(e -> {
            labelSpeed.setText(String.format("Speed = %.3f", sliderSpeed.getValue()));
            starPane.setAnimationSpeed(sliderSpeed.getValue());
        });

        buttonStop.setOnAction(e -> {
            sliderSpeed.setValue(0);
            labelSpeed.setText(String.format("Speed = %.3f", sliderSpeed.getValue()));
            starPane.setAnimationSpeed(sliderSpeed.getValue());
        });

        buttonStart.setOnAction(e -> {
            starPane.start();
        });

        buttonStop.setOnAction(e -> {
            starPane.stop();
        });

        buttonEarth.setOnAction(e -> {
            starPane.showEarth();
            starPane.getChildren().add(starPane.getEarth().getCircle());
        });



    }

    public static void showWinWindow() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Test Connection");
        alert.setHeaderText("Results:");
        alert.setContentText("Connect to the database successfully!");
        alert.showAndWait();
    }
}
