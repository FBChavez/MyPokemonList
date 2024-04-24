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

public class UpdatePokemonController {
    @FXML
    private TableView<Pokemon> tableView;

    @FXML
    private TableColumn<Pokemon, Integer> idColumn;

    @FXML
    private TableColumn<Pokemon, String> nameColumn;

    @FXML
    private TableColumn<Pokemon, String> typeColumn;

    @FXML
    private TableColumn<Pokemon, String> descriptionColumn;

    @FXML
    public Button btnUpdate;

    @FXML
    public Button btnDelete;

    @FXML
    public Button btnBack;

    public void initialize() {
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        typeColumn.setCellValueFactory(new PropertyValueFactory<>("type"));
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("description"));

        populateTable();
    }

    private void populateTable() {
        List<Pokemon> pokemonList = ReadData.getAllPokemon();

        tableView.getItems().addAll(pokemonList);
    }

    @FXML
    void handleUpdatePokemon() {
        Pokemon selectedPokemon = tableView.getSelectionModel().getSelectedItem();

        if (selectedPokemon != null) {
            editSelectedPokemon(selectedPokemon);
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("No Pokemon Selected");
            alert.setHeaderText(null);
            alert.setContentText("Please select a Pokemon to update.");
            alert.showAndWait();
        }
    }

    @FXML
    void editSelectedPokemon(Pokemon selectedPokemon) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("update-selected-pokemon.fxml"));
            Parent root = fxmlLoader.load();

            UpdateSelectedPokemonController controller = fxmlLoader.getController();
            controller.initData(selectedPokemon);

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
    private void handleDeletePokemon() {
        Pokemon selectedPokemon = tableView.getSelectionModel().getSelectedItem();
        if (selectedPokemon != null) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation");
            alert.setHeaderText("Confirm Deletion");
            alert.setContentText("Are you sure you want to delete this Pokémon?");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.OK) {
                int pokemonId = selectedPokemon.getId();
                DeleteData.deletePokemon(pokemonId);
                tableView.getItems().remove(selectedPokemon);
            }
        } else {
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setTitle("Error");
            errorAlert.setHeaderText("No Pokémon Selected");
            errorAlert.setContentText("Please select a Pokémon to delete.");
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
