package org.example.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Utilities {

    public static Properties getProperties() {
        String path = String.format("db.properties", System.getProperty("user.dir"));
        Properties properties = new Properties();

        try (InputStream is = new FileInputStream(new File(path))) {
            properties.load(is);
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }

        return properties;
    }

}
