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

public class SignUpController {
    @FXML
    private TextField tfFirstName;

    @FXML
    private TextField tfLastName;

    @FXML
    private TextField tfEmail;

    @FXML
    private TextField tfUsername;

    @FXML
    private PasswordField pfPassword;

    @FXML
    public Button btnRegister;

    @FXML
    public Button btnBack;

    @FXML
    private Label lblNote;

    @FXML
    void handleRegister() {
        String username = tfUsername.getText();
        String password = pfPassword.getText();
        String firstname = tfFirstName.getText();
        String lastname = tfLastName.getText();
        String email = tfEmail.getText();

        System.out.println("Handling Register...");

        if (username.isEmpty() || password.isEmpty() || firstname.isEmpty() || lastname.isEmpty() || email.isEmpty()) {
            lblNote.setText("Please fill all fields!");
            return;
        }

        InsertData.insertUserData(username, password, firstname, lastname, email);

        System.out.println("Sign Up successful!");

        tfUsername.clear();
        pfPassword.clear();
        tfFirstName.clear();
        tfLastName.clear();
        tfEmail.clear();

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("welcome-screen.fxml"));
            Parent root = fxmlLoader.load();

            Stage stage = new Stage();
            stage.setScene(new Scene(root));

            stage.show();

            Stage signupStage = (Stage) btnRegister.getScene().getWindow();
            signupStage.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void back() {
        tfUsername.clear();
        pfPassword.clear();
        tfFirstName.clear();
        tfLastName.clear();
        tfEmail.clear();

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("welcome-screen.fxml"));
            Parent root = fxmlLoader.load();

            Stage stage = new Stage();
            stage.setScene(new Scene(root));

            stage.show();

            Stage signupStage = (Stage) btnBack.getScene().getWindow();
            signupStage.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
