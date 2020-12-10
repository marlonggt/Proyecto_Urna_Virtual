package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginVotanteController {

    @FXML
    private ImageView logoImage;

    public void initialize(URL url, ResourceBundle resourceBundle){

        Image image = new Image("/Imagen/tse.png");
        logoImage.setImage(image);

    }

}
