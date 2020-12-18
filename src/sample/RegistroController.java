package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

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
    @FXML private TextField identidad;
    @FXML private TextField edad;
    @FXML private RadioButton OptMasculino;
    @FXML private RadioButton OptFemenino;
    @FXML private DatePicker Fecha;
    @FXML private ComboBox TipoCandidatura;
    @FXML private ComboBox PartidoPolitico;
    @FXML private ComboBox Departamento;
    @FXML private ComboBox Municipio;

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
    //Agregar a los arraylist datos de municipios y departamentos

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
    public void DatosCombobox(){
    Mostrar(Departamento,Municipio);
}
}
