package sample;

import java.util.ArrayList;

public class SpellPickCard extends Spell {

    public SpellPickCard() {}

    public SpellPickCard(String name, String description, int cost, String image, int actionParam) {
        super(name, description, cost, image, actionParam);
    }

    public void use(Player player) {
        Deck deck = player.getDeck();
        ArrayList<Card> cards = deck.pickCardsFromDeck(this.getActionParam());
        player.getHand().addCards(cards);
    }
}