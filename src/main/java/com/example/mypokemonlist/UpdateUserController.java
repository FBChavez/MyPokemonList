package com.example.mypokemonlist;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class UpdateUserController {
    @FXML
    private TableView<User> tableView;

    @FXML
    private TableColumn<User, Integer> idColumn;

    @FXML
    private TableColumn<User, String> usernameColumn;

    @FXML
    private TableColumn<User, String> passwordColumn;

    @FXML
    private TableColumn<User, String> firstnameColumn;

    @FXML
    private TableColumn<User, String> lastnameColumn;

    @FXML
    private TableColumn<User, String> emailColumn;

    @FXML
    public Button btnUpdate;

    @FXML
    public Button btnDelete;

    @FXML
    public Button btnBack;

    public void initialize() {
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        usernameColumn.setCellValueFactory(new PropertyValueFactory<>("username"));
        passwordColumn.setCellValueFactory(new PropertyValueFactory<>("password"));
        firstnameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        lastnameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));

        populateTable();
    }

    private void populateTable() {
        List<User> userList = ReadData.getAllUser();

        tableView.getItems().addAll(userList);
    }

    @FXML
    void handleUpdateUser() {
        User selectedUser = tableView.getSelectionModel().getSelectedItem();

        if (selectedUser != null) {
            editSelectedUser(selectedUser);
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("No User Selected");
            alert.setHeaderText(null);
            alert.setContentText("Please select a User to update.");
            alert.showAndWait();
        }
    }

    @FXML
    void editSelectedUser(User selectedUser) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("update-selected-user.fxml"));
            Parent root = fxmlLoader.load();

            UpdateSelectedUserController controller = fxmlLoader.getController();
            controller.initData(selectedUser);

            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setResizable(false);
            stage.showAndWait(); // Show the update-selected-pokemon.fxml as a modal window

            tableView.getItems().clear();
            populateTable();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @FXML
    private void handleDeleteUser() {
        User selectedUser = tableView.getSelectionModel().getSelectedItem();
        if (selectedUser != null) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation");
            alert.setHeaderText("Confirm Deletion");
            alert.setContentText("Are you sure you want to delete this User?");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.OK) {
                int userId = selectedUser.getId();
                DeleteData.deleteUser(userId);
                tableView.getItems().remove(selectedUser);
            }
        } else {
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setTitle("Error");
            errorAlert.setHeaderText("No User Selected");
            errorAlert.setContentText("Please select a User to delete.");
            errorAlert.showAndWait();
        }
    }

    @FXML
    void back() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("admin-page.fxml"));
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
