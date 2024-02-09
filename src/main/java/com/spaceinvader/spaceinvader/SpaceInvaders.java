package com.spaceinvader.spaceinvader;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.effect.BlendMode;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Background;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SpaceInvaders extends Application {
    public Pane root;
    private List<GameObject> bullets = new ArrayList<GameObject>();
    private Player player1 , player2;
    public boolean isWPressed = false , isDPressed = false , isAPressed = false , isSPressed = false , isIPressed = false , isKPressed = false , isLPressed = false , isJPressed = false , isPlayer1Firing = false , isPlayer2Firing = false;
    public Parent CreateContent(Stage stage) throws IOException{
        root = new Pane();

        player1 = new Player(Color.BLUE );
        player2 = new Player(Color.GREEN );

        player1.view.setBlendMode(BlendMode.DIFFERENCE);

        AddGameObject(player1 , 100 , 100 , 0);
        AddGameObject(player2 , 700 , 700 , 0);
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                onUpdate(stage);
            }
        };

        timer.start();

        root.setBackground(Background.fill(Color.BLACK));
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
    private void onUpdate(Stage stage){

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
            if (isPlayer1Firing && player1.fireRate <= 0){
                Bullets bullet = new Bullets();
                AddBullet(bullet , player1.getView().getTranslateX() , player1.getView().getTranslateY() , player1.getView().getRotate());
                player1.fireRate = Player.fireRateValue;
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
            if (isPlayer2Firing && player2.fireRate <= 0) {
                Bullets bullet = new Bullets();
                AddBullet(bullet, player2.getView().getTranslateX(), player2.getView().getTranslateY(), player2.getView().getRotate());
                player2.fireRate = Player.fireRateValue;
            }
        }

        //check for collision between players and bullets
        for(GameObject bullet : bullets){
            if (bullet.isColliding(player1) && bullet.timer > 40){
                bullet.SetAlive(false);
                player1.SetAlive(false);
                root.getChildren().remove(player1.getView());
                root.getChildren().remove(bullet.getView());
                player1.canFireBullet = false;

                SpaceInvadersController controller = new SpaceInvadersController();
                controller.changeLabel2(root);
            }
            if (bullet.isColliding(player2) && bullet.timer > 40){
                bullet.SetAlive(false);
                player2.SetAlive(false);
                root.getChildren().remove(player2.getView());
                root.getChildren().remove(bullet.getView());
                player2.canFireBullet = false;

                SpaceInvadersController controller = new SpaceInvadersController();
                controller.changeLabel(root);
            }
            bullet.timer++;
        }
        //checks is objects are alive or not if yes remove them
        bullets.removeIf(GameObject::isDead);
        bullets.forEach(GameObject::update);

        player1.fireRate--;
        player2.fireRate--;
    }
    @Override
    public void start(Stage stage) throws IOException {
        Scene scene  = new Scene(CreateContent(stage));
        StageSettings.CreateStage(stage , scene);
        Pane fxmlLoader = FXMLLoader.load(Objects.requireNonNull(SpaceInvaders.class.getResource("hello-view.fxml")));
        root.getChildren().add(fxmlLoader);

        stage.getScene().setOnKeyPressed(e -> {
            System.out.println(e.getCode());
            if (e.getCode() == KeyCode.ESCAPE){
                System.exit(0);
            }
            if (e.getCode() == KeyCode.NUMPAD8){
                isIPressed = true;
            }
            if (e.getCode() == KeyCode.NUMPAD5){
                isKPressed = true;
            }
            if (e.getCode() == KeyCode.NUMPAD6){
                isLPressed = true;
            }
            if (e.getCode() == KeyCode.NUMPAD4){
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
            if (e.getCode() == KeyCode.NUMPAD7){
                isPlayer2Firing = true;
            }
        });
        stage.getScene().setOnKeyReleased(e -> {

            if (e.getCode() == KeyCode.W){
                isWPressed = false;
            }
            if (e.getCode() == KeyCode.D){
                isDPressed = false;
            }
            if (e.getCode() == KeyCode.NUMPAD8){
                isIPressed = false;
            }
            if (e.getCode() == KeyCode.NUMPAD5){
                isKPressed = false;
            }
            if (e.getCode() == KeyCode.NUMPAD4){
                isJPressed = false;
            }
            if (e.getCode() == KeyCode.NUMPAD6){
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
            if (e.getCode() == KeyCode.NUMPAD7){
                isPlayer2Firing = false;
            }
        });
    }
    public static void main(String[] args) {
        launch(args);
    }
}