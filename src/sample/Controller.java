package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Controller lié au fichier FXML principal, permettant la maj des éléments d'UI.
 * Pour accéder à un composant de l'UI, il faut aller dans le FXML correspondant et donner un id au composant voulu.
 * Ensuite, dans le code ici, on déclare une var privée du type du composant, avec @FXML au dessus.
 * Voir les examples ci-dessous.
 */
public class Controller implements Initializable {
    public static Controller instance;
    public static Controller getInstance() {
        return instance;
    }

    @FXML
    private ImageView player1Portrait;

    @FXML
    private ImageView player2Portrait;

    @FXML
    private HBox player1Hand;

    @FXML
    private HBox player2Hand;

    /**
     * Inits the game visuals
     * @param location
     * @param resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        renderEverything();
    }

    private void renderEverything() {
        renderHeroes();
        // TODO: Render mana reserves
        renderHands();
        // TODO: Render decks
        // TODO: Render boards
    }

    private void renderHands() {
        try {
            renderHand(GameManager.getInstance().getPlayer1());
            renderHand(GameManager.getInstance().getPlayer2());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void renderHand(Player p) throws IOException {
        for (int i = 0; i < p.getHand().getCards().size() + 6; i++) {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("card.fxml"));
            Button handContainer = (Button) loader.load();

            // Set person overview into the center of root layout.
            //personOverview.setTranslateX(50*i+1);
            if (p == GameManager.getInstance().getPlayer1()) {
                this.player1Hand.getChildren().add(handContainer);
            } else {
                this.player2Hand.getChildren().add(handContainer);
            }
        }
    }

    public void renderHeroes() {
        initHeroesPortraits();
        // TODO: Render rest of heroes stuff
    }

    private void initHeroesPortraits() {
        // player1
        Image imgP1 = new Image(Utils.getFileFromResources(GameManager.getInstance().getPlayer1().getImage()).toURI().toString());
        player1Portrait.setImage(imgP1);

        // player2
        Image imgP2 = new Image(Utils.getFileFromResources(GameManager.getInstance().getPlayer2().getImage()).toURI().toString());
        player2Portrait.setImage(imgP2);
    }
}
