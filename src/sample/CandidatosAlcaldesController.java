package sample;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
  String DM=lugar();
  String l[]=DM.split("-");
 listado("Alcalde",PartidoPolitico,l[0],l[1],candidato);
    }


    //funcion para generar la ventana de seleccion de candidatos a diputados
    public void generarSelecDiputados() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("CandidatosDiputados.fxml"));
            Stage regiStage = new Stage();
            regiStage.setTitle("Candidaturas a Diputaciones");
            regiStage.setScene(new Scene(root));
            regiStage.show();
        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
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

