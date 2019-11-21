package sample;

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

    public void renderCard(Minion m) {
        this.manaCost.setText(Integer.toString(m.getCost()));
        this.portrait.setImage(new Image(Utils.getFileFromResources(m.getImage()).toURI().toString()));
        this.name.setText(m.getName());
        this.atk.setText(Integer.toString(m.getDmg()));
        this.health.setText(Integer.toString(m.getCurrentHP()));
    }
}
