package sample;

import java.util.ArrayList;

public class Hand {

    private int initialHandSize;
    private int maxHandSize;
    private ArrayList<Card> cards;
    private Player player;

    public Hand(int initialHandSize, int maxHandSize, ArrayList<Card> cards, Player player) {
        this.initialHandSize = initialHandSize;
        this.maxHandSize = maxHandSize;
        this.cards = cards;
        this.player = player;
    }

    public Hand() {
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

    public void addCards(ArrayList<Card> cs) {
        for (int i = 0; i < cs.size(); i++) {
            if (this.cards.size() + 1 <= this.maxHandSize) {
                this.cards.add(cs.get(i));
            }
        }
    }

    public Hand removeCard(Card c) {
        if (this.getCards().contains(c)) {
            this.getCards().remove(c);
        }
        return this;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void playCard(Card card, Player player) {
        int manaAmount = card.getCost();
        if (card instanceof Minion) {
            this.placeMinionOnBoard((Minion)card, player);
        } else {
            this.useSpell((Spell)card);
        }
        ManaReserve playerManaReserve = player.getManaReserve();
        playerManaReserve.setCurrentMana(playerManaReserve.getCurrentMana() - manaAmount);
    }

    public void placeMinionOnBoard(Minion minion, Player player) {
        ArrayList<Minion> board = player.getBoard();
        if (this.getCards().contains(minion)) {
            board.add(minion);
            this.removeCard(minion);
        }
    }

    public void useSpell(Spell spell) {
        //spell.use();
    }
}