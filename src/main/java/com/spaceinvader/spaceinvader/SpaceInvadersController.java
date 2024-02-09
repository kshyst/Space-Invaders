package com.spaceinvader.spaceinvader;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Background;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class SpaceInvadersController {

    private Stage stage;

    public void RestartGame(ActionEvent event) throws IOException {
        stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        stage.close();
        stage.setTitle("Space Invaders by KSHyst");
        stage.setResizable(false);

        SpaceInvaders spaceInvaders = new SpaceInvaders();
        stage.setScene(new Scene(spaceInvaders.CreateContent(stage)));
        Pane fxmlLoader = FXMLLoader.load(Objects.requireNonNull(SpaceInvaders.class.getResource("hello-view.fxml")));
        spaceInvaders.root.getChildren().add(fxmlLoader);

        stage.getScene().setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ESCAPE){
                System.exit(0);
            }
            if (e.getCode() == KeyCode.NUMPAD8){
                spaceInvaders.isIPressed = true;
            }
            if (e.getCode() == KeyCode.NUMPAD5){
                spaceInvaders.isKPressed = true;
            }
            if (e.getCode() == KeyCode.NUMPAD6){
                spaceInvaders.isLPressed = true;
            }
            if (e.getCode() == KeyCode.NUMPAD4){
                spaceInvaders.isJPressed = true;
            }
            if (e.getCode() == KeyCode.W){
                spaceInvaders.isWPressed =true;
            }
            if (e.getCode() == KeyCode.S){
                spaceInvaders.isSPressed = true;
            }
            if (e.getCode() == KeyCode.D){
                spaceInvaders.isDPressed = true;
            }
            if (e.getCode() == KeyCode.A){
                spaceInvaders.isAPressed = true;
            }
            if (e.getCode() == KeyCode.Q){
                spaceInvaders.isPlayer1Firing = true;
            }
            if (e.getCode() == KeyCode.NUMPAD7){
                spaceInvaders.isPlayer2Firing = true;
            }
        });
        stage.getScene().setOnKeyReleased(e -> {

            if (e.getCode() == KeyCode.W){
                spaceInvaders.isWPressed = false;
            }
            if (e.getCode() == KeyCode.D){
                spaceInvaders.isDPressed = false;
            }
            if (e.getCode() == KeyCode.NUMPAD8){
                spaceInvaders.isIPressed = false;
            }
            if (e.getCode() == KeyCode.NUMPAD5){
                spaceInvaders.isKPressed = false;
            }
            if (e.getCode() == KeyCode.NUMPAD4){
                spaceInvaders.isJPressed = false;
            }
            if (e.getCode() == KeyCode.NUMPAD6){
                spaceInvaders.isLPressed = false;
            }
            if (e.getCode() == KeyCode.A){
                spaceInvaders.isAPressed = false;
            }
            if (e.getCode() == KeyCode.S){
                spaceInvaders.isSPressed = false;
            }
            if (e.getCode() == KeyCode.Q){
                spaceInvaders.isPlayer1Firing = false;
            }
            if (e.getCode() == KeyCode.NUMPAD7){
                spaceInvaders.isPlayer2Firing = false;
            }
        });

        stage.show();
    }

    //change Label
    public Label label = new Label();
    public void changeLabel2(Pane root){
        label.setText("Green Player Won!");
        label.setLayoutX(150);
        label.setStyle("-fx-text-fill: #008311");
        Font font = new Font("OCR A Extended",50);
        label.setFont(font);
        root.getChildren().add(label);
        System.out.println("Green Player Won!");
    }
    public void changeLabel(Pane root){
        label.setText("Blue Player Won!");
        label.setLayoutX(150);
        label.setStyle("-fx-text-fill: #0000FF");
        Font font = new Font("OCR A Extended",50);
        label.setFont(font);
        root.getChildren().add(label);
        System.out.println("Blue Player Won!");
    }

}