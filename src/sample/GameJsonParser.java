package sample;

import java.util.ArrayList;

public class GameJsonParser {

    private String heroesFilePath;
    private String cardsFilePath;

    public GameJsonParser(String heroesFilePath, String cardsFilePath) {
        this.heroesFilePath = heroesFilePath;
        this.cardsFilePath = cardsFilePath;
    }

    public String getHeroesFilePath() {
        return heroesFilePath;
    }

    public void setHeroesFilePath(String heroesFilePath) {
        this.heroesFilePath = heroesFilePath;
    }

    public String getCardsFilePath() {
        return cardsFilePath;
    }

    public void setCardsFilePath(String cardsFilePath) {
        this.cardsFilePath = cardsFilePath;
    }

    public ArrayList<Player> generateHeroesFromJson() {
        // TODO
    }

    public ArrayList<Card> generateCardsFromJson() {
        // TODO
    }
}