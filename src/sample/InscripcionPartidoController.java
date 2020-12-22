package sample;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class InscripcionPartidoController extends RegistroController{

@FXML private TextField nombrePartido;
@FXML private TextField nombrePromotor;
    public void agregar() throws IOException {
        boolean w=revision();
        if(w==true){
            Alert mensaje=new Alert(Alert.AlertType.WARNING);
            mensaje.setTitle("Informacion");
            mensaje.setHeaderText("Lo sentimos existen campos vacios");
            mensaje.showAndWait();
        } else {

            Alert mensaje=new Alert(Alert.AlertType.INFORMATION);
            mensaje.setTitle("Informacion");
            mensaje.setHeaderText("Partido agregado");
            mensaje.showAndWait();
            archivos("Partido");
            FileWriter partido= new FileWriter("Partido",true);
            String a=nombrePartido.getText()+"-"+nombrePromotor.getText()+"-"+Fecha.getValue().toString();
            partido.write(a+"\n");
            partido.close();
        }
    }
    public void mostrarMenuAdmin(Event event){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("MenuAdmin.fxml"));
            Scene localidad = new Scene(root);
            Stage locaStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            locaStage.setScene(localidad);
            locaStage.show();
        } catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }
    public boolean revision(){
        boolean r=false;
        String a="";
        if(nombrePartido.getText().equals(a)||nombrePromotor.getText().equals(a)||Fecha.getValue()==null){
            r=true;
        }
        return r;
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }
}