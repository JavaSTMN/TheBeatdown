package sample;

import java.util.ArrayList;

public class SpellPickCard extends Spell implements ISpell {

    public SpellPickCard() {
        super.isTargettedSpell = false;
    }

    public void useSpell(Player caster, Object receiver) {
        Deck deck = caster.getDeck();
        ArrayList<Card> cards = deck.pickCardsFromDeck(super.getActionParam());
        caster.getHand().addCards(cards);

        super.useSpell(caster, receiver);
    }
}