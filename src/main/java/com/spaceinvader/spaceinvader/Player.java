package com.spaceinvader.spaceinvader;

import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.TriangleMesh;

public class Player extends GameObject{
    public static int fireRateValue = 50;
    public boolean canFireBullet = true;
    public int fireRate = fireRateValue;

    public Player(Color color) {
        super(new Rectangle(40 , 40 , color), "Player");
    }
}
