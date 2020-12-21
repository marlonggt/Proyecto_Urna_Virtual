package sample;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Scanner;

public class CandidatosDiputadosController implements Initializable {
    @FXML private TableColumn<DatosColumna,String> candidato;
    @FXML private TableColumn<DatosColumna,String>partido;
    @FXML private TableView<DatosColumna> lista;

    ObservableList<DatosColumna> list= FXCollections.observableArrayList();

    public void initialize(URL url, ResourceBundle resourceBundle) {
        String u=lugar();
        String b[]=u.split("-");
        File archivo=new File("CandidatoDiputado");
        try {
            Scanner entrada=new Scanner(archivo);
            while (entrada.hasNextLine()){
                String linea=entrada.nextLine();
                String info[]=linea.split("-");
                if(info[2].equals(b[0])&&info[3].equals(b[1])){

                    list.addAll(new DatosColumna(info[1],info[0]));
                }

            }
        } catch ( FileNotFoundException e) {
            e.printStackTrace();
        }

        lista.setItems(list);
        candidato.setCellValueFactory(new PropertyValueFactory<DatosColumna,String>("candidato"));
        partido.setCellValueFactory(new PropertyValueFactory<DatosColumna,String>("partido"));
    }
    public String lugar(){
        File archivo=new File("UbicacionVotante");
        String linea="";
        try {
            Scanner entrada=new Scanner(archivo);
            while (entrada.hasNextLine()){
                linea=entrada.nextLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return linea;
    }

    public void votarPresidentes(Event event){
        votacionPresidentes(event);
    }

    public void votacionPresidentes(Event event){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("CandidatosPresidentes.fxml"));
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
