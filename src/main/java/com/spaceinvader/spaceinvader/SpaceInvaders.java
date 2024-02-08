package com.spaceinvader.spaceinvader;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class SpaceInvaders extends Application {
    private ArrayList<GameObject> bullets = new ArrayList<>();
    private GameObject player1;
    private GameObject player2;
    private Scene CreateContent() throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(SpaceInvaders.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        player1 = new Player();
        player2 = new Player();
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                onUpdate();
            }
        };

        timer.start();
        return scene;
    }
    private void onUpdate(){

    }

    @Override
    public void start(Stage stage) throws IOException {
        StageSettings.CreateStage(stage , CreateContent());
    }
    public static void main(String[] args) {
        launch();
    }
}