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
      public void datos(){
      listaCandidatos("Alcalde",PartidoPolitico,candidato);
      }
      public void votar(){

        generarFormulario("Votacion diputados","CandidatosDiputados");
        }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ArrayList<String>Partidos=new ArrayList<>();
        Partidos.add("Liberal");
        Partidos.add("Partido Nacional");
        ObservableList<String> l= FXCollections.observableArrayList(Partidos);
        PartidoPolitico.setItems(l);
        datos();
    }

}

