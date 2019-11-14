package sample;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Iterator;

public class GameJsonParser {

    private String gameJsonFilePath;

    public GameJsonParser(String gameJsonFilePath) {
        this.gameJsonFilePath = gameJsonFilePath;
    }

    public ArrayList<Player> generateHeroesFromJson() {
        JSONParser parser = new JSONParser();

        try (Reader reader = ) {

            JSONObject jsonObject = (JSONObject) parser.parse(reader);
            System.out.println(jsonObject);

            String name = (String) jsonObject.get("name");
            System.out.println(name);

            long age = (Long) jsonObject.get("age");
            System.out.println(age);

            // loop array
            JSONArray msg = (JSONArray) jsonObject.get("messages");
            Iterator<String> iterator = msg.iterator();
            while (iterator.hasNext()) {
                System.out.println(iterator.next());
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return new ArrayList<Player>();
    }

    public ArrayList<Card> generateMinionsFromJson() {
        // TODO
        return new ArrayList<Card>();
    }

    public ArrayList<Card> generateSpellsFromJson() {
        // TODO
        return new ArrayList<Card>();
    }
}