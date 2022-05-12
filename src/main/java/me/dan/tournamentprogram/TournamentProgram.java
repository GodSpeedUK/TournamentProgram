package me.dan.tournamentprogram;

import javafx.application.Application;
import javafx.stage.Stage;
import me.dan.tournamentprogram.individual.IndividualManager;
import me.dan.tournamentprogram.scene.SceneManager;
import me.dan.tournamentprogram.team.TeamManager;

import java.io.File;
import java.io.IOException;

public class TournamentProgram extends Application {

    private static TournamentProgram instance;

    private final TeamManager teamManager;

    private final SceneManager sceneManager;

    private final IndividualManager individualManager;

    private final File dataFolder;

    public TournamentProgram() {
        instance = this;
        String userName = System.getProperty("user.name");
        File appData = new File("C:/users/" + userName + "/AppData/Roaming/");
        this.dataFolder = new File(appData, ".tournament");
        if (!this.dataFolder.exists()) {
            this.dataFolder.mkdirs();
        }
        this.sceneManager = new SceneManager();
        this.teamManager = new TeamManager();
        this.individualManager = new IndividualManager();
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

    public TeamManager getTeamManager() {
        return teamManager;
    }

    public SceneManager getSceneManager() {
        return sceneManager;
    }

    public IndividualManager getIndividualManager() {
        return individualManager;
    }

    public File getDataFolder() {
        return dataFolder;
    }
}