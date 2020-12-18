package sample;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;


public class CandidatosAlcaldesController extends RegistroController{
    @FXML private ComboBox candidato;

      public void votar(){
        listaCandidatos("Alcalde",PartidoPolitico,candidato);
        if(revision(candidato)){
            Alert mensaje=new Alert(Alert.AlertType.WARNING);
            mensaje.setTitle("Informacion");
            mensaje.setHeaderText("Lo sentimos existen campos vacios");
            mensaje.showAndWait();
        }
        else{
        generarFormulario("Votacion diputados","CandidatosDiputados");
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ArrayList<String>Partidos=new ArrayList<>();
        Partidos.add("Liberal");
        Partidos.add("Partido Nacional");
        ObservableList<String> l= FXCollections.observableArrayList(Partidos);
        PartidoPolitico.setItems(l);
        votar();
    }

}

