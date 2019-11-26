package sample;

import java.util.ArrayList;

public class Minion extends Card {

    private int dmg;
    private int currentHP;
    private int maxHP;
    private boolean hasAlreadyAttack;

    public Minion(String name, String description, int cost, String image, int dmg, int maxHP, boolean hasAlreadyAttack) {
        super(name, description, cost, image);
        this.dmg = dmg;
        this.currentHP = maxHP;
        this.maxHP = maxHP;
        this.hasAlreadyAttack = true;
    }

    public Minion() {
        super();
    }

    public Minion(Minion minion) {
        super(minion);
        this.dmg = minion.getDmg();
        this.currentHP = minion.getMaxHP();
        this.maxHP = minion.getMaxHP();
        this.hasAlreadyAttack = true;
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

    public boolean isHasAlreadyAttack() {
        return hasAlreadyAttack;
    }

    public void setHasAlreadyAttack(boolean hasAlreadyAttack) {
        this.hasAlreadyAttack = hasAlreadyAttack;
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