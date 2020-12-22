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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Scanner;

public class ResultadoVotacion implements Initializable {
    @FXML private TableColumn<DatosColumna,String> candidato;
    @FXML private TableColumn<DatosColumna,String>partido;
    @FXML private TableView<DatosColumna> lista;
    ObservableList<DatosColumna> list= FXCollections.observableArrayList();

    int contadorVotosPresidente;
    int ContadorVotosDiputado;
    int contadorvotos;

    ArrayList <String> getCandidatos = new ArrayList();
    int votos[];

    //ingresar el voto y sumarlo a contador
    public void votar(String candidato){
        getCandidatos.add("Marcos"); getCandidatos.add("Allan"); getCandidatos.add("Onan"); getCandidatos.add("Marlon");
        votos = new int[getCandidatos.size()];

        String candidatoSelec= candidato;
        System.out.println("seleccionado "+candidatoSelec);
        for (int i = 0; i < votos.length;i++){
            if (getCandidatos.get(i).equals(candidatoSelec)) {
                votos[i]++;
            }
        }
    }

    //Elige al ganador
    public String elegirGanador(){
        int masVotos = votos[0];
        String resultado = getCandidatos.get(0);

        for (int i = 1; i < getCandidatos.size(); i++){
            if(votos[i] > masVotos){
                masVotos = votos[i];
                resultado = getCandidatos.get(i);
            } else{
                if (votos[i] == masVotos)
                    resultado = "Empate";
            }
        }
        return resultado;
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

    public void tabla(String documento){
        list.clear();
        String u=lugar();
        String b[]=u.split("-");
        File archivo=new File(documento);
        try {
            Scanner entrada=new Scanner(archivo);
            while (entrada.hasNextLine()){
                String linea=entrada.nextLine();
                String info[]=linea.split("-");
                if(info[2].equals(b[0])&&info[3].equals(b[1])){
                   getCandidatos.add(info[1]);
                   list.addAll(new DatosColumna(info[1],info[0]));
            }
        }
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    }
        lista.setItems(list);
        candidato.setCellValueFactory(new PropertyValueFactory<DatosColumna,String>("candidato"));
        partido.setCellValueFactory(new PropertyValueFactory<DatosColumna,String>("partido"));
}

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    public void votacion(String tipoVotacion) throws IOException {
        String n=lista.getSelectionModel().getSelectedItem().getCandidato();
        File archivo=new File(tipoVotacion);
        if(!archivo.exists()){
            archivo.createNewFile();
        }
        FileWriter agregar=new FileWriter(tipoVotacion,true);
        agregar.write(n+"\n");
        agregar.close();
    }
    public void volverAtras(Event event){
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