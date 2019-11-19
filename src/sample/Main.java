package sample;

import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import javax.swing.text.View;
import java.io.IOException;

public class Main extends Application {
    private Stage primaryStage;
    private ViewMana viewMana;
    private BorderPane rootLayout;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("TheBeatDown");
        initRootLayout();
        ViewMana viewMana = new ViewMana();
        viewMana.subscribe();
        viewMana.setPrimaryStage(this.rootLayout);
        System.out.println("Start after set");
        viewMana.getManaReserve().addManaMax(1);
        System.out.println("Start after addMaxMana");
        primaryStage.setScene(viewMana.scene);
        primaryStage.show();
    }

    public void initRootLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("sample.fxml"));
            rootLayout = (BorderPane) loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * Initializes the root layout.
     */

    public Stage getPrimaryStage() {
        return primaryStage;
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
