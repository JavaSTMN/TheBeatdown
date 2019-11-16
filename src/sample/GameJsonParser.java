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

public class GameJsonParser<T> {
    private File jsonFile;
    final Class<T> typeParameterClass;

    public GameJsonParser(Class<T> typeParameterClass) {
        jsonFile = getFileFromResources("game.json");
        this.typeParameterClass = typeParameterClass;
    }

    public ArrayList<T> generateListFromJson() {
        //JSON parser object to parse read file
        JSONParser jsonParser = new JSONParser();
        try (FileReader reader = new FileReader(jsonFile))
        {
            // Read JSON file
            Object obj = jsonParser.parse(reader);
            JSONObject jo = (JSONObject) obj;

            ArrayList<T> list = new ArrayList<T>();

            // Get entries from json file and iterate on them
            if (typeParameterClass.equals(Player.class)) {
                JSONArray jsonList = (JSONArray) jo.get("heroes");
                jsonList.forEach(h -> parseHeroObject((JSONObject) h, list));
            } else if (typeParameterClass.equals(Minion.class)) {
                JSONArray jsonList = (JSONArray) jo.get("minions");
                jsonList.forEach(m -> parseMinionObject((JSONObject) m, list));
            } else {
                JSONArray jsonList = (JSONArray) jo.get("spells");
                jsonList.forEach(s -> parseHeroObject((JSONObject) s, list));
            }

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

    private void parseHeroObject(JSONObject hero, ArrayList<T> list) {
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
        list.add((T) p);
    }

    private void parseMinionObject(JSONObject minion, ArrayList<T> list) {
        // Create a Player instance the minion
        Minion m = new Minion();

        // Set name
        m.setName(minion.get("name").toString());

        // Set HP
        int initialHp = Integer.parseInt(minion.get("health").toString());
        m.setHpReserve(new HPReserve(initialHp, initialHp));

        // Set cost
        m.setCost(Integer.parseInt(minion.get("cost").toString()));

        // Set portrait
        m.setImage(minion.get("portrait").toString());

        // Set dmg
        m.setDmg(Integer.parseInt(minion.get("attack").toString()));

        // Add it to the list
        list.add((T) m);
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