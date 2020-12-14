package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CandidatosPresidentesController{


//funcion para regresar a la ventana principal
    public void regresarLoginVotante() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("LoginVotante.fxml"));
            Stage regiStage = new Stage();
            regiStage.setTitle("Urna Virtual 2020");
            regiStage.setScene(new Scene(root));
            regiStage.show();
        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }
}
