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
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class ConfigController implements Initializable {


    @FXML
    private Button deslogarb;



    @FXML
    private void deslogar() throws IOException {

        Stage antigo = (Stage) deslogarb.getScene().getWindow();


        FXMLLoader fxmlLoader = new FXMLLoader(Aplicativo.class.getResource("MainPane.fxml"));

        Scene scene = new Scene(fxmlLoader.load(), 1200, 700);
        scene.setFill(Color.TRANSPARENT);


        antigo.setScene(scene);

    }

    @FXML
    GNAvatarView avatar;

    @FXML
    ChoiceBox<String> ops;


    String[] opcoes = {"shi","ararara","lixo","ROCK","tucanow"};

    void mudando(ActionEvent event) {
        int se = 0;

        for (int i = 0; i < ops.getItems().size(); i++) {
            if (ops.getValue() == ops.getItems().get(i)) {
                se = i;
            }

        }

        if (se == 0)
            avatar.setImage(new Image("https://i.imgur.com/yqKLmVu.png"));
        else if (se == 1)
            avatar.setImage(new Image("https://i.imgur.com/V3EioTw.png"));
        else if (se == 2)
            avatar.setImage(new Image("https://i.imgur.com/rgvN95A.png"));
        else if (se == 3)
            avatar.setImage(new Image("https://i.imgur.com/7wBidGu.png"));
        else if (se == 4)
            avatar.setImage(new Image("https://i.imgur.com/6eGQF3S.png"));

    }

    @FXML
    Label texto;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        usuario usuario1 = LerEscrever.lerArquivo();

        ops.getItems().addAll(opcoes);

        ops.setOnAction(this::mudando);
        texto.setText(usuario1.getUsuario());



    }



}






