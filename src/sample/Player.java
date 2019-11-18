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
    private Spell HeroSpell;
    private boolean heroSpellAvailable = true;
    private int hpLostPerTurn = 0;
    private int maxCardsOnBoard = 8;

    public Player() {
    }
    
    public Player(String name, int currentHP,int maxHP, ManaReserve manaReserve, String image, Deck deck, Hand hand, ArrayList<Minion> board, Spell heroSpell, boolean heroSpellAvailable, int hpLostPerTurn, int maxCardsOnBoard) {
        this.name = name;
        this.currentHP = currentHP;
        this.maxHP = maxHP;
        this.manaReserve = manaReserve;
        this.image = image;
        this.deck = deck;
        this.hand = hand;
        this.board = board;
        this.HeroSpell = heroSpell;
        this.heroSpellAvailable = heroSpellAvailable;
        this.hpLostPerTurn = hpLostPerTurn;
        this.maxCardsOnBoard = maxCardsOnBoard;
    }

    public int getCurrentHP() {
        return currentHP;
    }

    public void setCurrentHP(int currentHP) {
        this.currentHP = currentHP;
    }

    public int getMaxHP() {
        return maxHP;
    }

    public void setMaxHP(int maxHP) {
        this.maxHP = maxHP;
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

    public void recoverHP(int amount) {
        int current=getCurrentHP();
        int max=getMaxHP();
        if(current+amount>=max)
        {
            setCurrentHP(max);
        }
        else
        {
            setCurrentHP(current+amount);
        }
    }

    public void loseHP(int amount) {
        int current = getCurrentHP();
        if(current-amount<0)
        {
            setCurrentHP(0);
        }
        else {
            setCurrentHP(current-amount);
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
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}