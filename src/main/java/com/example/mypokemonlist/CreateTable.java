package com.example.mypokemonlist;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTable {
    public static void createTables() {
        Connection c = MySQLConnection.getConnection();
        String query1 = "CREATE TABLE IF NOT EXISTS tblUser (" +
                "user_id INT PRIMARY KEY AUTO_INCREMENT," +
                "username VARCHAR(50) NOT NULL," +
                "password VARCHAR(50) NOT NULL," +
                "firstname VARCHAR(50) NOT NULL," +
                "lastname VARCHAR(50) NOT NULL," +
                "email VARCHAR(100) NOT NULL)";

        String query2 = "CREATE TABLE IF NOT EXISTS tblPokemon (" +
                "pokemon_id INT PRIMARY KEY AUTO_INCREMENT," +
                "name VARCHAR(50) NOT NULL," +
                "type VARCHAR(50) NOT NULL," +
                "description VARCHAR(100) NOT NULL)";

        String query3 = "CREATE TABLE IF NOT EXISTS tblUserPokemon (" +
                "user_pokemon_id INT PRIMARY KEY AUTO_INCREMENT," +
                "user_id INT NOT NULL," +
                "pokemon_id INT NOT NULL," +
                "FOREIGN KEY (user_id) REFERENCES tblUser(user_id)," +
                "FOREIGN KEY (pokemon_id) REFERENCES tblPokemon(pokemon_id))";

        try {
            Statement statement = c.createStatement();
            statement.execute(query1);
            statement.execute(query2);
            statement.execute(query3);
            System.out.println("Tables created successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                c.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
