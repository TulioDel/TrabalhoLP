package com.trabalholp.trabalholp;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import org.w3c.dom.Text;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class ConfigController implements Initializable {


    @FXML
    private Label nome;

    @FXML
    private Label senha;

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




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        usuario usuario1 = LerEscrever.lerArquivo();

        nome.setText(usuario1.getUsuario());
        senha.setText(usuario1.getSenha());

    }



}






