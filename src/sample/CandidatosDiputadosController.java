package sample;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class CandidatosDiputadosController extends RegistroController{
    @FXML ComboBox candidato;

    public void datos(){
        listaCandidatos("Alcalde",PartidoPolitico,candidato);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ArrayList<String> Partidos=new ArrayList<>();
        Partidos.add("Liberal");
        Partidos.add("Partido Nacional");
        ObservableList<String> l= FXCollections.observableArrayList(Partidos);
        PartidoPolitico.setItems(l);
        datos();
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
