package com.spaceinvader.spaceinvader;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.TriangleMesh;

public class Player extends GameObject{
    public static int fireRateValue = 50;
    public boolean canFireBullet = true;
    public int fireRate = fireRateValue;

    public Player(Color color) {
        super(new Rectangle(40 , 20 , color));
    }
}
