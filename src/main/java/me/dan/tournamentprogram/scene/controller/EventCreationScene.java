package me.dan.tournamentprogram.scene.controller;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import me.dan.tournamentprogram.TournamentProgram;
import me.dan.tournamentprogram.individual.Individual;
import me.dan.tournamentprogram.manager.Manager;
import me.dan.tournamentprogram.member.Member;
import me.dan.tournamentprogram.team.Team;

import java.util.HashMap;
import java.util.Map;

public class EventCreationScene {

    @FXML
    private ComboBox<String> creationTypeSelect;

    @FXML
    private TextField nameField;

    @FXML
    private ComboBox<String> memberSelection;

    @FXML
    private ComboBox<String> pointSelection;

    private Map<Integer, Member> memberMap;

    private Map<Member, Integer> scoreMap;

    @FXML
    private ListView<String> memberList;

    public void initialize() {
        memberMap = new HashMap<>();
        this.scoreMap = new HashMap<>();
        pointSelection.getItems().add("0");
        pointSelection.getItems().add("1");
        pointSelection.getItems().add("2");
        pointSelection.getItems().add("3");
        this.creationTypeSelect.getItems().add("Team");
        this.creationTypeSelect.getItems().add("Individual");
        this.creationTypeSelect.valueProperty().addListener(observable -> {
            memberSelection.getItems().clear();
            memberList.getItems().clear();
            scoreMap.clear();
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

    public void onAddButtonClick(MouseEvent mouseEvent) {
        if (pointSelection.getSelectionModel().getSelectedItem() == null || pointSelection.getSelectionModel().getSelectedItem().equalsIgnoreCase("")) {
            return;
        }

        if (memberSelection.getSelectionModel().getSelectedItem() == null || memberSelection.getSelectionModel().getSelectedItem().equalsIgnoreCase("")) {
            return;
        }


        Member member = memberMap.get(memberSelection.getSelectionModel().getSelectedIndex());

        if (scoreMap.containsKey(member)) {
            return;
        }

        int points = Integer.parseInt(pointSelection.getSelectionModel().getSelectedItem());
        scoreMap.put(member, points);
        memberList.getItems().add(member.getName() + " (" + member.getId() + ") - " + points);
    }

    public void onCreateButtonClick(MouseEvent mouseEvent) {
        if (nameField.getText() == null || nameField.getText().equalsIgnoreCase("")) {
            return;
        }

        String name = nameField.getText();

        if (name == null || name.equalsIgnoreCase("")) {
            error("You must set an Event Name!");
            return;
        }

        String type = creationTypeSelect.getSelectionModel().getSelectedItem();

        if (type == null || type.equalsIgnoreCase("")) {
            error("You must select an Event Type!");
            return;
        }


        if (scoreMap.isEmpty()) {
            error("You must add Members to the Event!");
            return;
        }

        if (TournamentProgram.getInstance().getEventManager().createEvent(name, type, scoreMap)) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setContentText("Event Created: " + name);
            alert.show();
            return;
        }
        error("Could not create Event!");
    }

    private void error(String text) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setContentText(text);
        alert.show();
    }


}
