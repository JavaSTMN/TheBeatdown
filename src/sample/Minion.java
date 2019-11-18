package sample;

public class Minion extends Card {

    private int dmg;
    private int currentHP;
    private int maxHP;

    public Minion(String name, String description, int cost, String image, int dmg, HPReserve hpReserve) {
        super(name, description, cost, image);
        this.dmg = dmg;
        this.currentHP = currentHP;
        this.maxHP = maxHP;
    }

    public int getDmg() {
        return dmg;
    }

    public void setDmg(int dmg) {
        this.dmg = dmg;
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

    public void attack(Minion minion) {
        int dmgAdverse=minion.getDmg();
        minion.loseHP(getDmg());
        loseHP(dmgAdverse);
        if(getCurrentHP()==0)
        {
            die();
        }
        if(minion.getCurrentHP()==0)
        {
            minion.die();
        }
    }

    public void attack(Player player) {
        player.loseHP(getDmg());
    }

    public void die() {
            System.out.println("Le minion est mort");
    }
}