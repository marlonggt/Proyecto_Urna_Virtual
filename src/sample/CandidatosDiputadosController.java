package sample;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class CandidatosDiputadosController extends ResultadoVotacion {

    public void initialize(URL url, ResourceBundle resourceBundle) {
        //Cargar informacion a la tabla
        tabla("CandidatoDiputado");
    }

    public void votarPresidentes(Event event) throws IOException {
        votacion("VotosDiputado");
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