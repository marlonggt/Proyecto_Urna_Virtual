package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Hyperlink;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;


public class LoginVotanteController implements Initializable {

    @FXML private ImageView logoImage;
    @FXML private Hyperlink adminLink;
    @FXML private TextField numIdentidad;

    public void initialize(URL url, ResourceBundle resourceBundle){

        Image image = new Image("/Imagenes/tse.png");
        logoImage.setImage(image);

    }

    public void aceptarAccion(ActionEvent event){

        archivos("Votantes");
        boolean z=id(numIdentidad);
        if (z=true){
            System.out.println("Existe");
        }
        else{
            Escribir("Votantes",numIdentidad.getText());
        }
    }

    public void adminLinkAccion() {

        generarRegistro();


    }

    public boolean id(TextField numIdentidad){
        boolean r=false;
        File datos=new File("Votantes");
        try {
            Scanner entrada=new Scanner(datos);
            while(entrada.hasNextLine()){
                String informacion=entrada.nextLine();

                if (numIdentidad.equals(informacion)){
                    r=true;
                }
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return r;
    }

    public void Escribir(String texto,String id){
        try {
            FileWriter archivo=new FileWriter(texto,true);
            archivo.write(id+"\n");
            archivo.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void archivos (String texto){

        File archivo=new File(texto);
        try{
            boolean a=archivo.createNewFile();
            if (archivo.exists()){
                System.out.println("Listo");
            }

        }
        catch (IOException e){
            System.out.println("Error: "+e);
        }
    }


    public void generarRegistro(){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("LoginAdministrador.fxml"));
            Stage regiStage = new Stage();
            regiStage.setTitle("Opciones del administrador");
            regiStage.setScene(new Scene(root));
            regiStage.show();

        } catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }

}
