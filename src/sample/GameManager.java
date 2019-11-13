package sample;

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

    public void initGame() {
        // TODO
    }

    public void initPlayersHeroes() {
        // TODO
        // Init  MaxMana à 0 et MaxManaSlots à 8
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
        ManaReserve mana = p.getManaReserve();
        mana.addManaMax(1);
        mana.refillMana(mana.getMaxMana());
    }
}