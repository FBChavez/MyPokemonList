package com.example.mypokemonlist;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteData {
    public static void deletePokemon(int id) {
        try (Connection c = MySQLConnection.getConnection();
             PreparedStatement statement = c.prepareStatement(
                     "DELETE FROM tblPokemon WHERE pokemon_id = ?"
             );
             PreparedStatement statementUserPokemon = c.prepareStatement(
                     "DELETE FROM tblUserPokemon WHERE pokemon_id = ?"
             )) {
            statement.setInt(1, id);
            statementUserPokemon.setInt(1, id);

            int rowsAffectedPokemon = statement.executeUpdate();

            int rowsAffectedUserPokemon = statementUserPokemon.executeUpdate();

            if (rowsAffectedPokemon > 0) {
                System.out.println("Successfully deleted pokemon_id: " + id + " from tblPokemon");
            } else {
                System.out.println("Pokemon with id " + id + " not found in tblPokemon.");
            }

            if (rowsAffectedUserPokemon > 0) {
                System.out.println("Successfully deleted pokemon_id: " + id + " from tblUserPokemon");
            } else {
                System.out.println("Pokemon with id " + id + " not found in tblUserPokemon.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteUserPokemon(int userId, int pokemonId) {
        try (Connection c = MySQLConnection.getConnection();
             Statement statement = c.createStatement()) {
            String query = "DELETE FROM tblUserPokemon WHERE user_id = " + userId + " AND pokemon_id = " + pokemonId;

            int rowsAffected = statement.executeUpdate(query);

            if (rowsAffected > 0) {
                System.out.println("Successfully deleted user_id (" + userId + ") and pokemon_id (" + pokemonId + ")" +
                        " from tblUserPokemon");
            } else {
                System.out.println("UserPokemon with deleted user_id (" + userId + ") and pokemon_id (" + pokemonId + ")" +
                        " not found in tblPokemon.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
