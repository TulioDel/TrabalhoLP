package com.trabalholp.trabalholp;

import io.github.gleidson28.GNAvatarView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class MenuMenuController implements Initializable {


    @FXML
    private BorderPane mainPane;



    @FXML
    private void meme() {
        PageLoader vai = new PageLoader();
        BorderPane sera = vai.getPane("MemePane");
        mainPane.setCenter(sera);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}






