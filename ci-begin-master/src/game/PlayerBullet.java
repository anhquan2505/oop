package game;

import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;

public class PlayerBullet {
    BufferedImage image;
    Vector2D position;
    public PlayerBullet(){
        image=SpriteUtils.loadImage("assets/images/Player-bullets/a/1.png");
        position=new Vector2D(0,0);
    }
    public void render(Graphics g){
        g.drawImage(image,(int)position.X,(int)position.Y,null);
    }
    public void run(){
        position.Y-=5;
    }
}
