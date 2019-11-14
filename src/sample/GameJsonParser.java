package sample;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

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
            System.out.println("ok");
            return new ArrayList<Player>();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
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