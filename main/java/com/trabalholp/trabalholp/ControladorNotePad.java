package com.trabalholp.trabalholp;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.net.URL;
import java.util.ArrayList;
import java.util.Objects;
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
    BorderPane focaai;


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
        bordinhadeCria();

    }

    public void bordinhadeCria() {

        for (int i = 0; blocoNotas.getChildren().size() > i; i++) {
            blocoNotas.getChildren().get(i).getStyleClass().remove("selecionado");
        }

        blocoNotas.getChildren().get(selecionado).getStyleClass().add("selecionado");
    }


    @FXML
    private void criarNota() {
        criarNota1("","",Color.WHITE);
        LerEscrever.gravarArquivoNotas(logado, notas);
    }

   void criarNota1(String texto, String titulo, Color cores) {


        Nota nota;

        if (!Objects.equals(texto, "")){

            nota = new Nota(texto, titulo, cores);
        }
        else {
            nota = new Nota("", "Sem título", Color.WHITE);
        }
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
                bordinhadeCria();

            }


        });

        blocoNotas.getChildren().add( notaLista);
        selecionado = notas.size()-1;
        bordinhadeCria();



    }



    @FXML
    private void focarPane() {
        Texto.commitValue();
        focaai.requestFocus();
        mudando();

    }

    @FXML
    private void deleta(){
        if (notas.size() > 1) {
            blocoNotas.getChildren().remove(selecionado);
            notas.remove(selecionado);
            selecionado = 0;
            definir(0);
            bordinhadeCria();
        }
        else {

        }

    }



    ArrayList<Nota> notas = new ArrayList<>();
    usuario logado;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        logado = LerEscrever.lerArquivo();

        ArrayList<Nota> notas1 = LerEscrever.lerArquivoNotas(logado);
        for (int i = 0; i < notas1.size();i++)
            System.out.printf(notas1.get(i).getTitulo());

        if (notas1.size() != 0) {

            for (int i = 0; i < notas1.size(); i++) {

                criarNota1(notas1.get(i).texto, notas1.get(i).titulo, notas1.get(i).getCor());
            }

       }
        else {
            criarNota();
        }

    }
}








