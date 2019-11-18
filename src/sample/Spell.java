package sample;

public abstract class Spell extends Card {

    private int actionParam;

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

    public void use() {}
}