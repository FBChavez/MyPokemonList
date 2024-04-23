package com.example.mypokemonlist;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ReadData {
    public static Boolean readUserData(String username, String password) {
        try (Connection c = MySQLConnection.getConnection();
             Statement statement = c.createStatement();) {
            String query = "SELECT * FROM tblUser";
            ResultSet res = statement.executeQuery(query);

            while (res.next()) {
                String uname = res.getString("username");
                String pword = res.getString("password");
                if(uname.equals(username) && pword.equals(password)) {
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static Boolean readPokemonData(String name) {
        try (Connection c = MySQLConnection.getConnection();
             Statement statement = c.createStatement();) {
            String query = "SELECT * FROM tblPokemon";
            ResultSet res = statement.executeQuery(query);

            while (res.next()) {
                String pname = res.getString("name");
                if(pname.equals(name)) {
                    return true;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static List<Pokemon> getAllPokemon() {
        List<Pokemon> pokemonList = new ArrayList<>();

        try (Connection c = MySQLConnection.getConnection();
             Statement statement = c.createStatement()) {
            String query = "SELECT * FROM tblPokemon";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                int id = resultSet.getInt("pokemon_id");
                String name = resultSet.getString("name");
                String type = resultSet.getString("type");
                String description = resultSet.getString("description");

                Pokemon pokemon = new Pokemon(id, name, type, description);
                pokemonList.add(pokemon);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return pokemonList;
    }
}
