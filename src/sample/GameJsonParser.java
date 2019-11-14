package sample;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class GameJsonParser {

    private String gameJsonFilePath;
    private File jsonFile;

    public GameJsonParser(String gameJsonFilePath) {
        this.gameJsonFilePath = gameJsonFilePath;
        jsonFile = getFileFromResources("game.json");
    }

    public ArrayList<Player> generateHeroesFromJson() {
        //JSON parser object to parse read file
        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader(jsonFile))
        {
            // Read JSON file
            Object obj = jsonParser.parse(reader);
            JSONObject jo = (JSONObject) obj;

            // Get heroes and iterate on them
            JSONArray heroesList = (JSONArray) jo.get("heroes");

            // Create the arraylist
            ArrayList<Player> list = new ArrayList<Player>();
            heroesList.forEach(hero -> parseHeroObject((JSONObject) hero, list));

            return list;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    private void parseHeroObject(JSONObject hero, ArrayList<Player> list) {
        // Create a Player instance the hero
        Player p = new Player();

        // Set name
        p.setName(hero.get("name").toString());

        // Set HP
        int initialHp = Integer.parseInt(hero.get("health").toString());
        p.setHpReserve(new HPReserve(initialHp, initialHp));

        // Set mana
        int initialMana = Integer.parseInt(hero.get("initialMana").toString());
        p.setManaReserve(new ManaReserve(initialMana, initialMana));

        // Set portrait
        p.setImage(hero.get("portrait").toString());

        // Init empty hand and set hand size
        p.setHand(new Hand());
        p.getHand().setInitialHandSize(Integer.parseInt(hero.get("initialHandSize").toString()));

        // TODO: Set hero spell

        // Add it to the list
        list.add(p);
    }

    public ArrayList<Card> generateMinionsFromJson() {
        // TODO
        return new ArrayList<Card>();
    }

    public ArrayList<Card> generateSpellsFromJson() {
        // TODO
        return new ArrayList<Card>();
    }

    /**
     * Gets a file from the resources folder
     * @param fileName
     * @return
     */
    private File getFileFromResources(String fileName) {
        ClassLoader classLoader = getClass().getClassLoader();

        URL resource = classLoader.getResource(fileName);
        if (resource == null) {
            throw new IllegalArgumentException("file is not found!");
        } else {
            return new File(resource.getFile());
        }
    }

}