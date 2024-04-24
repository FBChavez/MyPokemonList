package com.example.mypokemonlist;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class UpdateSelectedUserController {
    @FXML
    private TextField tfUsername;

    @FXML
    private TextField tfPassword;

    @FXML
    private TextField tfFirstName;

    @FXML
    private TextField tfLastName;

    @FXML
    private TextField tfEmail;

    @FXML
    private Label lblNote;

    @FXML
    public Button btnUpdate;

    private User selectedUser;

    public void initData(User user) {
        selectedUser = user;
        tfUsername.setText(user.getUsername());
        tfPassword.setText(user.getPassword());
        tfFirstName.setText(user.getFirstName());
        tfLastName.setText(user.getLastName());
        tfEmail.setText(user.getEmail());
    }

    @FXML
    void updateUser() {
        if (selectedUser != null) {
            String username = tfUsername.getText();
            String password = tfPassword.getText();
            String firstName = tfFirstName.getText();
            String lastName = tfLastName.getText();
            String email = tfEmail.getText();


            if (!username.isEmpty() && !password.isEmpty() && !firstName.isEmpty() && !lastName.isEmpty() && !email.isEmpty()) {
                UpdateData.updateUser(selectedUser.getId(), username, password, firstName, lastName, email);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Success");
                alert.setHeaderText(null);
                alert.setContentText("User updated successfully!");
                alert.showAndWait();
            } else {
                lblNote.setText("Please fill all fields!");
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Please fill in all fields!");
                alert.showAndWait();
            }
        }
    }
}
