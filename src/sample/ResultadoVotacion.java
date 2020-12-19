package sample;

import java.util.ArrayList;

public class ResultadoVotacion {

    int contadorVotosPresidente;
    int ContadorVotosDiputado;
    int contadorvotos;

    ArrayList <String> getCandidatos = new ArrayList();

    //ingresar el voto y sumarlo a contador
    public void votar(){

    }

    //Elige al ganador
    public int elegirGanador(){
        int masVotos = getCandidatos.indexOf(0);
        int ganador = 0;

        for (int i = 0; i < getCandidatos.size(); i++){
            if(getCandidatos.indexOf(i) > masVotos){
                ganador = i;
                masVotos = getCandidatos.indexOf(i);

            }

        }

        return ganador;
    }


}
