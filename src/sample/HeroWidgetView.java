package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.io.IOException;

public class HeroWidgetView {

    public static HeroWidgetController render() {
        HeroWidgetController customControl = new HeroWidgetController();
        customControl.setHeroName("Jaina Proudmoore");

        return customControl;
    }
}
