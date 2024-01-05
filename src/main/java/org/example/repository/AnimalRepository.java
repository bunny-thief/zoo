package org.example.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AnimalRepository {

    private static Connection connection;

    public AnimalRepository(Connection connection) {
        this.connection = connection;
    }

    public int addAnimal(String name, String species) {
        String query = "INSERT INTO animals (name, species) VALUES(?, ?)";

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

    public int deleteAnimal(String name) {
        String query = "DELETE FROM animals WHERE name = ?";

        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, name);
            return ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.printf("%s was not deleted from database", name);
        }

        return 0;
    }

    public void displayAnimals() {
        String query = "SELECT * FROM animals";

        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String species = rs.getString("species");
                System.out.printf("%-3d | %-10s | %-10s\n", id, name, species);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to display animals");
        }
    }

}
