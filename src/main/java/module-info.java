module com.spaceinvader.spaceinvader {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.spaceinvader.spaceinvader to javafx.fxml;
    exports com.spaceinvader.spaceinvader;
}