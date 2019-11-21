package sample;

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

    public void renderCard(Spell s) {
        this.manaCost.setText(Integer.toString(s.getCost()));
        this.portrait.setImage(new Image(Utils.getFileFromResources(s.getImage()).toURI().toString()));
        this.name.setText(s.getName());
        this.desc.setText(s.getDescription());
    }
}
