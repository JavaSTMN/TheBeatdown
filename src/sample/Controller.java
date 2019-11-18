package sample;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.io.IOException;

public class Controller {
    @FXML
    private ImageView player1Portrait;

    @FXML
    private ImageView player2Portrait;

    public Controller() {
        updatePlayersPortraits();
    }

    public void updatePlayersPortraits() {
        player1Portrait.setImage(new Image(GameManager.getInstance().getPlayer1().getImage()));
        player2Portrait.setImage(new Image(GameManager.getInstance().getPlayer2().getImage()));
    }
}
