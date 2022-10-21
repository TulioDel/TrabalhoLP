package com.trabalholp.trabalholp;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

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
        if (stage.isMaximized() == true) {
            stage.setMaximized(false);
        }

        else {
            stage.setMaximized(true);
        }
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






    ObservableList<linha> linhas = FXCollections.observableArrayList(
            new linha(1, 2, 3,4,5,"OA"),
            new linha(1, 2, 3,4,5,"OB"),
            new linha(1, 2, 3,4,5,"OC")
    );




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        materias.setCellValueFactory(new PropertyValueFactory<linha, String>("materia"));
        primeiro.setCellValueFactory(new PropertyValueFactory<linha, Double>("nota1"));
        segundo.setCellValueFactory(new PropertyValueFactory<linha, Double>("nota2"));
        terceiro.setCellValueFactory(new PropertyValueFactory<linha, Double>("nota3"));
        quarto.setCellValueFactory(new PropertyValueFactory<linha, Double>("nota4"));
        estado.setCellValueFactory(new PropertyValueFactory<linha, Double>("estado"));
        tabelaNotas.setFixedCellSize(35);
        tabelaNotas.setItems(linhas);

        tabelaNotas.setEditable(true);


    }

}






