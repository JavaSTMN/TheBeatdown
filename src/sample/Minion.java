package sample;

import java.util.ArrayList;

public class Minion extends Card {

    private int dmg;
    private int currentHP;
    private int maxHP;

    public Minion(String name, String description, int cost, String image, int dmg, int maxHP) {
        super(name, description, cost, image);
        this.dmg = dmg;
        this.currentHP = maxHP;
        this.maxHP = maxHP;
    }

    public Minion() {
        super();
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
        int current = getCurrentHP();
        int max = getMaxHP();
        if (current + amount >= max) {
            setCurrentHP(max);
        } else {
            setCurrentHP(current + amount);
        }
    }

    public void loseHP(int amount) {
        if(this.currentHP - amount <= 0) {
            this.currentHP = 0;
            die();
        } else {
            this.currentHP -= amount;
        }
    }

    public void counterAttack (Minion minion){
        minion.loseHP(getDmg());
    }

    public void attack(Minion minion) {
        int dmg=getDmg();
        minion.counterAttack(this);
        minion.loseHP(dmg);
    }

    public void attack(Player player) {
        player.loseHP(getDmg());
    }

    public void lauchAttack(Object receiver) {
        if (receiver instanceof Minion) {
            this.attack((Minion) receiver);
        } else if (receiver instanceof Player) {
            this.attack((Player) receiver);
        }
    }

    public void die() {
        ArrayList<Minion> player1Board = GameManager.getInstance().getPlayer1().getBoard();
        ArrayList<Minion> player2Board = GameManager.getInstance().getPlayer2().getBoard();
        if (player1Board.contains(this)) {
            player1Board.remove(this);
        } else if (player2Board.contains(this)) {
            player2Board.remove(this);
        }
    }
}