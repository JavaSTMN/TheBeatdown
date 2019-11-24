package sample;

public class SpellAddManaMax extends Spell implements ISpell {

    public SpellAddManaMax() {
        super.isTargettedSpell = false;
    }

    public void useSpell(Player caster, Object receiver) {
        // adds extra mana crystal
        ManaReserve manaReserve = caster.getManaReserve();
        manaReserve.setMaxMana(manaReserve.getMaxMana() + super.getActionParam());

        super.useSpell(caster, receiver);
    }
}