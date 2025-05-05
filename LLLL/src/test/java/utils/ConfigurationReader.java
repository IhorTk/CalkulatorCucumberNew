package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {

    private ConfigurationReader() {
    }

    private static Properties properties;

    static {
        String path = "src/test/resources/config/configuration.properties";
        try {
            FileInputStream inputStream = new FileInputStream(path);
            properties = new Properties();
            properties.load(inputStream);

            inputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String get(String keyName){
        return properties.getProperty(keyName);
    }
}
