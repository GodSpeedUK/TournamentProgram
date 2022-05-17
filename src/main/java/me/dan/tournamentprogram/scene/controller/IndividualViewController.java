package me.dan.tournamentprogram.scene.controller;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import me.dan.tournamentprogram.TournamentProgram;
import me.dan.tournamentprogram.individual.Individual;

import java.util.HashMap;
import java.util.Map;

public class IndividualViewController {

    @FXML
    private Label pointView;
    @FXML
    private ComboBox<String> individualComboBox;

    private Map<Integer, Individual> integerIndividualMap;

    private static IndividualViewController instance;

    public IndividualViewController() {
        super();
        instance = this;
    }

    public void initialize() {
        this.integerIndividualMap = new HashMap<>();
        refreshList();
        individualComboBox.valueProperty().addListener(change -> {
            refresh();
        });

    }

    public void onMainMenuButtonClicked(MouseEvent mouseEvent) {
        Stage stage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
        TournamentProgram.getInstance().getSceneManager().showScene(stage, "main_menu_scene");
    }

    public void refresh() {
        Individual individual = integerIndividualMap.get(individualComboBox.getSelectionModel().getSelectedIndex());
        if (individual != null) {
            pointView.setText(individual.getScore() + "");
        }
    }

    public void refreshList() {
        pointView.setText("");
        individualComboBox.getItems().clear();
        integerIndividualMap.clear();
        int i = 0;
        for (Individual individual : TournamentProgram.getInstance().getIndividualManager().getAll()) {
            individualComboBox.getItems().add(i, individual.getName() + " (" + individual.getId() + ")");
            integerIndividualMap.put(i, individual);
            i++;
        }
    }

    public static IndividualViewController getInstance() {
        return instance;
    }
}
