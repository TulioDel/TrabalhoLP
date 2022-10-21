package com.trabalholp.trabalholp;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class Controlador {
    @FXML
    private Circle MinBotao;

    @FXML
    private Circle MaxBotao;

    @FXML
    private HBox barra;


    @FXML
    protected void onFechar() {
        javafx.application.Platform.exit();
    }

    @FXML
    private void onMin() {
        Stage stage = (Stage) MinBotao.getScene().getWindow();
        stage.setIconified(true);
    }

    @FXML
    private void onMax() {
        Stage stage = (Stage) MaxBotao.getScene().getWindow();
        if (stage.isMaximized() == true) {
            stage.setMaximized(false);
        }

        else {
            stage.setMaximized(true);
        }
    }


    private double x = 0, y = 0;

    @FXML
    private void borderpane_dragged(MouseEvent event) {
        Stage stage = (Stage) barra.getScene().getWindow();
        stage.setY(event.getScreenY() - y);
        stage.setX(event.getScreenX() - x);
    }

    @FXML
    private void borderpane_pressed(MouseEvent event) {
        x = event.getSceneX();
        y = event.getSceneY();
    }
}






