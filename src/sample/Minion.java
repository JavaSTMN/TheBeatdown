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
        // TODO
    }

    public void attack(Player player) {
        // TODO
    }

    public void die() {
        // TODO
    }
}