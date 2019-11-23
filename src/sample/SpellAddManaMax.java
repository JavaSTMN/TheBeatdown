package sample;

public class SpellAddManaMax extends Spell implements ISpell {

    public SpellAddManaMax(String name, String description, int cost, String image, int actionParam) {
        super(name, description, cost, image, actionParam);
    }

    public SpellAddManaMax() {}

    public void useSpell(Object caster, Object receiver) {
        super.useSpell(caster, receiver);

        // adds extra mana crystal
        Player p = (Player) caster;
        ManaReserve manaReserve = p.getManaReserve();
        manaReserve.setMaxMana(manaReserve.getMaxMana() + 1);

        // remove mana used from using the card

    }
}