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

import java.io.IOException;

public class Main extends Application {
    private Stage primaryStage;
    private BorderPane rootLayout;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("TheBeatDown");

        initRootLayout();
        showPersonOverview();
    }

    /**
     * Initializes the root layout.
     */
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


    public void showPersonOverview() {
        try {
            // Load person overview.
            GameManager.getInstance().getPlayer1().getManaReserve().setMaxMana(6);
            int manaMax = GameManager.getInstance().getPlayer1().getManaReserve().getMaxMana();
            for(int i=0;i<manaMax;i++) {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(Main.class.getResource("manaBar.fxml"));
                AnchorPane personOverview = (AnchorPane) loader.load();

                // Set person overview into the center of root layout.
                personOverview.setTranslateX(50*i+1);
                rootLayout.getChildren().add(personOverview);
            }
            GameManager.getInstance().getPlayer1().getManaReserve().setCurrentMana(3);
            int mana = GameManager.getInstance().getPlayer1().getManaReserve().getCurrentMana();
            for(int i=0;i<mana;i++) {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(Main.class.getResource("manaAvailable.fxml"));
                AnchorPane personOverview = (AnchorPane) loader.load();

                // Set person overview into the center of root layout.
                personOverview.setTranslateX(50*i+1);
                rootLayout.getChildren().add(personOverview);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }


    public static void main(String[] args) {
        try {
            //new GameManager();
            //GameManager.getInstance().initGame();

            ViewMana viewMana = new ViewMana();
            viewMana.getManaReserve().setCurrentMana(4);

            //launch(args);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
