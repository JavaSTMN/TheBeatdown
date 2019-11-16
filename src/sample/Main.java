package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }

    public static void main(String[] args) {
        ArrayList<Player> players = new GameJsonParser<Player>(Player.class).generateListFromJson();
        ArrayList<Minion> minions = new GameJsonParser<Minion>(Minion.class).generateListFromJson();
        ArrayList<Spell> spells = new GameJsonParser<Spell>(Spell.class).generateListFromJson();

        launch(args);
    }
}
