package com.spaceinvader.spaceinvader;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.TriangleMesh;

public class Player extends GameObject{
    public boolean canFireBullet = true;

    public Player(Color color) {
        super(new Rectangle(40 , 20 , color));
    }
}
