package sample;

import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.net.URL;
import java.util.ResourceBundle;

public class CandidatosPresidentesController extends ResultadoVotacion{
      public void initialize(URL url, ResourceBundle resourceBundle) {
     //Cargar informacion a la tabla
     tabla("CandidatoPresidente");
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