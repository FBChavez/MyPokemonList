package com.example.mypokemonlist;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class UpdateSelectedPokemonController {
    @FXML
    private TextField tfName;

    @FXML
    private TextField tfType;

    @FXML
    private TextField tfDescription;

    @FXML
    private Label lblNote;

    @FXML
    public Button btnUpdate;

    private Pokemon selectedPokemon;

    public void initData(Pokemon pokemon) {
        selectedPokemon = pokemon;
        tfName.setText(pokemon.getName());
        tfType.setText(pokemon.getType());
        tfDescription.setText(pokemon.getDescription());
    }

    @FXML
    void updatePokemon() {
        if (selectedPokemon != null) {
            String name = tfName.getText();
            String type = tfType.getText();
            String description = tfDescription.getText();
            if (!name.isEmpty() && !type.isEmpty() && !description.isEmpty()) {
                UpdateData.updatePokemon(selectedPokemon.getId(), name, type, description);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Success");
                alert.setHeaderText(null);
                alert.setContentText("Pokemon updated successfully!");
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
