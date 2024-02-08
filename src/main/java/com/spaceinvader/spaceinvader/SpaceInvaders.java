package com.spaceinvader.spaceinvader;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SpaceInvaders extends Application {
    private Pane root;
    private List<GameObject> bullets = new ArrayList<GameObject>();
    private Player player1 , player2;
    private SpaceInvadersController controller = new SpaceInvadersController();
    private boolean isWPressed = false , isDPressed = false , isAPressed = false , isSPressed = false , isIPressed = false , isKPressed = false , isLPressed = false , isJPressed = false , isPlayer1Firing = false , isPlayer2Firing = false;
    private Parent CreateContent() throws IOException{
        root = new Pane();
        root.setPrefSize(800 , 800);

        player1 = new Player(Color.BLUE);
        player2 = new Player(Color.GREEN);

        AddGameObject(player1 , 100 , 100 , 0);
        AddGameObject(player2 , 700 , 700 , 0);
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                onUpdate();
            }
        };

        timer.start();
        return root;
    }
    private void AddBullet(GameObject bullet , double x , double y , double rot){
        bullets.add(bullet);
        AddGameObject(bullet , x , y , rot);
    }
    private void AddGameObject(GameObject object , double x , double y , double rot ){
        object.getView().setTranslateX(x);
        object.getView().setTranslateY(y);
        object.getView().setRotate(rot);
        root.getChildren().add(object.getView());
    }
    private void onUpdate(){

        if (player1.canFireBullet){
            if (isWPressed){
                player1.moveForward();
            }
            if (isSPressed){
                player1.moveBackward();
            }
            if (isAPressed){
                player1.rotateLeft();
            }
            if (isDPressed){
                player1.rotateRight();
            }
            if (isPlayer1Firing){
                Bullets bullet = new Bullets();
                AddBullet(bullet , player1.getView().getTranslateX() , player1.getView().getTranslateY() , player1.getView().getRotate());
            }
        }
        if (player2.canFireBullet){
            if (isIPressed){
                player2.moveForward();
            }
            if (isKPressed){
                player2.moveBackward();
            }
            if (isJPressed){
                player2.rotateLeft();
            }
            if (isLPressed){
                player2.rotateRight();
            }
            if (isPlayer2Firing) {
                Bullets bullet = new Bullets();
                AddBullet(bullet, player2.getView().getTranslateX(), player2.getView().getTranslateY(), player2.getView().getRotate());
            }
        }
        root.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ESCAPE){
                System.exit(0);
            }
            if (e.getCode() == KeyCode.I){
                isIPressed = true;
            }
            if (e.getCode() == KeyCode.K){
                isKPressed = true;
            }
            if (e.getCode() == KeyCode.L){
                isLPressed = true;
            }
            if (e.getCode() == KeyCode.H){
                isJPressed = true;
            }
            if (e.getCode() == KeyCode.W){
                isWPressed =true;
            }
            if (e.getCode() == KeyCode.S){
                isSPressed = true;
            }
            if (e.getCode() == KeyCode.D){
                isDPressed = true;
            }
            if (e.getCode() == KeyCode.A){
                isAPressed = true;
            }
            if (e.getCode() == KeyCode.Q){
                isPlayer1Firing = true;
            }
            if (e.getCode() == KeyCode.U){
                isPlayer2Firing = true;
            }
        });
        root.setOnKeyReleased(e -> {

            if (e.getCode() == KeyCode.W){
                isWPressed = false;
            }
            if (e.getCode() == KeyCode.D){
                isDPressed = false;
            }
            if (e.getCode() == KeyCode.I){
                isIPressed = false;
            }
            if (e.getCode() == KeyCode.K){
                isKPressed = false;
            }
            if (e.getCode() == KeyCode.H){
                isJPressed = false;
            }
            if (e.getCode() == KeyCode.L){
                isLPressed = false;
            }
            if (e.getCode() == KeyCode.A){
                isAPressed = false;
            }
            if (e.getCode() == KeyCode.S){
                isSPressed = false;
            }
            if (e.getCode() == KeyCode.Q){
                isPlayer1Firing = false;
            }
            if (e.getCode() == KeyCode.U){
                isPlayer2Firing = false;
            }
        });
        //check for collision between players and bullets
        for(GameObject bullet : bullets){
            if (bullet.isColliding(player1) && bullet.timer > 20){
                bullet.SetAlive(false);
                player1.SetAlive(false);
                root.getChildren().remove(player1.getView());
                root.getChildren().remove(bullet.getView());
                System.out.println(player1.color.toString() + " wins");
                player1.canFireBullet = false;
            }
            if (bullet.isColliding(player2) && bullet.timer > 20){
                bullet.SetAlive(false);
                player2.SetAlive(false);
                root.getChildren().remove(player2.getView());
                root.getChildren().remove(bullet.getView());
                System.out.println(player2.color.toString() + " wins");
                controller.setWinnerText();
                player2.canFireBullet = false;
            }
            bullet.timer++;
        }
        //checks is objects are alive or not if yes remove them
        bullets.removeIf(GameObject::isDead);
        bullets.forEach(GameObject::update);
    }
    @Override
    public void start(Stage stage) throws IOException {
        StageSettings.CreateStage(stage , new Scene(CreateContent()));
        Pane fxmlLoader = FXMLLoader.load(Objects.requireNonNull(SpaceInvaders.class.getResource("hello-view.fxml")));
        root.getChildren().add(fxmlLoader);

    }
    public static void main(String[] args) {
        launch();
    }
}