package sample;

public abstract class Spell extends Card {

    public enum SpellType {
        RANDOM_SPLITTED_DMG,
        DRAW_CARDS,
        ADD_MANA_SLOT,
        HEAL
    }

    private int actionParam;

    public Spell() {
    }

    public Spell(int actionParam) {
        this.actionParam = actionParam;
    }

    public int getActionParam() {
        return actionParam;
    }

    public void setActionParam(int actionParam) {
        this.actionParam = actionParam;
    }

    public void use() {}
}