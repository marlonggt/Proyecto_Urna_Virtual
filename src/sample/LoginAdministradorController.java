package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

public class LoginAdministradorController {

    @FXML private TextField user;
    @FXML private PasswordField password;
    @FXML private ImageView bandera;

    public void initialize(URL url, ResourceBundle resourceBundle){

        Image image = new Image("/Imagenes/bandera1.jpg");
        bandera.setImage(image);

    }

    public void sesion(){

        boolean w=acceso(user.getText(),password.getText());
        if(w=true){
            Alert mensaje=new Alert(Alert.AlertType.INFORMATION);
            mensaje.setTitle("Informacion");
            mensaje.setHeaderText("Acceso Concedido");
            mensaje.setContentText(" Bienvenido "+ user.getText());
            mensaje.showAndWait();

            try {
                cargar("Votar.fxml");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else{
            Alert mensaje=new Alert(Alert.AlertType.INFORMATION);
            mensaje.setTitle("Informacion");
            mensaje.setHeaderText("Acceso Denegado");
            mensaje.setContentText(" Usuario o contrasena incorrectos ");
            mensaje.showAndWait();
            user.setText("");
            password.setText("");
        }
    }
    public boolean acceso(String nom, String pass){
        boolean r=false;

        File datos=new File("Seguridad");
        try {
            Scanner entrada=new Scanner(datos);
            while(entrada.hasNextLine()){
                String informacion=entrada.nextLine();
                String d[]=informacion.split(" ");
                System.out.println(d[0]+"--"+d[1]);
                System.out.println(informacion);
                if (nom.equals(d[0])&& pass.equals(d[1])){
                    r=true;
                }
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return r;
    }
    public void cargar(String formulario) throws IOException {
        FXMLLoader frm=new FXMLLoader(getClass().getResource(formulario));
        Parent root=frm.load();
        ModuleLayer.Controller controlador=frm.getController();
        Scene t=new Scene(root);
        Stage u=new Stage();
        u.initModality(Modality.APPLICATION_MODAL);
        u.setScene(t);
        u.showAndWait();
    }

}
