package sample;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Observable {

    public List<ViewMana> ObserverMana = new ArrayList<>();

    public void notification() throws IOException {
        System.out.println("Observer notifier");
        for (ViewMana view : ObserverMana){
            view.update(view.getManaReserve());
        }
    }


}
