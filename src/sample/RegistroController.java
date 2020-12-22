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
import javafx.scene.control.*;
import javafx.stage.Stage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Scanner;


public class RegistroController implements Initializable {

    @FXML private TextField nombre;
    @FXML protected TextField identidad;
    @FXML private TextField edad;
    @FXML private RadioButton OptMasculino;
    @FXML private RadioButton OptFemenino;
    @FXML protected DatePicker Fecha;
    @FXML private ComboBox TipoCandidatura;
    @FXML protected ComboBox PartidoPolitico;
    @FXML protected ComboBox Departamento;
    @FXML protected ComboBox Municipio;
    protected ArrayList <String> mun=new ArrayList<>();
    protected ArrayList <String> depto=new ArrayList<>();
    protected ArrayList <String> Tipos=new ArrayList<>();
    protected ArrayList <String> Partidos=new ArrayList<>();

      @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //Lista de tipos de candidaturas
        Tipos.add("Presidente");
        Tipos.add("Diputado");
        Tipos.add("Alcalde");
        ObservableList<String> list= FXCollections.observableArrayList(Tipos);
        TipoCandidatura.setItems(list);

        //Lista de partidos politicos
        Partidos.add("Partido Paz y Unidad");
        Partidos.add("Partido Reconciliacion");
        ObservableList<String> list2= FXCollections.observableArrayList(Partidos);
        PartidoPolitico.setItems(list2);
        Mostrar(Departamento,Municipio);
    }

    //Funcion Evaluacion identidad
    public void evaluacion(){
        char digitos[]=identidad.getText().toCharArray();
        int n=digitos.length;
        System.out.println(n);
        if(n!=13){
            Alert mensaje=new Alert(Alert.AlertType.WARNING);
            mensaje.setTitle("Informacion");
            mensaje.setHeaderText("Ingrese un numero de identidad correcto");
            identidad.setText("");
            mensaje.showAndWait();
        }
    }

    public void  Agregar(){
        archivos("Candidatos");
        boolean w=revision();
        if(w==true){
            Alert mensaje=new Alert(Alert.AlertType.WARNING);
            mensaje.setTitle("Informacion");
            mensaje.setHeaderText("Lo sentimos existen campos vacios");
            mensaje.showAndWait();
        } else {
            String sexo;
            if (OptMasculino.isSelected()){
                sexo="Masculino";
            } else {
                sexo="Femenino";
            }
            escritura("Candidatos",identidad,nombre,edad,sexo,Fecha,TipoCandidatura,PartidoPolitico,Departamento,Municipio);
            Alert mensaje=new Alert(Alert.AlertType.INFORMATION);
            mensaje.setTitle("Informacion");
            mensaje.setHeaderText("Candidato agregado");
            mensaje.showAndWait();
            listado(PartidoPolitico,nombre,Departamento,Municipio);
        }
    }

    //Verificar llenado;
    public boolean revision(){
        boolean r=false;
        String a="";
        if(nombre.getText().equals(a)||identidad.getText().equals(a)||edad.getText().equals(a)){
            r=true;
        }
        else  if(Fecha.getValue()==null||TipoCandidatura.getValue()==null||PartidoPolitico.getValue()==null||Departamento.getValue()==null||Municipio.getValue()==null){
            r=true;
        }
        return r;
    }

    //Agregar datos del candidato su respectivo archivo de texto
    public void escritura (String texto, TextField identidad, TextField nombre, TextField edad, String sexo, DatePicker fecha, ComboBox TipoCandidatura,ComboBox Partido,ComboBox departamento, ComboBox municipio ){
        String candidato=identidad.getText()+" "+nombre.getText()+" "+edad.getText()+" años "+sexo+" "+fecha.getValue().toString()+" "+TipoCandidatura.getValue().toString()+" "+Partido.getValue().toString()+" "+departamento.getValue().toString()+" "+municipio.getValue().toString();
        try {
            FileWriter archivo=new FileWriter(texto,true);
            archivo.write(candidato+"\n");
            archivo.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Verificar si existe el archivo de texto
    public  void  archivos (String texto){
        File archivo=new File(texto);
        try{
            boolean a=archivo.createNewFile();
            if (!archivo.exists()){
                archivo.createNewFile();
                System.out.println("Listo");
            }
        }
        catch (IOException e){
            System.out.println("Error: "+e);
        }
    }

    //Funcion para almacenar los municipios segun el departamento seleccionado
    public void Mostrar(ComboBox d,ComboBox m){
        File datos=new File("Departamentos\\DepartamentosHonduras.txt");
        try {
            Scanner entrada=new Scanner(datos);
            while(entrada.hasNextLine()){
                String informacion=entrada.nextLine();
                depto.add(informacion);
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObservableList<String> listd= FXCollections.observableArrayList(depto);
        d.setItems(listd);

        if (d.getValue() == null) {
            System.out.println("Vacio");
        } else {
            //Municipios
            mun.clear();
            String nombre="Departamentos\\"+d.getValue().toString()+".txt";
            File datos2=new File(nombre);
            try {
                Scanner entrada=new Scanner(datos2);
                while(entrada.hasNextLine()){
                    String informacion=entrada.nextLine();
                    mun.add(informacion);
                }
            }
            catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            ObservableList<String> list = FXCollections.observableArrayList(mun);
            m.setItems(list);
        }
    }

    //Accion para el boton de mostrar en combobox
    public void DatosCombobox() throws FileNotFoundException {
          MostrarPartidos();
          Mostrar(Departamento,Municipio);

    }
    public void MostrarPartidos() throws FileNotFoundException {
          Partidos.clear();
        File datos=new File("Partido");
            Scanner entrada=new Scanner(datos);
            while(entrada.hasNextLine()){
                String informacion=entrada.nextLine();
                String partido[]=informacion.split("-");
                Partidos.add(partido[0]);
                ObservableList<String> listd= FXCollections.observableArrayList(Partidos);
        PartidoPolitico.setItems(listd);

            }
    }
    //Almacenar datos de candidatos
    public void listado(ComboBox Partido,TextField nombre,ComboBox Departamento, ComboBox Municipio) {
        String documento;
        String dato = TipoCandidatura.getValue().toString();
        //Determinar el archivo donde se almacena la informacion
        if (dato.equals("Alcalde")) {
            documento = "CandidatoAlcalde";
        } else if (dato.equals("Diputado")) {
            documento = "CandidatoDiputado";
        } else {
            documento = "CandidatoPresidente";
        }
        archivos(documento);
        String almacenar = Partido.getValue().toString() + "-" + nombre.getText() + "-" + Departamento.getValue().toString() + "-" + Municipio.getValue().toString();
        try {
            FileWriter archivo = new FileWriter(documento, true);
            archivo.write(almacenar + "\n");
            archivo.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Almacenar los datos en arraylist para su seleccion
    public void listado(ComboBox Partido,String Departamento, String Municipio,ComboBox candidato){
            ArrayList <String>lista=new ArrayList<>();
            try {
            File archivo=new File("Listado");
            Scanner entrada=new Scanner(archivo);
            while(entrada.hasNextLine()){
            String linea=entrada.nextLine();
            String mostrar[]=linea.split("-");
           if(PartidoPolitico.getValue()!=null){
               if(Partido.getValue().toString().equals(mostrar[1])){
                   if(Departamento.equals(mostrar[3])&&Municipio.equals(mostrar[4])){
                       lista.add(mostrar[2]);
                   }
               }
           }
                PartidoPolitico.setPromptText("Seleccione un partido politico");
                candidato.setPromptText("Seleccione un candidato");
           }
    } catch (FileNotFoundException e) {
             e.printStackTrace();
         }
            ObservableList<String> list=FXCollections.observableList(lista);
            candidato.setItems(list);
    }

    //Guardar ubicacion del votante en archivo de texto
    public void ubicacion(){
        archivos("UbicacionVotante");
        String informacion=Departamento.getValue().toString()+"-"+Municipio.getValue().toString();
        try {
            FileWriter ubicacion=new FileWriter("UbicacionVotante");
            ubicacion.write(informacion);
            ubicacion.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Funcion que retorna la ubicacion almacenada en el archivo


    //Funcion que busca y agrega los datos segun el partido seleccionado y segun su ubicacion

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