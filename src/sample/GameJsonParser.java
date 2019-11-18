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
                jsonList.forEach(h -> {
                    try {
                        parseHeroObject((JSONObject) h, list);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
            } else if (typeParameterClass.equals(Minion.class)) {
                JSONArray jsonList = (JSONArray) jo.get("minions");
                try {
                    jsonList.forEach(m -> parseMinionObject((JSONObject) m, list));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                JSONArray jsonList = (JSONArray) jo.get("spells");
                jsonList.forEach(s -> {
                    try {
                        parseSpellObject((JSONObject) s, list);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
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

    private void parseHeroObject(JSONObject hero, ArrayList<T> list) throws Exception {
        // Create an instance of the player
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

        // Set hero spell
        p.setHeroSpell(getSpecificSpellFromJson((JSONObject)hero.get("hero_spell")));

        // Add it to the list
        list.add((T) p);
    }

    private void parseMinionObject(JSONObject minion, ArrayList<T> list) {
        // Create an instance of the minion
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

    private void parseSpellObject(JSONObject spell, ArrayList<T> list) throws Exception {
        // Add it to the list
        list.add((T) getSpecificSpellFromJson(spell));
    }

    private Spell getSpecificSpellFromJson(JSONObject spell) throws Exception {
        Spell s;

        // Instanciate the right spell card
        Spell.SpellType st = Spell.SpellType.valueOf(spell.get("action").toString());
        switch (st) {
            case RANDOM_SPLITTED_DMG:
                s = new SpellArcanaMissile();
                break;

            case DRAW_CARDS:
                s = new SpellPickCard();
                break;

            case ADD_MANA_SLOT:
                s = new SpellAddManaMax();
                break;

            case HEAL:
                s = new SpellHeal();
                break;

            default:
                throw new Exception("Impossible to find a spell corresponding to JSON Action " + spell.get("action").toString());
        }

        // Set name
        s.setName(spell.get("name").toString());

        // Set description
        s.setDescription(spell.get("description").toString());

        // Set cost
        s.setCost(Integer.parseInt(spell.get("cost").toString()));

        // Set portrait
        s.setImage(spell.get("portrait").toString());

        // Set action param
        s.setActionParam(Integer.parseInt(spell.get("actionParam").toString()));

        return s;
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