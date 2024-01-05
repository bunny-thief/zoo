package org.example.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AnimalRepository {

    private static Connection connection;

    public AnimalRepository(Connection connection) {
        this.connection = connection;
    }

    public int addAnimal(String name, String species) {
        String query = "INSERT INTO animals VALUES(?, ?)";

        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, name);
            ps.setString(2, species);
            return ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println(String.format("%s was not added to database", name));
        }

        return 0;
    }

}
