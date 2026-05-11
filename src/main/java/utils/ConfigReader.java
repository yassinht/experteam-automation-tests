package utils;

import java.util.Properties;

public class ConfigReader {

    public static String getProperty(String key) throws Exception {

        Properties properties = new Properties();

        properties.load(
            ConfigReader.class
                .getClassLoader()
                .getResourceAsStream("config.properties")
        );

        return properties.getProperty(key);
    }
}