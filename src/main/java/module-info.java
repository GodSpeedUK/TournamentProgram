module tech.candy_dev.tournamentprogram {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens tech.candy_dev.tournamentprogram to javafx.fxml;
    opens tech.candy_dev.tournamentprogram.scene.controller to javafx.fxml;
    exports tech.candy_dev.tournamentprogram;
}