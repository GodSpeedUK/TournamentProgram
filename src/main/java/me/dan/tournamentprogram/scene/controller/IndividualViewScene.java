package me.dan.tournamentprogram.scene.controller;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import me.dan.tournamentprogram.TournamentProgram;
import me.dan.tournamentprogram.individual.Individual;
import me.dan.tournamentprogram.member.Member;

import java.util.HashMap;
import java.util.Map;

public class IndividualViewScene {

    @FXML
    private Label pointView;
    @FXML
    private ComboBox<String> individualComboBox;

    private Map<Integer, Individual> integerIndividualMap;

    public void initialize() {
        this.integerIndividualMap = new HashMap<>();
        int i = 0;
        for (Individual individual : TournamentProgram.getInstance().getIndividualManager().getAll()) {
            individualComboBox.getItems().add(i, individual.getName() + " (" + individual.getId() + ")");
            integerIndividualMap.put(i, individual);
            i++;
        }
        individualComboBox.valueProperty().addListener(change -> {
            Individual individual = integerIndividualMap.get(individualComboBox.getSelectionModel().getSelectedIndex());
            pointView.setText(individual.getScore() + "");
        });

    }

    public void onMainMenuButtonClicked(MouseEvent mouseEvent) {
        Stage stage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
        TournamentProgram.getInstance().getSceneManager().showScene(stage, "main_menu_scene");
    }

}
