package sample;

import java.util.ArrayList;

public class SpellPickCard extends Spell implements ISpell {

    public SpellPickCard() {
        super.isTargettedSpell = false;
    }

    public void useSpell(Player caster, Object receiver) {
        super.useSpell(caster, receiver);

        Deck deck = caster.getDeck();
        int nbCards = deck.getCards().size();
        if (nbCards >= this.getActionParam()) {
            ArrayList<Card> cards = deck.pickCardsFromDeck(super.getActionParam());
            caster.getHand().addCards(cards);
        } else {
            if (nbCards > 0 && super.getActionParam() > nbCards) {
                ArrayList<Card> cards = deck.pickCardsFromDeck(super.getActionParam() - nbCards);
                caster.getHand().addCards(cards);
            }
            int difference = super.getActionParam() - nbCards;
            for (int i = 0; i < difference; i++) {
                caster.triggerHPLossPerTurn();
            }
        }
    }
}