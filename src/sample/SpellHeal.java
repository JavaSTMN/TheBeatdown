package sample;

public class SpellHeal extends Spell implements ISpell {

    public SpellHeal() {
        super.isTargettedSpell = true;
    }

    public void useSpell(Player caster, Object receiver) {
        if (receiver instanceof Minion) {
            Minion minion = (Minion) receiver;
            int totalAmount = minion.getCurrentHP() + super.getActionParam();
            if (totalAmount > minion.getMaxHP()) {
                minion.setCurrentHP(minion.getMaxHP());
            } else {
                minion.setCurrentHP(totalAmount);
            }
        } else if (receiver instanceof Player) {
            Player player = (Player) receiver;
            int totalAmount = player.getCurrentHP() + super.getActionParam();
            if (totalAmount > player.getMaxHP()) {
                player.setCurrentHP(player.getMaxHP());
            } else {
                player.setCurrentHP(totalAmount);
            }
        }

        super.useSpell(caster, receiver);
    }
}