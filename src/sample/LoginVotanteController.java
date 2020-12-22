package sample;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;


public class LoginVotanteController extends RegistroController {

    //atributos de la clase
    @FXML private ImageView logoImage;
    @FXML private Hyperlink adminLink;
    @FXML private Button aceptar;

    public void initialize(URL url, ResourceBundle resourceBundle){
        Image image = new Image("/Imagenes/tse.png");
        logoImage.setImage(image);
    }

    public void accion2(Event event){
       archivos("Votantes");
        char digitos[]=identidad.getText().toCharArray();
        int n = digitos.length;
        System.out.println(n);

        if(n!=13){
            Alert mensaje=new Alert(Alert.AlertType.WARNING);
            mensaje.setTitle("Informacion");
            mensaje.setHeaderText("Ingrese un numero de identidad correcto");
            identidad.setText("");
            mensaje.showAndWait();
        }
        else {
            boolean b=acceso(identidad.getText());
            if (b){
                Alert mensaje=new Alert(Alert.AlertType.WARNING);
                mensaje.setTitle("Informacion");
                mensaje.setHeaderText("Lo sentimos usted ya voto");
                mensaje.showAndWait();
                identidad.setText("");
            }
            else{
                try {
                    FileWriter votar=new FileWriter("Votantes",true);
                    votar.write(identidad.getText()+"\n");
                    votar.close();
                    identidad.setText("");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                generarLocalidad(event);
            }
        }
    }

    public boolean acceso(String identidad){
        boolean r=false;
        File datos=new File("Votantes");
        try {
            Scanner entrada=new Scanner(datos);
            while(entrada.hasNextLine()){
                String informacion=entrada.nextLine();

                if (identidad.equals(informacion)){
                    r=true;
                }
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return r;
    }

    //funcion para generar la ventana de Login Administrador
    public void generarAdminLogin(Event event){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("LoginAdministrador.fxml"));
            Scene adminLogin = new Scene(root);
            Stage loginAdmin_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            loginAdmin_stage.setScene(adminLogin);
            loginAdmin_stage.show();
        } catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }

    //funcion para generar la ventana de localidad
    public void generarLocalidad(Event event){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("UbicacionVotante.fxml"));
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