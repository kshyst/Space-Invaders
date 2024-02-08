package com.spaceinvader.spaceinvader;

import javafx.geometry.Point2D;
import javafx.scene.Node;

public class GameObject {
    private Node view;
    public GameObject(Node view){
        this.view = view;
    }
    public Node getView(){
        return view;
    }

    //Movement
    private Point2D velocity = new Point2D(0 ,0);
    public double getRotate(){
        return view.getRotate();
    }
    public void rotateRight(){
        view.setRotate(getRotate() + 5);
    }
    public void rotateLeft(){
        view.setRotate(getRotate() - 5);
    }
    public void moveForward(){

    }
    //Object Status
    private boolean alive = true;
    public boolean isAlive(){
        return alive;
    }
    public void SetAlive(boolean alive){
        this.alive = alive;
    }
    public boolean isColliding(GameObject other){
        return getView().getBoundsInParent().intersects(other.getView().getBoundsInParent());
    }
}
