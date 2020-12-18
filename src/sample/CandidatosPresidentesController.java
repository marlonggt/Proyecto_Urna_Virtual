package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

public class CandidatosPresidentesController extends RegistroController{
@FXML private ComboBox candidato;
    public void datos(){

    }
    //funcion para regresar a la ventana principal
    public void votar(){

        generarFormulario("Login","LoginVotante");
    }
}

