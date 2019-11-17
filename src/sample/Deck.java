package sample;

import java.util.*;

public class Deck {

    private ArrayDeque<Card> cards;

    public Deck(ArrayDeque<Card> cards) {
        this.cards = cards;
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

    public ArrayDeque<Card> pickCardsFromDeck(int amount) {
        // TODO
        return new ArrayDeque<Card>();
    }
}