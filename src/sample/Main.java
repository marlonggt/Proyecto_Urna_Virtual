package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("LoginVotante.fxml"));
        primaryStage.setTitle("Urna Virtual 2020");
        primaryStage.setScene(new Scene(root, 700, 480));
        primaryStage.show();
        primaryStage.resizableProperty().setValue(false);

        //commit de prueba
    }

    public static void main(String[] args) {
        launch(args);
    }
}
