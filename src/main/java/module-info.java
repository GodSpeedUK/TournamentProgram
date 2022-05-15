
module me.dan.tournamentprogram {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.google.gson;
    requires Simple.Yaml;

    opens me.dan.tournamentprogram.individual to com.google.gson;
    opens me.dan.tournamentprogram.team to com.google.gson;
    opens me.dan.tournamentprogram.event to com.google.gson;
    opens me.dan.tournamentprogram to javafx.fxml, com.google.gson;
    opens me.dan.tournamentprogram.scene.controller to javafx.fxml;
    exports me.dan.tournamentprogram;
    exports me.dan.tournamentprogram.event;
    exports me.dan.tournamentprogram.individual;
    exports me.dan.tournamentprogram.team;
    exports me.dan.tournamentprogram.member;
    exports me.dan.tournamentprogram.scene;

}
