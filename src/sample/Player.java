package sample;

import java.util.ArrayList;

public class Player {

	private String name;
    private int currentHP;
    private int maxHP;
    private ManaReserve manaReserve;
    private String image;
    private Deck deck;
    private Hand hand;
    private ArrayList<Minion> board;
    private Spell heroSpell;
    private boolean heroSpellAvailable;
    private int hpLostPerTurn;
    private int maxCardsOnBoard;

    public Player() {
        this.setHeroSpellAvailable(true);
        this.setHpLostPerTurn(0);
        this.setMaxCardsOnBoard(8);
    }
    
    public Player(String name, int currentHP, int maxHP, ManaReserve manaReserve, String image, Deck deck, Hand hand, ArrayList<Minion> board, Spell heroSpell) {
        this.name = name;
        this.currentHP = currentHP;
        this.maxHP = maxHP;
        this.manaReserve = manaReserve;
        this.image = image;
        this.deck = deck;
        this.hand = hand;
        this.board = board;
        this.heroSpell = heroSpell;
        this.heroSpellAvailable = true;
        this.hpLostPerTurn = 0;
        this.maxCardsOnBoard = 8;
    }

    public int getCurrentHP() {
        return this.currentHP;
    }

    public void setCurrentHP(int currentHP) {
        this.currentHP = currentHP;
    }

    public int getMaxHP() {
        return this.maxHP;
    }

    public void setMaxHP(int maxHP) {
        this.maxHP = maxHP;
    }

    public ManaReserve getManaReserve() {
        return this.manaReserve;
    }

    public void setManaReserve(ManaReserve manaReserve) {
        this.manaReserve = manaReserve;
    }

    public String getImage() {
        return this.image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Deck getDeck() {
        return this.deck;
    }

    public void setDeck(Deck deck) {
        this.deck = deck;
    }

    public Hand getHand() {
        return this.hand;
    }

    public void setHand(Hand hand) {
        this.hand = hand;
    }

    public ArrayList<Minion> getBoard() {
        return this.board;
    }

    public void setBoard(ArrayList<Minion> board) {
        this.board = board;
    }

    public Spell getHeroSpell() {
        return this.heroSpell;
    }

    public void setHeroSpell(Spell heroSpell) {
        this.heroSpell = heroSpell;
    }

    public boolean isHeroSpellAvailable() {
        return this.heroSpellAvailable;
    }

    public void setHeroSpellAvailable(boolean heroSpellAvailable) {
        this.heroSpellAvailable = heroSpellAvailable;
    }

    public int getHpLostPerTurn() {
        return this.hpLostPerTurn;
    }

    public void setHpLostPerTurn(int hpLostPerTurn) {
        this.hpLostPerTurn = hpLostPerTurn;
    }

    public int getMaxCardsOnBoard() {
        return this.maxCardsOnBoard;
    }

    public void setMaxCardsOnBoard(int maxCardsOnBoard) {
        this.maxCardsOnBoard = maxCardsOnBoard;
    }

    public void recoverHP(int amount) {
        int current = getCurrentHP();
        int max = getMaxHP();
        if (current + amount >= max) {
            this.setCurrentHP(max);
        } else {
            this.setCurrentHP(current + amount);
        }
    }

    public void loseHP(int amount) {
        int current = getCurrentHP();
        if (current - amount < 0) {
            this.setCurrentHP(0);
        } else {
            this.setCurrentHP(current - amount);
        }
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

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void die() {
        System.out.println("Le joueur est mort");
    }
}