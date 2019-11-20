package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    private Stage primaryStage;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("game.fxml"));
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("The Beatdown");
        this.primaryStage.setScene(new Scene(root, 1400, 800));
        //primaryStage.setFullScreen(true);
        this.primaryStage.show();

        // Tests displaying stuff on board
        //GameManager.getInstance().getPlayer1().getBoard().add((Minion)GameManager.getInstance().getPlayer1().getHand().getCards().get(0));
        //GameController.getInstance().renderBoards();
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
