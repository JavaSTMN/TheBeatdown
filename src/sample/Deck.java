package sample;

import java.util.*;

public class Deck {

    private int maxDeckSize;
    private ArrayDeque<Card> cards;

    public Deck(int maxDeckSize, ArrayDeque<Card> cards) {
        this.maxDeckSize = maxDeckSize;
        this.cards = new ArrayDeque<>();

        int s = cards.size();
        for (int i = 0; i < s; i++) {
            Card poppedCard  = cards.pop();
            if (poppedCard instanceof Minion) {
                this.cards.push(new Minion((Minion) poppedCard));
            } else {
                Spell spell = (Spell) poppedCard;
                try {
                    this.cards.push((Spell)spell.clone());
                } catch (CloneNotSupportedException e) {
                    e.printStackTrace();
                }
            }
        }

        shuffle();
    }

    public ArrayDeque<Card> getCards() {
        return cards;
    }

    public void setCards(ArrayDeque<Card> cards) {
        this.cards = cards;
    }

    public void shuffle() {
        // get arraydeque as arraylist
        ArrayList<Card> shuffledCards = new ArrayList<>();
        int cardsInDeque = this.cards.size();
        for(int i = 0; i < cardsInDeque; i++) {
            shuffledCards.add(this.cards.pop());
        }

        // shuffle list
        Collections.shuffle(shuffledCards);

        // fill cards arraydeque
        for(int i = 0; i < cardsInDeque; i++) {
            this.cards.push(shuffledCards.get(i));
        }
    }

    /**
     * Pops amount of cards from deck and returns them
     * @param amount
     * @return
     */
    public ArrayList<Card> pickCardsFromDeck(int amount) {
        ArrayList<Card> pickedCards = new ArrayList<>();

        for (int i = 0; i < amount; i++) {
            pickedCards.add(this.cards.pop());
        }

        return pickedCards;
    }

    public int getMaxDeckSize() {
        return maxDeckSize;
    }

    public void setMaxDeckSize(int maxDeckSize) {
        this.maxDeckSize = maxDeckSize;
    }
}