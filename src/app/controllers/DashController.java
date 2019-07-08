package app.controllers;

import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

public class DashController implements Initializable {

    @FXML
    private PieChart pieHash, pieKey;

    @FXML
    private Label lblClose, lblExpired, lbl7, lbl30, lbl90,lblExp, lblActive;

    @FXML
    private Label lblOffline;

    @FXML
    private Circle shpActive;

    Random r = new Random();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadHash(pieHash);
        loadHash(pieKey);
        lblClose.setOnMouseClicked(e -> System.exit(0));

        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(2), event -> {
            loadHash(pieHash);
            loadHash(pieKey);
            lblExpired.setText(String.valueOf(r.nextInt(11)));
            lbl7.setText(String.valueOf(r.nextInt(10)));
            lbl30.setText(String.valueOf(r.nextInt(15)));
            lbl90.setText(String.valueOf(r.nextInt(20)));
            lblExp.setText(r.nextInt(2)+ " Expired");
            lblActive.setText(r.nextInt(15)+ " Active");
            lblOffline.setText(r.nextInt(3) + " Offline");
            shpActive.setFill(Color.LIMEGREEN);

        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
        shpActive.setFill(Color.WHITE);

    }

    private void loadHash(PieChart pieChart) {

        ObservableList<PieChart.Data> data =
                FXCollections.observableArrayList(
                        new PieChart.Data("Hash", r.nextInt(50)),
                        new PieChart.Data("Key", r.nextInt(50))
                );
        pieChart.setData(data);

    }


}
