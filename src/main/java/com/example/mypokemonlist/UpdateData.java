package com.example.mypokemonlist;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateData {
    public static void updatePokemon(int pokemonId, String name, String type, String description) {
        try (Connection c = MySQLConnection.getConnection();
             PreparedStatement statement = c.prepareStatement(
                     "UPDATE tblPokemon SET name = ?, type = ?, description = ? WHERE pokemon_id = ?"
             )) {
            statement.setString(1, name);
            statement.setString(2, type);
            statement.setString(3, description);
            statement.setInt(4, pokemonId);

            statement.executeUpdate();

            System.out.println("Successfully updated pokemon_id: " + pokemonId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
