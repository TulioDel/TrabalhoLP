package com.trabalholp.trabalholp;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Glow;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import javax.net.ssl.SNIHostName;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;


public class ControladorNotePad implements Initializable {
    @FXML
    VBox blocoNotas;

    @FXML
    ColorPicker cor;

    @FXML
    TextArea Texto;

    @FXML
    TextField Titulo;

    @FXML
    Pane foca;


    int selecionado = 0;



    public void mudando() {
        notas.get(selecionado).setCor(cor.getValue());
        notas.get(selecionado).setTexto(Texto.getText());
        notas.get(selecionado).setTitulo(Titulo.getText());
        definir(selecionado);



    }

    public void definir(int index) {

        Nota nota = notas.get(index);

        cor.setValue(nota.cor);
        Texto.setText(nota.texto);
        Titulo.setText(nota.titulo);

        selecionado = index;


        HBox notaLista= new HBox();
        notaLista.getStyleClass().add("UmaNota");


        Circle circle = new Circle();
        circle.setRadius(10);
        circle.setFill(nota.cor);



        Label label = new Label(nota.titulo);
        label.getStyleClass().add("TextoNotaLado");



        VBox vbox = new VBox();
        vbox.getChildren().addAll(label);
        vbox.getStyleClass().add("vboxDoHbox");


        notaLista.getChildren().addAll(circle,vbox);



        blocoNotas.getChildren().set(index, notaLista);

        notaLista.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                Object foi = mouseEvent.getSource();
                int index = blocoNotas.getChildren().indexOf(foi);
                System.out.println(index);

                definir(index);


            }


        });

    }


    @FXML
    private void criarNota() {



        Nota nota = new Nota("", "Sem título", Color.WHITE);
        notas.add(nota);

        cor.setValue(nota.cor);
        Texto.setText(nota.texto);
        Titulo.setText(nota.titulo);

        HBox notaLista= new HBox();
        notaLista.getStyleClass().add("UmaNota");


        Circle circle = new Circle();
        circle.setRadius(10);
        circle.setFill(Color.WHITE);



        Label label = new Label(nota.titulo);
        label.getStyleClass().add("TextoNotaLado");


        VBox vbox = new VBox();
        vbox.getChildren().addAll(label);
        vbox.getStyleClass().add("vboxDoHbox");


        notaLista.getChildren().addAll(circle,vbox);




        notaLista.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                Object foi = mouseEvent.getSource();
                int index = blocoNotas.getChildren().indexOf(foi);
                System.out.println(index);

                definir(index);


            }


        });

        blocoNotas.getChildren().add( notaLista);


    }

    public void foca() {
        foca.requestFocus();
    }

    @FXML
    private void focarPane() {
    }

    ArrayList<Nota> notas = new ArrayList<>();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        criarNota();
        definir(selecionado);



    }

}








