package com.spaceinvader.spaceinvader;

import javafx.geometry.Point2D;
import javafx.scene.Node;

public class GameObject {
    public int timer = 0;
    private Node view;
    public GameObject(Node view){
        this.view = view;
    }
    public Node getView(){
        return view;
    }

    //Movement

    public double getRotate(){
        return view.getRotate();
    }
    public void rotateRight(){
        view.setRotate(getRotate() + 2);
    }
    public void rotateLeft(){
        view.setRotate(getRotate() - 2);
    }
    public void moveForward(){
        double x = Math.cos(Math.toRadians(getRotate()));
        double y = Math.sin(Math.toRadians(getRotate()));
        view.setTranslateY(view.getTranslateY() - y * 0.5);
        view.setTranslateX(view.getTranslateX() - x * 0.5);
    }
    public void moveBackward(){
        double x = Math.cos(Math.toRadians(getRotate()));
        double y = Math.sin(Math.toRadians(getRotate()));
        view.setTranslateY(view.getTranslateY() + y * 0.5);
        view.setTranslateX(view.getTranslateX() + x * 0.5);
    }
    //Object Status
    private boolean alive = true;
    public boolean isAlive(){
        return alive;
    }
    public boolean isDead(){
        return !alive;
    }
    public void SetAlive(boolean alive){
        this.alive = alive;
    }
    public boolean isColliding(GameObject other){
        return getView().getBoundsInParent().intersects(other.getView().getBoundsInParent());
    }
    public void update(){
        double x = Math.cos(Math.toRadians(getRotate()));
        double y = Math.sin(Math.toRadians(getRotate()));
        view.setTranslateY(view.getTranslateY() - y * 3);
        view.setTranslateX(view.getTranslateX() - x * 3);
    }
}
