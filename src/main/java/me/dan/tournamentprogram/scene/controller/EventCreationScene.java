package me.dan.tournamentprogram.scene.controller;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import me.dan.tournamentprogram.TournamentProgram;
import me.dan.tournamentprogram.individual.Individual;
import me.dan.tournamentprogram.member.Member;
import me.dan.tournamentprogram.team.Team;

import java.util.HashMap;
import java.util.Map;

public class EventCreationScene {

    @FXML
    private ComboBox<String> creationTypeSelect;

    @FXML
    private ComboBox<String> memberSelection;

    @FXML
    private ComboBox<String> pointSelection;

    private Map<Integer, Member> memberMap;

    public void initialize() {
        memberMap = new HashMap<>();
        pointSelection.getItems().add("0");
        pointSelection.getItems().add("1");
        pointSelection.getItems().add("2");
        pointSelection.getItems().add("3");
        this.creationTypeSelect.getItems().add("Team");
        this.creationTypeSelect.getItems().add("Individual");
        this.creationTypeSelect.valueProperty().addListener(observable -> {
            memberSelection.getItems().clear();
            memberMap.clear();
            int i = 0;
            switch (creationTypeSelect.getSelectionModel().getSelectedItem()) {
                case "Team":
                    for (Team team : TournamentProgram.getInstance().getTeamManager().getAll()) {
                        memberMap.put(i, team);
                        memberSelection.getItems().add(i, team.getName() + " (" + team.getId() + ")");
                        i++;
                    }
                    break;
                case "Individual":
                    for (Individual team : TournamentProgram.getInstance().getIndividualManager().getAll()) {
                        memberMap.put(i, team);
                        memberSelection.getItems().add(i, team.getName() + " (" + team.getId() + ")");
                        i++;
                    }
                    break;
                default:
                    break;
            }
        });
    }

    public void onMainMenuButtonClicked(MouseEvent mouseEvent) {
        Stage stage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
        TournamentProgram.getInstance().getSceneManager().showScene(stage, "main_menu_scene");
    }

}
