package com.example.mypokemonlist;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class AddPokemonController {
    @FXML
    private TextField tfPokemonName;

    @FXML
    private TextField tfType;

    @FXML
    private TextField tfDescription;

    @FXML
    public Button btnAdd;

    @FXML
    public Button btnBack;

    @FXML
    private Label lblNote;

    @FXML
    void handleAddPokemon() {
        String name = tfPokemonName.getText();
        String type = tfType.getText();
        String description = tfDescription.getText();

        System.out.println("Handling Adding Pokemon...");

        if (name.isEmpty() || type.isEmpty() || description.isEmpty()) {
            lblNote.setText("Please fill all fields!");
            return;
        }

        InsertData.insertPokemonData(name, type, description);

        System.out.println("Adding a Pokemon successful!");

        tfPokemonName.clear();
        tfType.clear();
        tfDescription.clear();

        lblNote.setText("Pokemon '"+ name + "' added to tblPokemon.");
    }

    @FXML
    void back() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("admin-page.fxml"));
            Parent root = fxmlLoader.load();

            Stage stage = new Stage();
            stage.setScene(new Scene(root));

            stage.show();

            Stage adminStage = (Stage) btnBack.getScene().getWindow();
            adminStage.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
