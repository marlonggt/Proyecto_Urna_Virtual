package sample;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;

import java.awt.*;
import java.awt.event.ActionEvent;


public class CandidatosAlcaldesController {

    @FXML private ChoiceBox partidosPoliticos;
    @FXML private ChoiceBox candidatos;

    @FXML public void partidos(ActionEvent event){

        String partidos = partidosPoliticos.getValue().toString();

    }
}
