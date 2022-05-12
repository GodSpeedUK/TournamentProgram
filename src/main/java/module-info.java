
module me.dan.tournamentprogram {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.google.gson;
    requires Simple.Yaml;

    opens me.dan.tournamentprogram.individual to com.google.gson;
    opens me.dan.tournamentprogram.team to com.google.gson;
    opens me.dan.tournamentprogram to javafx.fxml, com.google.gson;
    opens me.dan.tournamentprogram.scene.controller to javafx.fxml;
    exports me.dan.tournamentprogram;

}
