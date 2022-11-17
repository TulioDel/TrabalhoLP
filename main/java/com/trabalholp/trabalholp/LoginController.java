package com.trabalholp.trabalholp;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.fxml.FXML;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;


public class LoginController implements Initializable {


    @FXML
    private BorderPane mainPane;

    @FXML
    private TextField email;

    @FXML
    private PasswordField senha;



    @FXML
    private void logar() {

        LerEscrever.gravarArquivo(new usuario(email.getText(), senha.getText()));

        PageLoader load = new PageLoader();
        BorderPane loadPane = load.getPane("MenuPane");
        mainPane.setCenter(loadPane);

    }

    @FXML
    private void registrar() {
        PageLoader load = new PageLoader();
        BorderPane loadPane = load.getPane("MenuPane");
        mainPane.setCenter(loadPane);
    }

    @FXML
    private void registrarPage() {
        PageLoader load = new PageLoader();
        BorderPane loadPane = load.getPane("RegisterPane");
        mainPane.setCenter(loadPane);
    }

    @FXML
    private void loginPage() {
        PageLoader load = new PageLoader();
        BorderPane loadPane = load.getPane("LoginPane");
        mainPane.setCenter(loadPane);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }
}





