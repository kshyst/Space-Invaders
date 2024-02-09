package com.spaceinvader.spaceinvader;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class StageSettings {

    public static int stageWidth = 800;
    public static int stageHeigth = 800;
    //public static Image icon = new Image("C:\\Users\\KSHyst\\IdeaProjects\\SpaceInvader\\src\\main\\resources\\com\\spaceinvader\\spaceinvader\\icon.jpg");
    public static String stageTitle = "Space Invaders by KSHyst";

    public static void CreateStage(Stage stage , Scene scene){
        stage.setTitle(stageTitle);
        stage.setResizable(false);
        stage.setHeight(stageHeigth);
        stage.setWidth(stageWidth);
        stage.setScene(scene);
        stage.show();
    }
}
