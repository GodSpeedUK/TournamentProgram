package me.dan.tournamentprogram.scene.controller;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import me.dan.tournamentprogram.TournamentProgram;
import me.dan.tournamentprogram.member.Member;

import java.util.*;

public class ScoreboardController {

    @FXML
    private ListView<String> scoreboard;

    @FXML
    private ComboBox<String> typeSelectComboBox;

    public void initialize() {
        typeSelectComboBox.getItems().add("Team");
        typeSelectComboBox.getItems().add("Individual");
        typeSelectComboBox.valueProperty().addListener(event -> {
            List<Member> members = new ArrayList<>();
            switch (typeSelectComboBox.getSelectionModel().getSelectedItem()) {
                case "Team" -> members.addAll(TournamentProgram.getInstance().getTeamManager().getAll());
                case "Individual" -> members.addAll(TournamentProgram.getInstance().getIndividualManager().getAll());
            }
            runScoreBoard(members);
        });
    }

    private <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> map) {
        List<Map.Entry<K, V>> list = new ArrayList<>(map.entrySet());
        list.sort(Map.Entry.comparingByValue());

        Collections.reverse(list);

        Map<K, V> result = new LinkedHashMap<>();
        for (Map.Entry<K, V> entry : list) {
            result.put(entry.getKey(), entry.getValue());
        }

        return result;
    }

    public void runScoreBoard(List<Member> members) {
        Map<Member, Integer> map = new HashMap<>();
        scoreboard.getItems().clear();
        for (Member member : members) {
            map.put(member, member.getScore());
        }

        map = sortByValue(map);

        int i = 1;

        for (Member key : map.keySet()) {
            String member = i + " - " + key.getName() + " (" + key.getId() + ") - " + key.getScore();
            scoreboard.getItems().add(member);
            i++;
        }

    }

    public void onMainMenuButtonClicked(MouseEvent mouseEvent) {
        Stage stage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
        TournamentProgram.getInstance().getSceneManager().showScene(stage, "main_menu_scene");
    }

}
