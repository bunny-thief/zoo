package org.example.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AnimalRepository {

    private static Connection connection;

    public AnimalRepository(Connection connection) {
        this.connection = connection;
    }

}
