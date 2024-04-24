package com.example.mypokemonlist;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateData {
    public static void updateUser(int userId, String username, String password, String firstName, String lastName, String email) {
        try (Connection c = MySQLConnection.getConnection();
             PreparedStatement statement = c.prepareStatement(
                     "UPDATE tblUser SET username = ?, password = ?, firstname = ?, lastname = ?" +
                             ", email = ? WHERE user_id = ?"
             )) {
            c.setAutoCommit(false);

            statement.setString(1, username);
            statement.setString(2, password);
            statement.setString(3, firstName);
            statement.setString(4, lastName);
            statement.setString(5, email);
            statement.setInt(6, userId);

            statement.executeUpdate();
            System.out.println("Successfully updated user_id: " + userId);

            c.commit();
        } catch (SQLException e) {
            e.printStackTrace();

            try (Connection c = MySQLConnection.getConnection()) {
                c.rollback();
            } catch (SQLException rollbackException) {
                rollbackException.printStackTrace();
            }
        }
    }

    public static void updatePokemon(int pokemonId, String name, String type, String description) {
        try (Connection c = MySQLConnection.getConnection();
             PreparedStatement statement = c.prepareStatement(
                     "UPDATE tblPokemon SET name = ?, type = ?, description = ? WHERE pokemon_id = ?"
             )) {
            c.setAutoCommit(false);

            statement.setString(1, name);
            statement.setString(2, type);
            statement.setString(3, description);
            statement.setInt(4, pokemonId);

            statement.executeUpdate();
            System.out.println("Successfully updated pokemon_id: " + pokemonId);

            c.commit();
        } catch (SQLException e) {
            e.printStackTrace();

            try (Connection c = MySQLConnection.getConnection()) {
                c.rollback();
            } catch (SQLException rollbackException) {
                rollbackException.printStackTrace();
            }
        }
    }
}
