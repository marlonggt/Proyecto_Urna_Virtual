package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class InscripcionPartidoController extends RegistroController {
    @FXML
    TextField NombrePartido;
    @FXML TextField NombrePromotor;

    public void agregar() throws IOException {
        archivos("Partido");
        FileWriter partido= new FileWriter("Partido",true);
        String a=NombrePartido.getText()+"-"+NombrePromotor.getSelectedText()+"-"+Fecha.getValue().toString();
        partido.write(a);
    }

    public void mostrarMenuAdmin(){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("MenuAdmin.fxml"));
            Stage regiStage = new Stage();
            regiStage.setTitle("Administrador");
            regiStage.setScene(new Scene(root));
            regiStage.show();
        } catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }
}
