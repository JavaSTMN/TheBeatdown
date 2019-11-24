package sample;

import java.util.ArrayList;
import java.util.Random;

public class SpellArcanaMissile extends Spell implements ISpell {

    public SpellArcanaMissile() {
        super.isTargettedSpell = false;
    }

    public void useSpell(Player caster, Object receiver) {
        Player opponent = (Player) receiver;

        ArrayList<Object> targets = new ArrayList<>();
        for (int i = 0; i < super.getActionParam(); i++) {
            targets.clear();
            targets.add(opponent);
            targets.addAll(opponent.getBoard());
            int targetIndex = new Random().nextInt(targets.size());
            Object randomTarget = targets.get(targetIndex);
            if (randomTarget instanceof Player) {
                ((Player) randomTarget).loseHP(1);
            } else if (randomTarget instanceof Minion) {
                ((Minion) randomTarget).loseHP(1);
            }
        }

        super.useSpell(caster, receiver);
    }
}