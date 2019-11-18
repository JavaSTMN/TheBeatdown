package sample;

import java.util.ArrayList;

public class Deck {

    private ArrayList<Card> cards;

    public Deck(ArrayList<Card> cards) {
        this.cards = cards;
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public void setCards(ArrayList<Card> cards) {
        this.cards = cards;
    }

    public void shuffle() {
        // TODO
    }

    public ArrayList<Card> pickCardsFromDeck(int amount) {
        // TODO
        return  new ArrayList<>();
    }
}