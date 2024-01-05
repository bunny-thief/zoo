package org.example;

import org.example.repository.AnimalRepository;
import org.example.userInterface.UserInterface;
import org.example.utilities.Utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.util.Properties;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Properties properties = Utilities.getProperties();
        Scanner scanner = new Scanner(System.in);

        String url = properties.getProperty("db.url");
        String username = properties.getProperty("db.username");
        String password = properties.getProperty("db.password");

        try (Connection conn = DriverManager.getConnection(
                url,
                username,
                password
        )) {
            AnimalRepository animalRepository = new AnimalRepository(conn);
            UserInterface ui = new UserInterface(scanner, animalRepository);
            ui.run();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}