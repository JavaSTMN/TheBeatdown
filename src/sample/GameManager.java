package sample;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;

public class GameManager {

    private static GameManager instance;
    private Player player1;
    private Player player2;
    private Player currentTurnPlayer;
    private float maxTurnDuration = 60;
    private int maxDeckSize = 20;
    private int maxHandSize = 8;

    public GameManager() throws Exception {
        if (this.instance == null) {
            this.instance = this;
        } else {
            throw new Exception("Cannot instantiate the game manager more than once.");
        }
    }

    public static GameManager getInstance() {
        return instance;
    }

    public Player getPlayer1() {
        return player1;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    public float getMaxTurnDuration() {
        return maxTurnDuration;
    }

    public void setMaxTurnDuration(float maxTurnDuration) {
        this.maxTurnDuration = maxTurnDuration;
    }

    public Player getCurrentTurnPlayer() {
        return currentTurnPlayer;
    }

    public void setCurrentTurnPlayer(Player currentTurnPlayer) {
        this.currentTurnPlayer = currentTurnPlayer;
    }

    /**
     * Inits a new game by initializing and assigning values for the players, cards, deck, hand, etc...
     */
    public void initGame() {
        try {
            initPlayersHeroes();
            initPlayersDecks();
            initPlayersHands();
            initPlayersBoards();
            setTurn(this.player1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Gets a list of heroes from the json file and assigns one randomly to both players.
     * @throws Exception
     */
    public void initPlayersHeroes() throws Exception {
        // get players from json
        ArrayList<Player> players = new GameJsonParser<Player>(Player.class).generateListFromJson();
        if (players.size() < 2) {
            throw new Exception("Cannot init a game with less than 2 available heroes");
        }
        Collections.shuffle(players);

        // assign players
        this.player1 = players.get(0);
        this.player2 = players.get(1);
    }

    /**
     * Gets the cards from the json file, makes a deck of 20 cards from them and assigns one to each player
     */
    public void initPlayersDecks() {
        // get cards from json
        ArrayList<Minion> minions = new GameJsonParser<Minion>(Minion.class).generateListFromJson();
        ArrayList<Spell> spells = new GameJsonParser<Spell>(Spell.class).generateListFromJson();

        // create a list of all the unique cards in the game
        ArrayList<Card> uniqueCards = new ArrayList<>();
        uniqueCards.addAll(minions);
        uniqueCards.addAll(spells);

        // create a deck of N cards from the unique ones that have been extracted from the json file
        ArrayDeque<Card> cards = new ArrayDeque<>();
        for (int i = 0; i < this.maxDeckSize; i++) {
            // add all the unique cards at least once
            if (i < uniqueCards.size()) {
                cards.push(uniqueCards.get(i));
            } else { // fill the rest with random picks from the unique cards list
                Card randomCard = uniqueCards.get((int)(Math.random() * uniqueCards.size()));
                cards.push(randomCard);
            }
        }

        // assign players decks (will be shuffled in the deck class constructor)
        this.player1.setDeck(new Deck(this.maxDeckSize, new ArrayDeque<>(cards)));
        this.player2.setDeck(new Deck(this.maxDeckSize, new ArrayDeque<>(cards)));
    }

    /**
     * Sets max hand size and draws x cards to make up the initial hand for both players
     */
    public void initPlayersHands() {
        // player1
        this.player1.getHand().setMaxHandSize(this.maxHandSize);
        this.player1.getHand().setCards(this.player1.getDeck().pickCardsFromDeck(this.player1.getHand().getInitialHandSize()));

        // player2
        this.player2.getHand().setMaxHandSize(this.maxHandSize);
        this.player2.getHand().setCards(this.player2.getDeck().pickCardsFromDeck(this.player1.getHand().getInitialHandSize()));
    }

    /**
     * Inits empty boards
     */
    public void initPlayersBoards() {
        this.player1.setBoard(new ArrayList<Minion>());
        this.player2.setBoard(new ArrayList<Minion>());
    }

    /**
     * triggers the set turn for the other player
     * @param p
     */
    public void endTurn(Player p) {
        if (p.equals(player1)) {
            setTurn(player2);
        } else if (p.equals(player2)) {
            setTurn(player1);
        }
    }

    public void setTurn(Player p) {
        // enable hero power
        p.setHeroSpellAvailable(true);

        ArrayList<Minion> board = p.getBoard();
        for (int i = 0; i < board.size(); i++) {
            board.get(i).setHasAlreadyAttack(false);
        }

        ManaReserve mp = p.getManaReserve();
        // add max mana cristal
        if (mp.getMaxMana() + 1 <= mp.getMaxManaSlots()) {
            mp.addManaMax(1);
        }

        // refill current mana
        GameManager.getInstance().getPlayer1().getManaReserve().refillMana();
        GameManager.getInstance().getPlayer2().getManaReserve().refillMana();

        // check current deck size
        if(p.getDeck().getCards().size() > 0) {
            // pick a card if room in hand
            ArrayList<Card> pickedCards = p.getDeck().pickCardsFromDeck(1);
            if (p.getHand().getCards().size() + 1 <= p.getHand().getMaxHandSize()) {
                p.getHand().addCards(pickedCards);
            }
        } else {
            // trigger hp loss
            p.triggerHPLossPerTurn();
        }

        // set current turn player
        this.currentTurnPlayer = p;

        // refresh graphics
        if (GameController.getInstance() != null) {
            GameController.getInstance().renderEverything();
            GameController.getInstance().enableHeroesSpells();
        }
    }
}