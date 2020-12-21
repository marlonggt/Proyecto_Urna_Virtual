package sample;

import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MenuAdminController {

    //funcion para generar la ventana de registro de candidatos
    public void generarRegistro(Event event){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("registro.fxml"));
            Scene localidad = new Scene(root);
            Stage locaStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            locaStage.setScene(localidad);
            locaStage.show();
        } catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }

    //funcion para generar la ventana de registro de partidos politicos
    public void registroPartidos(Event event){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("InscripcionPartido.fxml"));
            Scene localidad = new Scene(root);
            Stage locaStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            locaStage.setScene(localidad);
            locaStage.show();
        } catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
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

    public void resultados(Event event){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("ResultadoVotacion.fxml"));
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
