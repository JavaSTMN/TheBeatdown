package sample;

public abstract class Spell extends Card implements ISpell {

    public enum SpellType {
        RANDOM_SPLITTED_DMG,
        DRAW_CARDS,
        ADD_MANA_SLOT,
        HEAL
    }

    private int actionParam;

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

    public void useSpell(Object caster, Object receiver) {}
}