package me.dan.tournamentprogram.scene.controller;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import me.dan.tournamentprogram.TournamentProgram;
import me.dan.tournamentprogram.team.Team;

import java.util.HashMap;
import java.util.Map;

public class TeamViewController {

    @FXML
    private Label pointsLabel;

    @FXML
    private ComboBox<String> teamComboBox;

    @FXML
    private ListView<String> teamMateList;

    private Map<Integer, Team> teamMap;

    private static TeamViewController instance;

    public TeamViewController() {
        teamMap = new HashMap<>();
        instance = this;
    }

    public void initialize() {
        refreshTeamList();
        teamComboBox.valueProperty().addListener(event -> {
            Team team = teamMap.get(teamComboBox.getSelectionModel().getSelectedIndex());
            setTeam(team);
        });
    }

    public static TeamViewController getInstance() {
        return instance;
    }

    public void refreshTeamList() {
        teamMap.clear();
        teamComboBox.getItems().clear();
        teamMateList.getItems().clear();
        pointsLabel.setText("");
        int i = 0;
        for (Team team : TournamentProgram.getInstance().getTeamManager().getAll()) {
            String label = team.getName() + " (" + team.getId() + ")";
            teamMap.put(i, team);
            teamComboBox.getItems().add(i, label);
            i++;
        }
    }

    public void setTeam(Team team) {
        for (String teamMate : team.getMembers()) {
            teamMateList.getItems().add(teamMate);
        }

        pointsLabel.setText(team.getScore() + "");
    }

    public void onMainMenuButtonClicked(MouseEvent mouseEvent) {
        Stage stage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
        TournamentProgram.getInstance().getSceneManager().showScene(stage, "main_menu_scene");
    }

}
