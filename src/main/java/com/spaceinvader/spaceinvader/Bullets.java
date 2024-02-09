package com.spaceinvader.spaceinvader;

import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Bullets extends GameObject{

    public Bullets() {
        super(new Circle(5 , 5 , 5 , Color.RED) , "Bullet");
    }
}
