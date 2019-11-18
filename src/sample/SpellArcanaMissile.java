package sample;

import java.util.ArrayList;
import java.util.Random;

public class SpellArcanaMissile extends Spell {

    public SpellArcanaMissile() {}

    public SpellArcanaMissile(String name, String description, int cost, String image, int actionParam) {
        super(name, description, cost, image, actionParam);
    }

    public void use(Player target) {
        ArrayList<Object> targets = new ArrayList<>();
        targets.add(target);
        targets.addAll(target.getBoard());
        for (int i = 0; i < 3; i++) {
            int targetIndex = new Random().nextInt(targets.size());
            Object randomTarget = targets.get(targetIndex);
            if (randomTarget instanceof Player) {
                ((Player) randomTarget).loseHP(this.getActionParam());
            } else if (randomTarget instanceof Minion) {
                ((Minion) randomTarget).loseHP(this.getActionParam());
            }
        }
    }
}