package com.example.mypokemonlist;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection {
    public static final String URL =
            "jdbc:mysql://localhost:3306/db_my_pokemon_list";
    public static final String USERNAME =
            "root";
    public static final String PASSWORD =
            "";

    static Connection getConnection() {
        Connection c = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("DB Connection success with USERNAME = " +
                    USERNAME + " and PASSWORD = " + PASSWORD);
        } catch (SQLException | ClassNotFoundException e) {
//            throw new RuntimeException(e);
            e.printStackTrace();
        }

        return c;
    }

    public static void main(String[] args) {
        Connection c = getConnection();
        try {
            c.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
