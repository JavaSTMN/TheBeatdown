package sample;

public abstract class Spell extends Card implements ISpell, Cloneable {

    public enum SpellType {
        RANDOM_SPLITTED_DMG,
        DRAW_CARDS,
        ADD_MANA_SLOT,
        HEAL
    }

    private int actionParam;

    protected boolean isTargettedSpell;

    public Object clone()throws CloneNotSupportedException{
        return super.clone();
    }

    public Spell() {}

    public Spell(String name, String description, int cost, String image, int actionParam) {
        super(name, description, cost, image);
        this.actionParam = actionParam;
    }

    public int getActionParam() {
        return actionParam;
    }

    public void setActionParam(int actionParam) {
        this.actionParam = actionParam;
    }

    public void useSpell(Player caster, Object receiver) {
        // check if it's a hero spell
        if (this == caster.getHeroSpell()) {
            // disable hero spell
            caster.setHeroSpellAvailable(false);
            GameController.getInstance().disableHeroSpell(caster);
        } else {
            // remove card from hand
            caster.getHand().removeCard(this);
        }

        // remove cost from current mana
        caster.getManaReserve().decreaseMana(this.getCost());
    }
}