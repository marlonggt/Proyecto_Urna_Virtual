package sample;

import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CandidatosAlcaldesController extends ResultadoVotacion{

    public void initialize(URL url, ResourceBundle resourceBundle) {
        //Cargar informacion a la tabla
        tabla("CandidatoAlcalde");
    }

    public void votar(Event event) throws IOException {
    votacion("VotosAlcalde");
        votacionDiputados(event);
    }

    public void votacionDiputados(Event event){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("CandidatosDiputados.fxml"));
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