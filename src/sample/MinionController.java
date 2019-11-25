package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;

import java.awt.event.ActionEvent;
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

    public void renderCard(Minion m) {
        this.minion = m;
        this.manaCost.setText(Integer.toString(m.getCost()));
        this.portrait.setImage(new Image(Utils.getFileFromResources(m.getImage()).toURI().toString()));
        this.name.setText(m.getName());
        this.atk.setText(Integer.toString(m.getDmg()));
        this.health.setText(Integer.toString(m.getCurrentHP()));
    }

    @FXML
    public void playMinion(MouseEvent mouseEvent) {
        Player currentTurnPlayer = GameManager.getInstance().getCurrentTurnPlayer();
        int currentTurnPlayerCurrentMana = currentTurnPlayer.getManaReserve().getCurrentMana();
        Hand hand = currentTurnPlayer.getHand();
        if (hand.getCards().contains(this.minion) && currentTurnPlayerCurrentMana >= this.minion.getCost()) {
            hand.placeMinionOnBoard(this.minion, currentTurnPlayer);
            currentTurnPlayer.getManaReserve().setCurrentMana(currentTurnPlayerCurrentMana - this.minion.getCost());
            GameController.getInstance().renderBoard(currentTurnPlayer);
            GameController.getInstance().renderHand(currentTurnPlayer);
        } else {
            Minion targetedMinion = new Minion();

            GameController.getInstance().renderEverything();
        }
    }
}