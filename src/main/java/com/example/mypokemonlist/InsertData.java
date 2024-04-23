package com.example.mypokemonlist;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InsertData {
    public static void insertUserData(String username, String password, String firstname, String lastname, String email) {
        try (Connection c = MySQLConnection.getConnection();
             PreparedStatement statement = c.prepareStatement(
                     "INSERT INTO tblUser (username, password, firstname, lastname, email) VALUES (?,?,?,?,?)"
             )) {
            statement.setString(1, username);
            statement.setString(2, password);
            statement.setString(3, firstname);
            statement.setString(4, lastname);
            statement.setString(5, email);
            int rowsInserted = statement.executeUpdate();

            System.out.println("Rows Inserted in tblUser: " + rowsInserted);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void insertPokemonData(String name, String type, String description) {

        if (readPokemonData(name)) {
            System.out.println("Pokemon '" + name + "' already exists in the database.");
            return;
        }

        try (Connection c = MySQLConnection.getConnection();
             PreparedStatement statement = c.prepareStatement(
                     "INSERT INTO tblPokemon (name, type, description) VALUES (?,?,?)"
             )) {
            statement.setString(1, name);
            statement.setString(2, type);
            statement.setString(3, description);
            int rowsInserted = statement.executeUpdate();
            System.out.println("Rows Inserted in tblPokemon: " + rowsInserted);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static boolean readPokemonData(String name) {
        try (Connection c = MySQLConnection.getConnection();
             PreparedStatement statement = c.prepareStatement(
                     "SELECT * FROM tblPokemon WHERE name = ?"
             )) {
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();

            return resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
