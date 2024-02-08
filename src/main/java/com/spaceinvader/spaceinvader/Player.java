package com.spaceinvader.spaceinvader;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.TriangleMesh;

public class Player extends GameObject{
    public Player() {
        super(new Rectangle(40 , 20 , Color.BLACK));
    }
}
