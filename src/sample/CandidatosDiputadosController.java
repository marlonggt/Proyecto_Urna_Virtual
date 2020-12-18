package sample;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
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
    public void votar(){

        generarFormulario("Votacion diputados","CandidatosDiputados");
    }

    //funcion para generar la ventana de seleccion de candidatos a presidentes
    public void generarSelecPresidentes() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("CandidatosPresidentes.fxml"));
            Stage regiStage = new Stage();
            regiStage.setTitle("Candidaturas a la Presidencia");
            regiStage.setScene(new Scene(root));
            regiStage.show();
        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
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
}
