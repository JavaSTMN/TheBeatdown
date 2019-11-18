package sample;

public class SpellHeal extends Spell {

    public SpellHeal() {}

    public SpellHeal(String name, String description, int cost, String image, int actionParam) {
        super(name, description, cost, image, actionParam);
    }

    public void use(Object o) {
        if (o instanceof Minion) {
            Minion minion = (Minion) o;
            int totalAmount = minion.getCurrentHP() + this.getActionParam();
            if (totalAmount > minion.getMaxHP()) {
                minion.setCurrentHP(minion.getMaxHP());
            } else {
                minion.setCurrentHP(totalAmount);
            }
        } else if (o instanceof Player) {
            Player player = (Player) o;
            int totalAmount = player.getCurrentHP() + this.getActionParam();
            if (totalAmount > player.getMaxHP()) {
                player.setCurrentHP(player.getMaxHP());
            } else {
                player.setCurrentHP(totalAmount);
            }
        }
    }
}