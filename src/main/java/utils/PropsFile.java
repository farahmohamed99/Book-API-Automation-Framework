package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropsFile {
    private static InputStream inputStream;
    private static String value;

    public static String getPropValue(Enum key) {
        String propValue = key.toString();
        String configFileName = "config.properties";

        try {
            Properties prop = new Properties();

            inputStream = PropsFile.class.getClassLoader().getResourceAsStream(configFileName);
            prop.load(inputStream);
            value = prop.getProperty(propValue);

        } catch (Exception e) {
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
            }
        }
        return value;
    }

    public enum URLs {
        baseUrl
    }

    public enum Paths {
        extentReport,
        book1,
        book2,
        book3
    }

}