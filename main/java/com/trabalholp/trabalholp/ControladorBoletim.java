package com.trabalholp.trabalholp;

import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.converter.DoubleStringConverter;
import javafx.util.converter.IntegerStringConverter;


import java.net.URL;
import java.util.ResourceBundle;


public class ControladorBoletim implements Initializable {


    @FXML
    private TableView<linha> tabelaNotas;

    @FXML
    private TableColumn<linha, String> materias;

    @FXML
    private TableColumn<linha, Double> primeiro;

    @FXML
    private TableColumn<linha, Double> segundo;

    @FXML
    private TableColumn<linha, Double> terceiro;

    @FXML
    private TableColumn<linha, Double> quarto;

    @FXML
    private TableColumn<linha, Double> estado;
    @FXML
    private TableColumn<linha, String> estado2;

    @FXML
    private TableColumn<linha, Integer> um;






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
        stage.setMaximized(!stage.isMaximized());
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

    int media = 60;
    @FXML
    private void toggleMedia() {
        if (media == 70) {
            media = 60;
        }

        else {
            media = 70;
        }

        atualiarEstados();
    }

    private void atualiarEstados() {
        for (int i = 0; i < 14;i++) {
            linhas.get(i).atualizarEstado(media);
            tabelaNotas.refresh();
        }
    }

    @FXML
    private void toggleEstado() {
        if (estado.isVisible()) {
            estado.setVisible(false);
            estado2.setVisible(true);
        }
        else {
            estado2.setVisible(false);
            estado.setVisible(true);
        }
    }

    @FXML
    private void toggleDivisao(){
        if (primeiro.getText().equals("1º Bimestre")) {

            primeiro.setText("1º Trimestre");
            segundo.setText("2º Trimestre");
            terceiro.setText("3º Trimestre");
            quarto.setVisible(false);

            for (int i = 0; i < 14;i++) {
                linhas.get(i).setNota4(0);
                linhas.get(i).atualizarEstado(media);
                tabelaNotas.refresh();
            }

        }

        else {
            primeiro.setText("1º Bimestre");
            segundo.setText("2º Bimestre");
            terceiro.setText("3º Bimestre");
            quarto.setText("4º Bimestre");

            quarto.setVisible(true);
        }

    }



    ObservableList<linha> linhas = FXCollections.observableArrayList();


    public void encherN() {
        for (int i = 0; i < 15;i++) {
            linhas.add(new linha(1, 2, 3,4,"materia" + Integer.toString(i+1),i+1, media));
        }

    }

    public void Lista() {

        tabelaNotas.setEditable(true);

        encherN();

        um.setCellValueFactory(new PropertyValueFactory<linha, Integer>("numero"));



        materias.setCellValueFactory(new PropertyValueFactory<linha, String>("materia"));
        materias.setCellFactory(TextFieldTableCell.forTableColumn());
        materias.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<linha, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<linha, String> linhaStringCellEditEvent) {
                linha linhaEd = linhaStringCellEditEvent.getRowValue();
                linhaEd.setMateria(linhaStringCellEditEvent.getNewValue());
            }
        });


        primeiro.setCellValueFactory(new PropertyValueFactory<linha, Double>("nota1"));
        primeiro.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
        primeiro.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<linha, Double>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<linha, Double> linhaStringCellEditEvent) {
                linha linhaEd = linhaStringCellEditEvent.getRowValue();
                linhaEd.setNota1(linhaStringCellEditEvent.getNewValue());
                atualiarEstados();
            }
        });


        segundo.setCellValueFactory(new PropertyValueFactory<linha, Double>("nota2"));
        segundo.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
        segundo.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<linha, Double>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<linha, Double> linhaStringCellEditEvent) {
                linha linhaEd = linhaStringCellEditEvent.getRowValue();
                linhaEd.setNota2(linhaStringCellEditEvent.getNewValue());
                atualiarEstados();
            }
        });


        terceiro.setCellValueFactory(new PropertyValueFactory<linha, Double>("nota3"));
        terceiro.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
        terceiro.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<linha, Double>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<linha, Double> linhaStringCellEditEvent) {
                linha linhaEd = linhaStringCellEditEvent.getRowValue();
                linhaEd.setNota3(linhaStringCellEditEvent.getNewValue());
                atualiarEstados();
            }
        });

        quarto.setCellValueFactory(new PropertyValueFactory<linha, Double>("nota4"));
        quarto.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
        quarto.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<linha, Double>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<linha, Double> linhaStringCellEditEvent) {
                linha linhaEd = linhaStringCellEditEvent.getRowValue();
                linhaEd.setNota4(linhaStringCellEditEvent.getNewValue());
                atualiarEstados();
            }
        });


        estado.setCellValueFactory(new PropertyValueFactory<linha, Double>("estado"));
        estado2.setCellValueFactory(new PropertyValueFactory<linha, String>("estado2"));


        materias.setReorderable(false);
        primeiro.setReorderable(false);
        segundo.setReorderable(false);
        terceiro.setReorderable(false);
        quarto.setReorderable(false);
        estado.setReorderable(false);
        estado2.setReorderable(false);



        estado2.setVisible(false);








        um.setMinWidth(50);
        um.setMaxWidth(50);


        materias.setMinWidth(150);
        estado.setMinWidth(70);
        estado2.setMinWidth(70);




        tabelaNotas.setFixedCellSize(48.3);


        tabelaNotas.setItems(linhas);
    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Lista();
    }



}






