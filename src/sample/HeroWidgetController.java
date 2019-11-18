package sample;

import java.io.IOException;

import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class HeroWidgetController extends GridPane {
    @FXML private Label heroName;

    public HeroWidgetController() {
    }

    public String getText() {
        return heroName.textProperty().get();
    }

    public void setHeroName(String value) {
        heroName.textProperty().set(value);
    }

    @FXML
    protected void doSomething() {
        System.out.println("The button was clicked!");
    }
}

