package com.example.mypokemonlist;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LogInController {
    @FXML
    private TextField tfUsername;

    @FXML
    private PasswordField pfPassword;

    @FXML
    private Button btnLogIn;

    @FXML
    private Button btnBack;

    @FXML
    private Label lblNote;

    @FXML
    void handleLogin() {
        String username = tfUsername.getText();
        String password = pfPassword.getText();

        User user = ReadData.getUserData(username, password);

        if(ReadData.readUserData(username, password)) {
            tfUsername.clear();
            pfPassword.clear();

            lblNote.setText("Login successful!");

            FXMLLoader fxmlLoader;
            Parent root = null;
            if (username.equals("francis") && password.equals("chavez")) {
                try {
                    fxmlLoader = new FXMLLoader(getClass().getResource("admin-page.fxml"));
                    root = fxmlLoader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                try {
                    fxmlLoader = new FXMLLoader(getClass().getResource("home-page.fxml"));
                    root = fxmlLoader.load();
                    HomePageController homeController = fxmlLoader.getController();
                    homeController.initData(user);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setResizable(false);

            stage.show();

            Stage loginStage = (Stage) btnLogIn.getScene().getWindow();
            loginStage.close();
        } else {
            lblNote.setText("Invalid username/password!");
        }
    }

    @FXML
    void back() {
        tfUsername.clear();
        pfPassword.clear();

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("welcome-screen.fxml"));
            Parent root = fxmlLoader.load();

            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setResizable(false);

            stage.show();

            Stage loginStage = (Stage) btnBack.getScene().getWindow();
            loginStage.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
