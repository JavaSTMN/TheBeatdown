package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewMana implements Observer{

    private ManaReserve manaReserve;
    public String name;
    private BorderPane rootLayout;
    public Scene scene;

    public ViewMana(){
        this.manaReserve = new ManaReserve(0,0);
        this.name="Nom";
    }

    public void setPrimaryStage(BorderPane rootLayout){this.rootLayout=rootLayout;}

    public void subscribe()
    {
        manaReserve.addObserver(getViewMana());
    }

    public ViewMana getViewMana() {return this;};
    public ManaReserve getManaReserve(){ return this.manaReserve;}

    @Override
    public void update(ManaReserve manaReserve) {
        System.out.println("Update");
        showPersonOverview(this.rootLayout);
    }

    public void showPersonOverview(BorderPane rootLayout) {

        // Show the scene containing the root layout.
        Scene scene = new Scene(rootLayout);
        try {
            // Load person overview.
            int manaMax = GameManager.getInstance().getPlayer1().getManaReserve().getMaxMana();
            for(int i=0;i<manaMax;i++) {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(Main.class.getResource("manaBar.fxml"));
                AnchorPane personOverview = (AnchorPane) loader.load();

                // Set person overview into the center of root layout.
                personOverview.setTranslateX(50*i+1);
                rootLayout.getChildren().add(personOverview);
            }
            int mana = GameManager.getInstance().getPlayer1().getManaReserve().getCurrentMana();
            for(int i=0;i<mana;i++) {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(Main.class.getResource("manaAvailable.fxml"));
                AnchorPane personOverview = (AnchorPane) loader.load();

                // Set person overview into the center of root layout.
                personOverview.setTranslateX(50*i+1);
                rootLayout.getChildren().add(personOverview);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.scene=scene;
    }



}
