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
        int current=getCurrentHP();
        int max=getMaxHP();
        if(current+amount>=max)
        {
            setCurrentHP(max);
        }
        else
        {
            setCurrentHP(current+amount);
        }
    }

    public void loseHP(int amount) {
        int current = getCurrentHP();
        if(current-amount<0)
        {
            setCurrentHP(0);
        }
        else {
            setCurrentHP(current-amount);
        }
    }
}