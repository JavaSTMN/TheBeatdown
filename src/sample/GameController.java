package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

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

    @FXML
    private HBox player1Board;

    @FXML
    private HBox player2Board;

    @FXML
    private ProgressIndicator player1TurnIndicator;

    @FXML
    private ProgressIndicator player2TurnIndicator;

    @FXML
    private Label player1DeckSize;

    @FXML
    private Label player2DeckSize;

    @FXML
    private Label player1Health;

    @FXML
    private Label player2Health;

    @FXML
    private Label player1Mana;

    @FXML
    private Label player2Mana;


    /**
     * Inits the game visuals
     * @param location
     * @param resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        instance = this;
        renderEverything();
    }

    @FXML
    protected void handleEndTurnAction(ActionEvent event) {
        Player currentTurnPlayer = GameManager.getInstance().getCurrentTurnPlayer();

        if (currentTurnPlayer == GameManager.getInstance().getPlayer1()) {
            this.player1TurnIndicator.setVisible(false);
            this.player2TurnIndicator.setVisible(true);
        } else {
            this.player1TurnIndicator.setVisible(true);
            this.player2TurnIndicator.setVisible(false);
        }

        GameManager.getInstance().endTurn(currentTurnPlayer);
    }

    public void renderEverything() {
        renderHeroes();
        renderHeroesManaReserve();
        renderHands();
        renderDecks();
        renderBoards();
    }

    /** HEROES **/

    /**
     * Renders all that is related to the heroes
     */
    public void renderHeroes() {
        renderHeroesPortraits();
        renderHeroesHealth();
        // TODO: Render rest of heroes stuff
    }

    /**
     * Inits portraits of both heroes.
     */
    private void renderHeroesPortraits() {
        if (this.player1Portrait.getImage() == null || this.player2Portrait.getImage() == null) {
            // player1
            Image imgP1 = new Image(Utils.getFileFromResources(GameManager.getInstance().getPlayer1().getImage()).toURI().toString());
            player1Portrait.setImage(imgP1);

            // player2
            Image imgP2 = new Image(Utils.getFileFromResources(GameManager.getInstance().getPlayer2().getImage()).toURI().toString());
            player2Portrait.setImage(imgP2);
        }
    }

    /**
     * Renders heroes health points.
     */
    private void renderHeroesHealth() {
        this.player1Health.setText(Integer.toString(GameManager.getInstance().getPlayer1().getCurrentHP()));
        this.player2Health.setText(Integer.toString(GameManager.getInstance().getPlayer2().getCurrentHP()));
    }
    /**
     * Renders heroes Mana Reserve.
     */
    private void renderHeroesManaReserve(){
        this.player1Mana.setText(getHeroesMana(GameManager.getInstance().getPlayer1()));
        this.player2Mana.setText(getHeroesMana(GameManager.getInstance().getPlayer2()));
    }

    private String getHeroesMana(Player p){
        String mana ="";
        int max = p.getManaReserve().getMaxMana();
        int current = p.getManaReserve().getCurrentMana();

        mana = current + "/" + max;
        return (mana);
    }
    /** HANDS **/

    /**
     * Renders the hands of both players.
     */
    public void renderHands() {
        renderHand(GameManager.getInstance().getPlayer1());
        renderHand(GameManager.getInstance().getPlayer2());
    }

    /**
     * Renders the hand of the given player.
     * @param p
     */
    public void renderHand(Player p)  {
        // get the right (good) hand container for the player p
        Pane rightContainer;
        if (p == GameManager.getInstance().getPlayer1()) {
            rightContainer = this.player1Hand;
        } else {
            rightContainer = this.player2Hand;
        }

        // clear the container
        rightContainer.getChildren().clear();

        // render cards in the hand
        ArrayList<Card> cards = p.getHand().getCards();

        for (int i = 0; i < cards.size(); i++) {
            renderCard(cards.get(i), rightContainer);
        }
    }

    /**
     * Renders a card in a given UI container.
     * @param cardToRender
     * @param container
     */
    private void renderCard(Card cardToRender, Pane container) {
        try {
            FXMLLoader loader = new FXMLLoader();
            Button cardUI;

            // if minion card
            if (cardToRender instanceof Minion) {
                // load fmxl of the card
                loader.setLocation(Main.class.getResource("minion.fxml"));
                cardUI = (Button) loader.load();
                MinionController cc = (MinionController) loader.getController();
                cc.renderCard((Minion) cardToRender);
            } else { // if spell card
                // load fmxl of the card
                loader.setLocation(Main.class.getResource("spell.fxml"));
                cardUI = (Button) loader.load();
                SpellController cc = (SpellController) loader.getController();
                cc.renderCard((Spell) cardToRender);
            }

            // display card
            container.getChildren().add(cardUI);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /** BOARD **/

    /**
     * Renders the boards of both players.
     */
    public void renderBoards() {
        renderBoard(GameManager.getInstance().getPlayer1());
        renderBoard(GameManager.getInstance().getPlayer2());
    }

    /**
     * Renders the board of the given player.
     * @param p
     */
    public void renderBoard(Player p)  {
        // get the right (good) board container for the player p
        Pane rightContainer;
        if (p == GameManager.getInstance().getPlayer1()) {
            rightContainer = this.player1Board;
        } else {
            rightContainer = this.player2Board;
        }

        // clear the container
        rightContainer.getChildren().clear();

        // add the cards to the container
        ArrayList<Minion> minions = p.getBoard();
        for (int i = 0; i < minions.size(); i++) {
            renderCard(minions.get(i), rightContainer);
        }
    }

    /** DECK **/

    /**
     * Renders both decks.
     */
    private void renderDecks() {
        renderDeck(GameManager.getInstance().getPlayer1());
        renderDeck(GameManager.getInstance().getPlayer2());
    }

    /**
     * Renders the deck of the given player.
     * @param p
     */
    private void renderDeck(Player p) {
        int deckSize = p.getDeck().getCards().size();
        if (p == GameManager.getInstance().getPlayer1()) {
            this.player1DeckSize.setText(Integer.toString(deckSize));
        } else {
            this.player2DeckSize.setText(Integer.toString(deckSize));
        }
    }
}
