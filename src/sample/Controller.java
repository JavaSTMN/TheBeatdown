package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

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
        // TODO: Render hands
        // TODO: Render decks
        // TODO: Render boards
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
