package com.spaceinvader.spaceinvader;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.File;

public class StageSettings {

    public static int stageWidth = 800;
    public static int stageHeigth = 800;
    public Image icon = new Image(new File("src/main/resources/com/spaceinvader/spaceinvader/Sprites/icon.jpg").toURI().toString());
    public static String stageTitle = "Space Invaders by KSHyst";

    public static void CreateStage(Stage stage , Scene scene){
        stage.setTitle(stageTitle);
        stage.setResizable(false);
        stage.setHeight(stageHeigth);
        stage.setWidth(stageWidth);
        stage.getIcons().add(new Image(new File("src/main/resources/com/spaceinvader/spaceinvader/Sprites/icon.jpg").toURI().toString()));
        stage.setScene(scene);
        stage.show();
    }
}
