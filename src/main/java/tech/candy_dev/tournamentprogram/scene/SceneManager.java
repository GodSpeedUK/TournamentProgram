package tech.candy_dev.tournamentprogram.scene;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import tech.candy_dev.tournamentprogram.TournamentProgram;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class SceneManager {

    private Map<String, Scene> sceneMap;

    public SceneManager() {
        this.sceneMap = new HashMap<>();
        loadScenes();
    }

    public Scene getScene(String name) {
        return sceneMap.get(name.toLowerCase());
    }

    private void loadScenes() {
        try {
            registerScene("main_menu_scene");
            registerScene("creation_scene");
            registerScene("event_creation_scene");
            registerScene("individual_view_scene");
            registerScene("scoreboard_scene");
            registerScene("team_view_scene");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void registerScene(String sceneId) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(TournamentProgram.class.getResource("scenes/" + sceneId + ".fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        sceneMap.put(sceneId.toLowerCase(), scene);
    }

    public void showScene(Stage stage, String scene) {
        stage.setScene(getScene(scene));
    }

}
