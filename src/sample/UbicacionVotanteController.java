package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Scanner;

public class UbicacionVotanteController extends RegistroController {


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
       Mostrar(Departamento,Municipio);
    }

    public void datos(){
    Mostrar(Departamento,Municipio);

    }
    public void votar(){
    ubicacion();
    generarFormulario("Alcaldes","CandidatosAlcaldes");
    }
}
