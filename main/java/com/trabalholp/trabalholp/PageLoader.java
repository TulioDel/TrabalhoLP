package com.trabalholp.trabalholp;


import javafx.fxml.FXMLLoader;
import javafx.scene.control.Menu;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;

public class PageLoader {

    private BorderPane view;

    public BorderPane getPane(String endereco) {
        try {
            URL enderecoLiteral = Aplicativo.class.getResource("/com/trabalholp/trabalholp/" + endereco + ".fxml");

            if (enderecoLiteral == null) {
                throw new java.io.FileNotFoundException("Arquivo não encontrado");
            }
            view = new FXMLLoader().load(enderecoLiteral);

        }

        catch (Exception e) {
            System.out.println("Sem pagina");
        }
        view.setMaxSize(9999999, 99999);
        return view;
    }






}
