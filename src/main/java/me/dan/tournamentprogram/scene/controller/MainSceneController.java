package me.dan.tournamentprogram.scene.controller;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import me.dan.tournamentprogram.TournamentProgram;

public class MainSceneController {

    @FXML
    private Button individualAndTeamCreatorButton;

    @FXML
    private Button eventCreatorButton;

    @FXML
    private Button individualInfoButton;

    @FXML
    private Button teamInfoButton;

    @FXML
    private Button scoreboardButton;

    public void switchScene(MouseEvent mouseEvent, String scene) {
        Stage stage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
        TournamentProgram.getInstance().getSceneManager().showScene(stage, scene);
    }

    public void onIndividualAndTeamCreatorClick(MouseEvent mouseEvent) {
        switchScene(mouseEvent, "creation_scene");
    }

    public void onEventCreatorClick(MouseEvent mouseEvent) {
        switchScene(mouseEvent, "event_creation_scene");
    }

    public void onIndividualViewClick(MouseEvent mouseEvent) {
        IndividualViewController.getInstance().refresh();
        IndividualViewController.getInstance().refreshList();
        switchScene(mouseEvent, "individual_view_scene");
    }

    public void onTeamViewClick(MouseEvent mouseEvent) {
        TeamViewController.getInstance().refreshTeamList();
        switchScene(mouseEvent, "team_view_scene");
    }

    public void onScoreBoardClick(MouseEvent mouseEvent){
        switchScene(mouseEvent, "scoreboard_scene");
    }

    public void onQuitButtonClick(MouseEvent mouseEvent) {
        System.exit(1);
    }

}
