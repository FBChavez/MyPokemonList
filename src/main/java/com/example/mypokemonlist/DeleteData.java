package com.example.mypokemonlist;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
}
