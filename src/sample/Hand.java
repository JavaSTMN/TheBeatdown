package sample;

import java.util.ArrayList;

public class Hand {

    private int initialHandSize;
    private int maxHandSize;
    private ArrayList<Card> cards;

    public Hand(int initialHandSize, int maxHandSize, ArrayList<Card> cards) {
        this.initialHandSize = initialHandSize;
        this.maxHandSize = maxHandSize;
        this.cards = cards;
    }

    public int getInitialHandSize() {
        return initialHandSize;
    }

    public void setInitialHandSize(int initialHandSize) {
        this.initialHandSize = initialHandSize;
    }

    public int getMaxHandSize() {
        return maxHandSize;
    }

    public void setMaxHandSize(int maxHandSize) {
        this.maxHandSize = maxHandSize;
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public void setCards(ArrayList<Card> cards) {
        this.cards = cards;
    }

    public void playCard(Card card) {
        // TODO
    }

    public void placeMinionOnBoard(Minion minion) {
        // TODO
    }

    public void userSpell(Spell spell) {
        // TODO
    }
}