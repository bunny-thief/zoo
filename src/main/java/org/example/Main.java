package org.example;

import org.example.utilities.Utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Main {
    public static void main(String[] args) {
        Properties properties = Utilities.getProperties();

        String url = properties.getProperty("db.url");
        String username = properties.getProperty("db.username");
        String password = properties.getProperty("db.password");

        try (Connection conn = DriverManager.getConnection(
                url,
                username,
                password
        )) {
            var meta = conn.getMetaData();
            System.out.println(meta.getURL());
            System.out.println(meta.getUserName());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}