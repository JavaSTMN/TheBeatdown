package sample;

public class SpellAddManaMax extends Spell {

    public SpellAddManaMax(String name, String description, int cost, String image, int actionParam) {
        super(name, description, cost, image, actionParam);
    }

    public SpellAddManaMax() {}

    public void use(Player player) {
        ManaReserve manaReserve = player.getManaReserve();
        manaReserve.setMaxMana(manaReserve.getMaxMana() + 1);
    }
}