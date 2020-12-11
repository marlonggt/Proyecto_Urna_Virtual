package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;


public class LoginVotanteController {

    @FXML
    private ImageView logoImage;
    @FXML
    TextField identidad;

    public void initialize(URL url, ResourceBundle resourceBundle){

        Image image = new Image("/Imagenes/tse.png");
        logoImage.setImage(image);

    }
    public void accion(ActionEvent event){
        boolean a=true;
        char digitos[]=identidad.getText().toCharArray();
        int n=digitos.length;
        System.out.println(n);
        if(n!=13){
            Alert mensaje=new Alert(Alert.AlertType.WARNING);
            mensaje.setTitle("Informacion");
            mensaje.setHeaderText("Ingrese un numero de identidad correcto");
            identidad.setText(" ");
            mensaje.showAndWait();
            a=false;

        }

        else {
            boolean b=acceso(identidad.getText());
            if (b){
                Alert mensaje=new Alert(Alert.AlertType.WARNING);
                mensaje.setTitle("Informacion");
                mensaje.setHeaderText("Lo sentimos usted ya voto");
                mensaje.showAndWait();
            }
            else{
                try {
                    FileWriter votar=new FileWriter("Votantes",true);
                    votar.write(identidad.getText()+"\n");
                    votar.close();
                    identidad.setText(" ");
                } catch (IOException e) {
                    e.printStackTrace();
                }

                Alert mensaje=new Alert(Alert.AlertType.INFORMATION);
                mensaje.setTitle("Informacion");
                mensaje.setHeaderText("Usted puede votar");
                mensaje.showAndWait();
                identidad.setText(" ");
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

}
