package tech.candy_dev.tournamentprogram;

import javafx.application.Application;
import javafx.stage.Stage;
import tech.candy_dev.tournamentprogram.individual.IndividualManager;
import tech.candy_dev.tournamentprogram.scene.SceneManager;
import tech.candy_dev.tournamentprogram.team.TeamManager;

import java.io.IOException;

public class TournamentProgram extends Application {

    private static TournamentProgram instance;

    private final TeamManager teamManager;

    private final SceneManager sceneManager;

    private final IndividualManager individualManager;

    public TournamentProgram() {
        instance = this;
        this.sceneManager = new SceneManager();
        this.teamManager = new TeamManager();
        this.individualManager = new IndividualManager();
    }

    public IndividualManager getIndividualManager() {
        return individualManager;
    }

    public SceneManager getSceneManager() {
        return sceneManager;
    }

    public TeamManager getTeamManager() {
        return teamManager;
    }

    @Override
    public void start(Stage stage) throws IOException {
        stage.show();
        this.sceneManager.showScene(stage, "main_menu_scene");
    }

    public static void main(String[] args) {
        launch();
    }

    public static TournamentProgram getInstance() {
        return instance;
    }
}