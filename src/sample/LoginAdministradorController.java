package sample;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
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

    public void sesion(Event event){

        ArchivoSeguridad();
        boolean w=acceso(user.getText(),password.getText());

        if(w==false){
            Alert mensaje=new Alert(Alert.AlertType.INFORMATION);
            mensaje.setTitle("Informacion");
            mensaje.setHeaderText("Acceso Denegado");
            mensaje.setContentText(" Usuario o contrasena incorrectos ");
            mensaje.showAndWait();
            user.setText("");
            password.setText("");
        }
        else{
            Alert mensaje=new Alert(Alert.AlertType.INFORMATION);
            mensaje.setTitle("Informacion");
            mensaje.setHeaderText("Acceso Concedido");
            mensaje.setContentText(" Bienvenido "+ user.getText());
            mensaje.showAndWait();
            generarMenuAdmin(event);
        }
    }

    //validando acceso del administrador
    public boolean acceso(String nom, String pass){
        boolean r=false;

        File datos=new File("Seguridad");
        try {
            Scanner entrada=new Scanner(datos);
            while(entrada.hasNextLine()){
                String informacion=entrada.nextLine();
                String d[]=informacion.split(" ");
                //System.out.println(informacion);
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

    //Creando el archivo de seguridad para el admin y el password por defecto
        public  void  ArchivoSeguridad( ){
            File login=new File("Seguridad");
            try{
                if (!login.exists()){
                    login.createNewFile();
                    try {
                        FileWriter ingresar=new FileWriter("Seguridad");
                        ingresar.write("admin password");
                        ingresar.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            catch (IOException e){
                System.out.println("Error: "+e);
            }
        }

        public void generarMenuAdmin(Event event){
            try {
                Parent root = FXMLLoader.load(getClass().getResource("MenuAdmin.fxml"));
                Scene registro = new Scene(root);
                Stage regiStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                regiStage.setScene(registro);
                regiStage.show();
            } catch (Exception e){
                e.printStackTrace();
                e.getCause();
            }
    }
}
