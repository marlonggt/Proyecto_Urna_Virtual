package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
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
    @FXML private DatePicker Fecha;
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
        Partidos.add("Partido Nacional");
        Partidos.add("Partido Liberal");
        ObservableList<String> list2= FXCollections.observableArrayList(Partidos);
        PartidoPolitico.setItems(list2);
        Mostrar(Departamento,Municipio);
    }


    public void  Agregar(){
        archivos("Candidatos");
        boolean w=revision();
        if(w==true){
            Alert mensaje=new Alert(Alert.AlertType.WARNING);
            mensaje.setTitle("Informacion");
            mensaje.setHeaderText("Lo sentimos existen campos vacios");
            mensaje.showAndWait();
        }
        else {
            String sexo;
            if (OptMasculino.isSelected()){
                sexo="Masculino";

            }
            else {
                sexo="Femenino";
            }
            escritura("Candidatos",identidad,nombre,edad,sexo,Fecha,TipoCandidatura,PartidoPolitico,Departamento,Municipio);
            Alert mensaje=new Alert(Alert.AlertType.INFORMATION);
            mensaje.setTitle("Informacion");
            mensaje.setHeaderText("Candidato agregado");
            mensaje.showAndWait();
            listado(TipoCandidatura,PartidoPolitico,nombre,Departamento,Municipio);

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
    public void DatosCombobox(){
    Mostrar(Departamento,Municipio);
    }
    //Almacenar datos de candidatos
    public void listado(ComboBox tipo,ComboBox Partido,TextField nombre,ComboBox Departamento, ComboBox Municipio){
    archivos("Listado");
        String almacenar=tipo.getValue().toString()+"-"+Partido.getValue().toString()+"-"+nombre.getText()+"-"+Departamento.getValue().toString()+"-"+Municipio.getValue().toString();
        try {
            FileWriter archivo=new FileWriter("Listado",true);
            archivo.write(almacenar+"\n");
            archivo.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        }
    //Almacenar los datos en arraylist para su seleccion
    public void listado(String tipo,ComboBox Partido,String Departamento, String Municipio,ComboBox candidato){
            ArrayList <String>lista=new ArrayList<>();
            try {
            File archivo=new File("Listado");
            Scanner entrada=new Scanner(archivo);
            while(entrada.hasNextLine()){
            String linea=entrada.nextLine();
            String mostrar[]=linea.split("-");
           if(PartidoPolitico.getValue()!=null){
               if(tipo.equals(mostrar[0])&&Partido.getValue().toString().equals(mostrar[1])){
                   if(Departamento.equals(mostrar[3])&&Municipio.equals(mostrar[4])){
                       lista.add(mostrar[2]);
                   }
               }
           }
           PartidoPolitico.setPromptText("Sellecione");
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
    public String lugar(){
        File comparar=new File("UbicacionVotante");
        String informacion="";
        try{
            Scanner entrada=new Scanner(comparar);
            while(entrada.hasNextLine()){
                informacion=entrada.nextLine();
            }
        }
        catch (FileNotFoundException e){
            System.out.println("Error"+e);
        }

       return informacion;
    }
    //Funcion que busca y agrega los datos segun el partido seleccionado y segun su ubicacion
    public void listaCandidatos(String tipoCandidatura,ComboBox PartidoPolitico,ComboBox candidato){
        String DM=lugar();
        String l[]=DM.split("-");
        listado(tipoCandidatura,PartidoPolitico,l[0],l[1],candidato);
    }
    //Cambiar de formulario
    public void generarFormulario(String texto,String nombre){
        String formulario=nombre+".fxml";
        try {
            Parent root = FXMLLoader.load(getClass().getResource(formulario));
            Stage regiStage = new Stage();
            regiStage.setTitle(texto);
            regiStage.setScene(new Scene(root));
            regiStage.show();
        } catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }
    //Verificar que no existan campos vacios durante votacion
    public boolean revision(ComboBox candidato){
          boolean r=false;
          if(PartidoPolitico.getValue()==null||candidato.getValue()==null){
          r=true;

          }
          return r;
    }
}
