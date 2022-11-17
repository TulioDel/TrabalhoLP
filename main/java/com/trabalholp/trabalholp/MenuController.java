package com.trabalholp.trabalholp;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.fxml.FXML;

import java.net.URL;
import java.util.ResourceBundle;


public class MenuController implements Initializable {


    @FXML
    private BorderPane mainPane;



    void zerarClick() {
        boletimClick = false;
        configClick = false;
        notepadClick = false;
        menuClick = false;
    }
    boolean boletimClick = false;
    boolean configClick = false;
    boolean notepadClick = false;
    boolean menuClick = false;

    String nome;
    String senha;

    void informacoes(String nome1, String senha1) {
        nome = nome1;
        senha = senha1;
        boletim();
    }

    @FXML
    private void boletim() {
        if (!boletimClick) {
            PageLoader vai = new PageLoader();
            BorderPane sera = vai.getPane("BoletimPane");
            mainPane.setCenter(sera);
            mainPane.getRight().setStyle("-fx-background-color: rgba(24,24,24,255);");

            zerarClick();
            boletimClick = true;
        }
    }

    @FXML
    private void notepad() {
        if (!notepadClick) {
            PageLoader vai = new PageLoader();
            BorderPane sera = vai.getPane("NotepadPane");
            mainPane.setCenter(sera);
            mainPane.getRight().setStyle("-fx-background-color: rgba(40,40,40,255);");
            zerarClick();
            notepadClick = true;

        }
    }

    @FXML
    private void config() {
        if (!configClick) {
            PageLoader vai = new PageLoader();
            BorderPane sera = vai.getPane("ConfigPane");
            mainPane.setCenter(sera);
            mainPane.getRight().setStyle("-fx-background-color: rgba(24,24,24,255);");
            zerarClick();
            configClick = true;
        }
    }

    @FXML
    private void menu() {
        if (!menuClick) {
            PageLoader vai = new PageLoader();
            BorderPane sera = vai.getPane("MenuPane");
            mainPane.getRight().setStyle("-fx-background-color: rgba(24,24,24,255);");
            mainPane.setCenter(sera);
            zerarClick();
            menuClick = true;
        }

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}





