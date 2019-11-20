package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * Controller lié au fichier FXML principal, permettant la maj des éléments d'UI.
 * Pour accéder à un composant de l'UI, il faut aller dans le FXML correspondant et donner un id au composant voulu.
 * Ensuite, dans le code ici, on déclare une var privée du type du composant, avec @FXML au dessus.
 * Voir les examples ci-dessous.
 */
public class GameController implements Initializable {
    public static GameController instance;
    public static GameController getInstance() {
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
        ArrayList<Card> cards = p.getHand().getCards();

        for (int i = 0; i < cards.size(); i++) {
            FXMLLoader loader = new FXMLLoader();
            // if minion card
            if (cards.get(i) instanceof Minion) {
                // load fmxl of the card
                loader.setLocation(Main.class.getResource("minion.fxml"));
                Button cardUI = (Button) loader.load();
                MinionController cc = (MinionController) loader.getController();
                cc.renderCard((Minion) cards.get(i));

                // display card on right hand
                if (p == GameManager.getInstance().getPlayer1()) {
                    this.player1Hand.getChildren().add(cardUI);
                } else {
                    this.player2Hand.getChildren().add(cardUI);
                }
            } else { // if spell card
                // TODO: Handle spell card
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
