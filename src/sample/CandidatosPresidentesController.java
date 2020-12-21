package sample;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

public class CandidatosPresidentesController extends RegistroController{
@FXML private ComboBox candidato;
    public void datos(){
    }

    //funcion para regresar a la ventana principal
    public void finalVotacion(Event event){
        ventanaPrincipal(event);
    }

    public void ventanaPrincipal(Event event){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("LoginVotante.fxml"));
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

