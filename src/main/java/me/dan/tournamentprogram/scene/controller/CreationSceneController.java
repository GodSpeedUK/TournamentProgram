package me.dan.tournamentprogram.scene.controller;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import me.dan.tournamentprogram.TournamentProgram;

import java.util.List;

public class CreationSceneController {

    @FXML
    private TextField teamMateField;

    @FXML
    private Button addButton;

    @FXML
    private ListView<String> memberList;

    @FXML
    private TextField nameField;

    @FXML
    private ComboBox<String> typeSelectionBox;

    @FXML
    public void initialize() {
        typeSelectionBox.getItems().add("Team");
        typeSelectionBox.getItems().add("Individual");
        typeSelectionBox.valueProperty().addListener(event -> {
            switch (typeSelectionBox.getSelectionModel().getSelectedItem()) {
                case "Team" -> {
                    teamMateField.setVisible(true);
                    addButton.setVisible(true);
                    memberList.setVisible(true);
                }
                case "Individual" -> {
                    teamMateField.setVisible(false);
                    addButton.setVisible(false);
                    memberList.setVisible(false);
                }
            }
        });
    }


    public void onCreateButtonClicked(MouseEvent mouseEvent) {
        if (nameField.getText().equalsIgnoreCase("") || nameField.getText() == null) {
            return;
        }

        if (typeSelectionBox.getSelectionModel().getSelectedItem() == null) {
            return;
        }

        String selection = (String) typeSelectionBox.getSelectionModel().getSelectedItem();

        switch (selection) {
            case "Team" -> {
                List<String> members = memberList.getItems();
                if (TournamentProgram.getInstance().getTeamManager().createTeam(nameField.getText(), members)) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Success");
                    alert.setContentText("Team Created!");
                    alert.show();
                    return;
                }
                error();
            }
            case "Individual" -> {
                if (TournamentProgram.getInstance().getIndividualManager().createIndividual(nameField.getText())) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Success");
                    alert.setContentText("Individual Created!");
                    alert.show();
                    return;
                }
                error();
            }
        }

    }

    private void error() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Creation Failed");
        alert.setContentText("Could not create team or individual");
        alert.show();
    }

    public void onMainMenuButtonClicked(MouseEvent mouseEvent) {
        Stage stage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
        TournamentProgram.getInstance().getSceneManager().showScene(stage, "main_menu_scene");
    }

    public void onAddButtonClick(MouseEvent mouseEvent) {
        if (!addButton.isVisible()) {
            return;
        }

        if (teamMateField.getText().equalsIgnoreCase("")) {
            return;
        }

        String name = teamMateField.getText();
        if (memberList.getItems().contains(name)) {
            return;
        }

        memberList.getItems().add(name);
        teamMateField.clear();

    }

}
