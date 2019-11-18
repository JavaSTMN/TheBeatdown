package sample;

import java.util.ArrayList;

public class Observable {

    public ArrayList<ViewMana> ObserverMana;

    public void notification(){
        for (ViewMana view : ObserverMana){
            view.update(view.getManaReserve());
        }
        System.out.println("Observer notifier");
    }


}
