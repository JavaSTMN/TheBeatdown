package sample;

public class ManaReserve {

    private int currentMana;
    private int maxMana;
    private int maxManaSlots;

    public ManaReserve(int currentMana, int maxMana, int maxManaSlots) {
        this.currentMana = currentMana;
        this.maxMana = maxMana;
        this.maxManaSlots = maxManaSlots;
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

    public void addManaMax(int amount) {
        // TODO
    }

    public void refillMana(int amount) {
        // TODO
    }

    public boolean hasEnoughMana(int amount) {
        // TODO
        return true;
    }

    public void decreaseMana(int amount) {
        // TODO
    }
}