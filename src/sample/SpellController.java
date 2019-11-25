package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Controller lié au fichier à une carte FXML. Fonctionne sur le même principe que le GameController.
 */
public class SpellController {
    @FXML
    private Label manaCost;

    @FXML
    private ImageView portrait;

    @FXML
    private Label name;

    @FXML
    private Label desc;

    private Player owner;

    private Spell spell;

    public void renderCard(Spell s) {
        this.manaCost.setText(Integer.toString(s.getCost()));
        this.portrait.setImage(new Image(Utils.getFileFromResources(s.getImage()).toURI().toString()));
        this.name.setText(s.getName());
        this.desc.setText(s.getDescription());

        this.spell = s;
    }

    @FXML
    protected void handleSpellUse(ActionEvent event) {
        // determine current player and other player
        Player currentTurnPlayer = GameManager.getInstance().getCurrentTurnPlayer();
        Player otherPlayer;
        if (currentTurnPlayer == GameManager.getInstance().getPlayer1()) {
            otherPlayer = GameManager.getInstance().getPlayer2();
        } else {
            otherPlayer = GameManager.getInstance().getPlayer1();
        }

        // check if it's player's allowed to use the spell and if he has enough mana
        if (this.owner == currentTurnPlayer && currentTurnPlayer.getManaReserve().hasEnoughMana(this.spell.getCost())) {
            ISpell is = (ISpell) this.spell;
            if (!this.spell.isTargettedSpell) {
                is.useSpell(currentTurnPlayer, otherPlayer); // use the right spell
            } else {
                GameController.getInstance().setSpellToCast(is);
            }

            // refresh UI
            GameController.getInstance().renderEverything();
        }
    }

    public void setOwner(Player p) {
        this.owner = p;
    }
}
