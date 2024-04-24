package com.example.mypokemonlist;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MyPokemonListApplication extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws IOException {
        CreateTable.createTables();

        FXMLLoader fxmlLoader = new FXMLLoader(MyPokemonListApplication.class.getResource("welcome-screen.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("MyPokemonList");

        stage.setScene(scene);
        stage.setResizable(false);

        stage.show();
    }
}