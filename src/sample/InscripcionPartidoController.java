package sample;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class InscripcionPartidoController extends RegistroController {
    @FXML TextField nombrePartido;
    @FXML TextField nombrePromotor;

    public void agregar() throws IOException {
        archivos("Partido");
        FileWriter partido= new FileWriter("Partido",true);
        String a=nombrePartido.getText()+"-"+nombrePromotor.getSelectedText()+"-"+Fecha.getValue().toString();
        partido.write(a);
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
}
