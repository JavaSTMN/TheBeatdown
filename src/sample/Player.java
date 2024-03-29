package sample;

import java.util.ArrayList;

public class Player {

    private HPReserve hpReserve;
    private ManaReserve manaReserve;
    private String image;
    private Deck deck;
    private Hand hand;
    private ArrayList<Minion> board;
    private Spell HeroSpell;
    private boolean heroSpellAvailable;
    private int hpLostPerTurn;
    private int maxCardsOnBoard;

    public Player(HPReserve hpReserve, ManaReserve manaReserve, String image, Deck deck, Hand hand, ArrayList<Minion> board, Spell heroSpell, boolean heroSpellAvailable, int hpLostPerTurn, int maxCardsOnBoard) {
        this.hpReserve = hpReserve;
        this.manaReserve = manaReserve;
        this.image = image;
        this.deck = deck;
        this.hand = hand;
        this.board = board;
        HeroSpell = heroSpell;
        this.heroSpellAvailable = heroSpellAvailable;
        this.hpLostPerTurn = hpLostPerTurn;
        this.maxCardsOnBoard = maxCardsOnBoard;
    }

    public HPReserve getHpReserve() {
        return hpReserve;
    }

    public void setHpReserve(HPReserve hpReserve) {
        this.hpReserve = hpReserve;
    }

    public ManaReserve getManaReserve() {
        return manaReserve;
    }

    public void setManaReserve(ManaReserve manaReserve) {
        this.manaReserve = manaReserve;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Deck getDeck() {
        return deck;
    }

    public void setDeck(Deck deck) {
        this.deck = deck;
    }

    public Hand getHand() {
        return hand;
    }

    public void setHand(Hand hand) {
        this.hand = hand;
    }

    public ArrayList<Minion> getBoard() {
        return board;
    }

    public void setBoard(ArrayList<Minion> board) {
        this.board = board;
    }

    public Spell getHeroSpell() {
        return HeroSpell;
    }

    public void setHeroSpell(Spell heroSpell) {
        HeroSpell = heroSpell;
    }

    public boolean isHeroSpellAvailable() {
        return heroSpellAvailable;
    }

    public void setHeroSpellAvailable(boolean heroSpellAvailable) {
        this.heroSpellAvailable = heroSpellAvailable;
    }

    public int getHpLostPerTurn() {
        return hpLostPerTurn;
    }

    public void setHpLostPerTurn(int hpLostPerTurn) {
        this.hpLostPerTurn = hpLostPerTurn;
    }

    public int getMaxCardsOnBoard() {
        return maxCardsOnBoard;
    }

    public void setMaxCardsOnBoard(int maxCardsOnBoard) {
        this.maxCardsOnBoard = maxCardsOnBoard;
    }

    public void endCurrentTurn() {
        // TODO
    }

    public void triggerHPLossPerTurn() {
        // TODO
    }

    public void useHeroSpell() {
        // TODO
    }
}