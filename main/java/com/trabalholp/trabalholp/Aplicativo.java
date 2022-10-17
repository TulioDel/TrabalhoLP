package com.trabalholp.trabalholp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class Aplicativo extends Application {

    @Override

    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(Aplicativo.class.getResource("Main.fxml"));

        Scene scene = new Scene(fxmlLoader.load(), 1200, 700);

        stage.setResizable(false);
        stage.initStyle(StageStyle.UNDECORATED);

        stage.setTitle("Login");
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}

