package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Controller lié au fichier à une carte FXML. Fonctionne sur le même principe que le GameController.
 */
public class MinionController {
    @FXML
    private Label manaCost;

    @FXML
    private ImageView portrait;

    @FXML
    private Label name;

    @FXML
    private Label atk;

    @FXML
    private Label health;

    private Minion minion;

    private Player owner;

    public void renderCard(Minion m) {
        this.manaCost.setText(Integer.toString(m.getCost()));
        this.portrait.setImage(new Image(Utils.getFileFromResources(m.getImage()).toURI().toString()));
        this.name.setText(m.getName());
        this.atk.setText(Integer.toString(m.getDmg()));
        this.health.setText(Integer.toString(m.getCurrentHP()));

        this.minion = m;
    }

    @FXML
    protected void handleMinionClick(ActionEvent event) {
        // determine current player and other player
        Player currentTurnPlayer = GameManager.getInstance().getCurrentTurnPlayer();
        int currentTurnPlayerCurrentMana = currentTurnPlayer.getManaReserve().getCurrentMana();
        Player otherPlayer;
        if (currentTurnPlayer == GameManager.getInstance().getPlayer1()) {
            otherPlayer = GameManager.getInstance().getPlayer2();
        } else {
            otherPlayer = GameManager.getInstance().getPlayer1();
        }

        // if we're trying to cast a spell
        if (GameController.getInstance().getSpellToCast() != null) {
            // if this minion is on a board
            if (GameManager.getInstance().getPlayer1().getBoard().contains(this.minion) || GameManager.getInstance().getPlayer2().getBoard().contains(this.minion)) {
                // cast the spell on this minion
                GameController.getInstance().getSpellToCast().useSpell(currentTurnPlayer, this.minion);
            } else {
                GameController.getInstance().setSpellToCast(null);
            }
        } else {
            Hand hand = currentTurnPlayer.getHand();
            if (hand.getCards().contains(this.minion) && currentTurnPlayerCurrentMana >= this.minion.getCost()) {
                hand.placeMinionOnBoard(this.minion, currentTurnPlayer);
                currentTurnPlayer.getManaReserve().setCurrentMana(currentTurnPlayerCurrentMana - this.minion.getCost());
            } else {
                Minion minionWantsToAttack = GameController.getInstance().getMinionWaitingToAttack();
                if (minionWantsToAttack != null) {
                    if (otherPlayer.getBoard().contains(this.minion)) {
                        minionWantsToAttack.attack(this.minion);
                    } else {
                        GameController.getInstance().setMinionWaitingToAttack(null);
                    }
                } else {
                    GameController.getInstance().setMinionWaitingToAttack(this.minion);
                }
            }
        }

        // refresh UI
        GameController.getInstance().renderEverything();
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }
}