package sample;

public class DatosColumna {

    String candidato;
    String partido;
    public DatosColumna(String candidato, String partido) {
        this.candidato = candidato;
        this.partido = partido;
    }

    public String getCandidato() {
        return candidato;
    }

    public void setCandidato(String candidato) {
        this.candidato = candidato;
    }

    public String getPartido() {
        return partido;
    }

    public void setPartido(String partido) {
        this.partido = partido;
    }
}
