package tech.candy_dev.tournamentprogram.scene.controller;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import tech.candy_dev.tournamentprogram.TournamentProgram;

public class CreationSceneController {

    @FXML
    private TextField nameField;
    @FXML
    private ComboBox typeSelectionBox;

    @FXML
    public void initialize() {
        typeSelectionBox.getItems().add("Team");
        typeSelectionBox.getItems().add("Individual");
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
            case "Team":
                if (TournamentProgram.getInstance().getTeamManager().createTeam(nameField.getText(), null)) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Success");
                    alert.setContentText("Team Created!");
                    alert.show();
                    return;
                }
                error();
                return;
            case "Individual":
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
}
