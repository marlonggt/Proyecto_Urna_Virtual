package sample;

import java.util.ArrayList;

public class Partido {

    public String Nombre;
    public String Presidente;
    public int NumeroCandidatos;
    public String nombrePromotor;

    static ArrayList<Partido> listaPartido = new ArrayList<>();

    public Partido(String nombre, String presidente, int numeroCandidatos) {
        super();
        Nombre = nombre;
        Presidente = presidente;
        NumeroCandidatos = numeroCandidatos;
    }

    @Override
    public String toString() {
        return "Partido{" +
                "Nombre='" + Nombre + '\'' +
                ", Presidente='" + Presidente + '\'' +
                ", NumeroCandidatos=" + NumeroCandidatos +
                '}';
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getPresidente() {
        return Presidente;
    }

    public void setPresidente(String presidente) {
        Presidente = presidente;
    }

    public int getNumeroCandidatos() {
        return NumeroCandidatos;
    }

    public void setNumeroCandidatos(int numeroCandidatos) {
        NumeroCandidatos = numeroCandidatos;
    }

    public void agregarPartido(Partido partido)
    {
        listaPartido.add(partido);
    }

    public void cambiarPartido_nombrePresidente(String nombrePartido,String nuevoNombrePresidente)
    {
        for (int i=0;i<listaPartido.size();++i)
        {
            Partido partido = listaPartido.get(i);
            if(partido.Nombre == nombrePartido)
            {
                partido.Presidente = nuevoNombrePresidente;

            }
        }
    }


}
