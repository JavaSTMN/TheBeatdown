package sample;

public abstract class Spell {

    private int actionParam;

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