package sample;

import java.util.ArrayList;

public class ResultadoVotacion {

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
                    resultado = "empate";
            }

        }

        return resultado;
    }


}
