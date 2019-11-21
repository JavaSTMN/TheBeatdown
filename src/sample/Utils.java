package sample;

import java.io.File;
import java.net.URL;

public class Utils {

    /**
     * Gets a file from the resources folder
     * @param fileName
     * @return
     */
    public static File getFileFromResources(String fileName) {
        ClassLoader classLoader = Utils.class.getClassLoader();

        URL resource = classLoader.getResource(fileName);
        if (resource == null) {
            throw new IllegalArgumentException("file is not found!");
        } else {
            return new File(resource.getFile());
        }
    }
}
