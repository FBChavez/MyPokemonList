package com.example.mypokemonlist;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class AdminPageController {
    @FXML
    public Button btnAddPokemon;

    @FXML
    public Button btnUpdatePokemon;

    @FXML
    public Button btnBack;

    @FXML
    void handleAddPokemon() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("add-pokemon.fxml"));
            Parent root = fxmlLoader.load();

            Stage stage = new Stage();
            stage.setScene(new Scene(root));

            stage.show();

            Stage welcomeStage = (Stage) btnAddPokemon.getScene().getWindow();
            welcomeStage.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void handleUpdatePokemon() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("update-pokemon.fxml"));
            Parent root = fxmlLoader.load();

            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setResizable(false);

            stage.show();

            Stage welcomeStage = (Stage) btnUpdatePokemon.getScene().getWindow();
            welcomeStage.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void back() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("log-in.fxml"));
            Parent root = fxmlLoader.load();

            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setResizable(false);

            stage.show();

            Stage adminStage = (Stage) btnBack.getScene().getWindow();
            adminStage.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
