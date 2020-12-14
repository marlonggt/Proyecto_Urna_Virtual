package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import java.awt.*;
import java.awt.event.ActionEvent;


public class CandidatosAlcaldesController{

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
}

