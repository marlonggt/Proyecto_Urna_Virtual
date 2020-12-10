package sample;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginVotanteController {

    @FXML
    private ImageView logoImage;

    public void initialize(URL url, ResourceBundle resourceBundle){

        Image image = new Image("/Imagenes/tse.png");
        logoImage.setImage(image);

    }

}
