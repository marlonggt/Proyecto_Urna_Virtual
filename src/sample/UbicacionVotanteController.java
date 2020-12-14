package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import javax.swing.*;
import java.net.URL;
import java.util.ResourceBundle;

public class UbicacionVotanteController {

    public void accion4(){

        generarSelecAlcaldes();
    }

    //funcion para generar la ventana de seleccion de candidatos a alcaldes
    public void generarSelecAlcaldes() {
            try {
                Parent root = FXMLLoader.load(getClass().getResource("CandidatosAlcaldes.fxml"));
                Stage regiStage = new Stage();
                regiStage.setTitle("Candidaturas a Alcaldias");
                regiStage.setScene(new Scene(root));
                regiStage.show();
            } catch (Exception e) {
                e.printStackTrace();
                e.getCause();
            }
    }
}
