package com.example.mypokemonlist;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class HomePageController {
    @FXML
    private Label lblHello;

    @FXML
    private ComboBox<Pokemon> cbPokemon;

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
    private Button btnAdd;

    @FXML
    private Button btnRemove;

    @FXML
    private Button btnBack;

//    private User user;
//
//    public void initData(User user) {
//        this.user = user;
//        lblHello.setText("Hello Pokemon Trainer " + user.getFirstName() + ".");
//        loadComboBox();
//        loadTableView();
//    }
//
//    private void loadComboBox() {
//        List<Pokemon> allPokemons = ReadData.getAllPokemon();
//        ObservableList<Pokemon> pokemonList = FXCollections.observableArrayList(allPokemons);
//        cbPokemon.setItems(pokemonList);
//    }
//
//    private void loadTableView() {
//        List<Pokemon> userPokemons = ReadData.getUserPokemons(user.getId());
//        ObservableList<Pokemon> pokemonList = FXCollections.observableArrayList(userPokemons);
//
//        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
//        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
//        typeColumn.setCellValueFactory(new PropertyValueFactory<>("type"));
//        descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("description"));
//
//        tableView.setItems(pokemonList);
//    }
//
//    @FXML
//    void handleAddPokemon() {
//        Pokemon selectedPokemon = cbPokemon.getValue();
//        if (selectedPokemon != null) {
//            AddData.addUserPokemon(user.getId(), selectedPokemon.getId());
//            loadTableView(); // Reload the table after adding a new Pokemon
//        }
//    }
//
//    @FXML
//    void handleRemovePokemon() {
//        Pokemon selectedPokemon = tableView.getSelectionModel().getSelectedItem();
//        if (selectedPokemon != null) {
//            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
//            alert.setTitle("Confirmation");
//            alert.setHeaderText("Confirm Removal");
//            alert.setContentText("Are you sure you want to remove this Pokémon?");
//
//            Optional<ButtonType> result = alert.showAndWait();
//            if (result.isPresent() && result.get() == ButtonType.OK) {
//                RemoveData.removeUserPokemon(user.getId(), selectedPokemon.getId());
//                loadTableView(); // Reload the table after removing a Pokemon
//            }
//        }
//    }

    @FXML
    void back() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("log-in.fxml"));
            Parent root = fxmlLoader.load();

            Stage stage = new Stage();
            stage.setScene(new Scene(root));

            stage.show();

            Stage loginStage = (Stage) btnBack.getScene().getWindow();
            loginStage.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
