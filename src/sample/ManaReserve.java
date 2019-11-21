package sample;


import java.io.IOException;

public class ManaReserve extends Observable {

    private int currentMana;
    private int maxMana;
    private int maxManaSlots = 8;

    public ManaReserve(int currentMana, int maxMana) {
        this.currentMana = currentMana;
        this.maxMana = maxMana;
    }

    public int getCurrentMana() {
        return currentMana;
    }

    public void setCurrentMana(int currentMana) {
        this.currentMana = currentMana;
    }

    public int getMaxMana() {
        return maxMana;
    }

    public void setMaxMana(int maxMana) {
        this.maxMana = maxMana;
    }

    public int getMaxManaSlots() {
        return maxManaSlots;
    }

    public void setMaxManaSlots(int maxManaSlots) {
        this.maxManaSlots = maxManaSlots;
    }

    public void addObserver(ViewMana viewMana)
    {
        System.out.println(viewMana.name);
        this.ObserverMana.add(viewMana);
    }

    public void addManaMax(int amount) throws IOException {
        int manaMax = getMaxMana();
        int slotsMax=getMaxManaSlots();
        if((manaMax+amount)<slotsMax){
            setMaxMana(manaMax+amount);
        }
        System.out.println("Print addManaMax");
        notification();
    }

    public void refillMana(int amount) throws IOException {
        int manaMax = getMaxMana();
        int current = getCurrentMana();
        if(current+amount<=manaMax){
            setCurrentMana(current+amount);
        }
        else{
            setCurrentMana(manaMax);
        }
        notification();
    }

    public boolean hasEnoughMana(int amount) {
        int current = getCurrentMana();
        if(current>=amount)
        {
            return true;
        }
        else{
            return false;
        }
    }

    public void decreaseMana(int amount) throws IOException {
        if(hasEnoughMana(amount)) {
            int current=getCurrentMana();
            setCurrentMana(current-amount);
        }
        notification();
    }
}