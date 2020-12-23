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

  public void llenado(String doc) throws FileNotFoundException {

      votos=new int [getCandidatos.size()];
      File n=new File(doc);
     Scanner entrada=new Scanner(n);
      while (entrada.hasNextLine()){
          int x=0;
          String linea=entrada.nextLine();
          System.out.println(linea);
          String info[]=linea.split("-");
          int num=Integer.parseInt(info[1]);
          getCandidatos.add(info[0]);
          votos[x]=num;
          x++;
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

    public void conteo() throws IOException {

        String u=lugar();
        String b[]=u.split("-");
        File archivo=new File("CandidatoAlcalde");

            Scanner entrada=new Scanner(archivo);
            while (entrada.hasNextLine()){
                String linea=entrada.nextLine();
                String info[]=linea.split("-");
                if(info[2].equals(b[0])&&info[3].equals(b[1])){
                    getCandidatos.add(info[1]);
                }
            }

        for(int x=0;x<getCandidatos.size();x++){
            File buscar=new File("VotosAlcalde");
            Scanner linea=new Scanner(buscar);
            String t= getCandidatos.get(x);
            System.out.println("==========Buscando=========="+t);
            int contador=0;
            while(linea.hasNextLine()){
                String nombre=linea.nextLine();
                if(t.equals(nombre)){
                    contador++;
                }
            }
            System.out.println(t+" votos "+ contador);
            Archivos d=new Archivos(t,contador,"Alcaldes");
        }
        System.out.println("Listo");

    }
    public void conteo2() throws IOException {

        String u=lugar();
        String b[]=u.split("-");
        File archivo=new File("CandidatoDiputado");

        Scanner entrada=new Scanner(archivo);
        while (entrada.hasNextLine()){
            String linea=entrada.nextLine();
            String info[]=linea.split("-");
            if(info[2].equals(b[0])&&info[3].equals(b[1])){
                getCandidatos.add(info[1]);
            }
        }

        for(int x=0;x<getCandidatos.size();x++){
            File buscar=new File("VotosDiputado");
            Scanner linea=new Scanner(buscar);
            String t= getCandidatos.get(x);
            System.out.println("==========Buscando=========="+t);
            int contador=0;
            while(linea.hasNextLine()){
                String nombre=linea.nextLine();
                if(t.equals(nombre)){
                    contador++;
                }
            }
            System.out.println(t+" votos "+ contador);
            Archivos d=new Archivos(t,contador,"Diputados");
        }
        System.out.println("Listo");
    }
    public void conteo3() throws IOException {

        String u=lugar();
        String b[]=u.split("-");
        File archivo=new File("CandidatoPresidente");

        Scanner entrada=new Scanner(archivo);
        while (entrada.hasNextLine()){
            String linea=entrada.nextLine();
            String info[]=linea.split("-");
            if(info[2].equals(b[0])&&info[3].equals(b[1])){
                getCandidatos.add(info[1]);
            }
        }

        for(int x=0;x<getCandidatos.size();x++){
            File buscar=new File("VotosPresidente");
            Scanner linea=new Scanner(buscar);
            String t= getCandidatos.get(x);
            System.out.println("==========Buscando=========="+t);
            int contador=0;
            while(linea.hasNextLine()){
                String nombre=linea.nextLine();
                if(t.equals(nombre)){
                    contador++;
                }
            }
            System.out.println(t+" votos "+ contador);
            Archivos d=new Archivos(t,contador,"Presidente");
        }
        System.out.println("Listo");
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
    public void Final() throws IOException {
      conteo();
      llenado("Alcaldes");
        System.out.println("==============");
       System.out.println("Ganador "+ elegirGanador());
    }
   

}