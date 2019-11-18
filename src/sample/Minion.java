package sample;

public class Minion extends Card {

    private int dmg;
    private HPReserve hpReserve;

    public Minion(String name, String description, int cost, String image, int dmg, HPReserve hpReserve) {
        super(name, description, cost, image);
        this.dmg = dmg;
        this.hpReserve = hpReserve;
    }

    public int getDmg() {
        return dmg;
    }

    public void setDmg(int dmg) {
        this.dmg = dmg;
    }

    public HPReserve getHpReserve() {
        return hpReserve;
    }

    public void setHpReserve(HPReserve hpReserve) {
        this.hpReserve = hpReserve;
    }

    public void attack(Minion minion) {
        int dmgAdverse=minion.getDmg();
        minion.hpReserve.loseHP(getDmg());
        hpReserve.loseHP(dmgAdverse);
        if(hpReserve.getCurrentHP()==0)
        {
            die();
        }
        if(minion.hpReserve.getCurrentHP()==0)
        {
            minion.die();
        }
    }

    public void attack(Player player) {
        player.getHpReserve().loseHP(getDmg());
    }

    public void die() {
        if(hpReserve.getCurrentHP()==0){
            System.out.println("Le minion est mort");
        }
    }
}