package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Main extends Application {

    private Stage primaryStage;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Hello World");
        this.primaryStage.setScene(new Scene(root, 1366, 768));
        //primaryStage.setFullScreen(true);
        this.primaryStage.show();
    }

    public static void main(String[] args) {
        try {
            new GameManager();
            GameManager.getInstance().initGame();

            launch(args);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
