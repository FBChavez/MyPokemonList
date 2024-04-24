package com.example.mypokemonlist;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ReadData {
    public static User getUserData(String username, String password) {
        try (Connection c = MySQLConnection.getConnection();
             Statement statement = c.createStatement();) {
            String query = "SELECT * FROM tblUser WHERE username = '" + username + "' AND password = '" + password + "'";
            ResultSet res = statement.executeQuery(query);

            if (res.next()) {
                int id = res.getInt("user_id");
                String firstName = res.getString("firstname");
                String lastName = res.getString("lastname");
                String email = res.getString("email");

                System.out.println("Successful getUserData!");
                return new User(id, username, password, firstName, lastName, email);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static Boolean readUserData(String username, String password) {
        try (Connection c = MySQLConnection.getConnection();
             Statement statement = c.createStatement();) {
            String query = "SELECT * FROM tblUser";
            ResultSet res = statement.executeQuery(query);

            while (res.next()) {
                String uname = res.getString("username");
                String pword = res.getString("password");
                if(uname.equals(username) && pword.equals(password)) {
                    System.out.println("Successful readUserData!");
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static List<Pokemon> getUserPokemons(int userId) {
        List<Pokemon> userPokemons = new ArrayList<>();
        try (Connection c = MySQLConnection.getConnection();
             Statement statement = c.createStatement()) {
            String query = "SELECT p.* FROM tblUserPokemon up " +
                    "JOIN tblPokemon p ON up.pokemon_id = p.pokemon_id " +
                    "WHERE up.user_id = " + userId;
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int id = resultSet.getInt("pokemon_id");
                String name = resultSet.getString("name");
                String type = resultSet.getString("type");
                String description = resultSet.getString("description");
                Pokemon pokemon = new Pokemon(id, name, type, description);
                userPokemons.add(pokemon);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userPokemons;
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

    public static List<User> getAllUser() {
        List<User> userList = new ArrayList<>();

        try (Connection c = MySQLConnection.getConnection();
             Statement statement = c.createStatement()) {
            String query = "SELECT * FROM tblUser";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                int id = resultSet.getInt("user_id");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                String firstname = resultSet.getString("firstname");
                String lastname = resultSet.getString("lastname");
                String email = resultSet.getString("email");

                User user = new User(id, username, password, firstname, lastname, email);
                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return userList;
    }
}
