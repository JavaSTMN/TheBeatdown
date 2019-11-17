package sample;

import java.util.ArrayList;
import java.util.Collections;

public class GameManager {

    private GameManager instance;
    private GameJsonParser jsonParser;
    private Player player1;
    private Player player2;
    private float maxTurnDuration;

    public GameManager(GameManager instance, GameJsonParser jsonParser, Player player1, Player player2, float maxTurnDuration) {
        this.instance = instance;
        this.jsonParser = jsonParser;
        this.player1 = player1;
        this.player2 = player2;
        this.maxTurnDuration = maxTurnDuration;
    }

    public GameManager getInstance() {
        return instance;
    }

    public void setInstance(GameManager instance) {
        this.instance = instance;
    }

    public GameJsonParser getJsonParser() {
        return jsonParser;
    }

    public void setJsonParser(GameJsonParser jsonParser) {
        this.jsonParser = jsonParser;
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

    /**
     * Inits a new game by initializing and assigning values for the players, cards, deck, hand, etc...
     */
    public void initGame() {
        try {
            initPlayersHeroes();
        } catch (Exception e) {
            e.printStackTrace();
        }
        // TODO
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

    public void initPlayersDecks() {
        // TODO
    }

    public void initPlayersHands() {
        // TODO
    }

    public void endTurn(Player p) {
        // TODO
    }

    public void setTurn(Player p) {
        // TODO
    }
}