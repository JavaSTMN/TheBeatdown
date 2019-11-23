package sample;

public class SpellAddManaMax extends Spell implements ISpell {

    public SpellAddManaMax(String name, String description, int cost, String image, int actionParam) {
        super(name, description, cost, image, actionParam);
    }

    public SpellAddManaMax() {}

    public void useSpell(Player caster, Object receiver) {
        // adds extra mana crystal
        ManaReserve manaReserve = caster.getManaReserve();
        manaReserve.setMaxMana(manaReserve.getMaxMana() + 1);

        super.useSpell(caster, receiver);
    }
}