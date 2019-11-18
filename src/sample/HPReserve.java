package sample;

public class HPReserve {
    private int currentHP;
    private int maxHP;

    public HPReserve(int currentHP, int maxHP) {
        this.currentHP = currentHP;
        this.maxHP = maxHP;
    }

    public int getCurrentHP() {
        return currentHP;
    }

    public void setCurrentHP(int currentHP) {
        this.currentHP = currentHP;
    }

    public int getMaxHP() {
        return maxHP;
    }

    public void setMaxHP(int maxHP) {
        this.maxHP = maxHP;
    }

    public void recoverHP(int amount) {
        // TODO
    }

    public void loseHP(int amount) {
        // TODO
    }
}