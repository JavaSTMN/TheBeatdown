package sample;

import java.util.ArrayList;
import java.util.List;

public class Observable {

    public List<ViewMana> ObserverMana = new ArrayList<>();

    public void notification(){
        System.out.println("Observer notifier");
        for (ViewMana view : ObserverMana){
            view.update(view.getManaReserve());
        }
    }


}
