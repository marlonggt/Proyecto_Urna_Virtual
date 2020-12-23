package sample;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Archivos {
    String nombre;
    int voto;
    String doc;

    public Archivos(String nombre, int voto, String doc) throws IOException {
        this.nombre = nombre;
        this.voto = voto;
        this.doc = doc;
        archivo(doc);
        FileWriter almacenar=new FileWriter(doc,true);
        String a=nombre+"-"+voto;
        almacenar.write(a+"\n");
        almacenar.close();
    }

    public void archivo(String nombre) throws IOException {
        File votos=new File(nombre+".txt");
        if(!votos.exists()){
            votos.createNewFile();
        }
    }
}
