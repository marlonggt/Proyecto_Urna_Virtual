package sample;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Scanner;

public class CandidatosDiputadosController extends ResultadoVotacion {
    @FXML private TableColumn<DatosColumna,String> candidato;
    @FXML private TableColumn<DatosColumna,String>partido;
    @FXML private TableView<DatosColumna> lista;

    ObservableList<DatosColumna> list= FXCollections.observableArrayList();

    public void initialize(URL url, ResourceBundle resourceBundle) {
        tabla("CandidatoDiputado");
    }

    public void votarPresidentes(Event event){
        votacionPresidentes(event);
    }

    public void votacionPresidentes(Event event){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("CandidatosPresidentes.fxml"));
            Scene localidad = new Scene(root);
            Stage locaStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            locaStage.setScene(localidad);
            locaStage.show();
        } catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }
}
