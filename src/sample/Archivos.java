package sample;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Archivos {
    String nombre;
    int voto;
    String doc;

    public Archivos(String doc, String nombre, int voto) throws IOException {
        this.nombre = nombre;
        this.voto = voto;
        this.doc=doc;
        archivo(doc);

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getVoto() {
        return voto;
    }

    public void setVoto(int voto) {
        this.voto = voto;
    }
    public void archivo(String nombre) throws IOException {
        File votos=new File(nombre+".txt");
        if(!votos.exists()){
            votos.createNewFile();
        }
    }
}
