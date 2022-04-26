package tech.candy_dev.tournamentprogram.scene.controller;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import tech.candy_dev.tournamentprogram.TournamentProgram;

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

    public void onIndividualAndTeamCreatorClick(MouseEvent mouseEvent) {
        Stage stage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
        TournamentProgram.getInstance().getSceneManager().showScene(stage, "creation_scene");
    }
}
