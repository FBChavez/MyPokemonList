package com.example.mypokemonlist;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class WelcomeScreenController {
    @FXML
    private Button btnLogIn;

    @FXML
    private Button btnSignUp;

    @FXML
    void handleSignUpButton() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("sign-up.fxml"));
            Parent root = fxmlLoader.load();

            Stage stage = new Stage();
            stage.setScene(new Scene(root));

            stage.show();

            Stage welcomeStage = (Stage) btnSignUp.getScene().getWindow();
            welcomeStage.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void handleLogInButton() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("log-in.fxml"));
            Parent root = fxmlLoader.load();

            Stage stage = new Stage();
            stage.setScene(new Scene(root));

            stage.show();

            Stage welcomeStage = (Stage) btnLogIn.getScene().getWindow();
            welcomeStage.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}