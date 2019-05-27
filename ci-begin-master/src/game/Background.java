package game;

import tklibs.Mathx;
import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Background {
    BufferedImage img;
    Vector2D background;
    int bgh;
    final int SPEED=10;
    public Background(){
        img= SpriteUtils.loadImage("assets/images/Background/0.png");
        background= new Vector2D(0,600-3109);
        bgh=img.getHeight();
        background.Y=600-bgh;
    }
    public void render(Graphics g){
        g.drawImage(img,(int)background.X,(int)background.Y,null);


    }
    public void run(){
        background.Y=background.Y+5;
        if(background.Y>=0){
            background.Y=0;
        }
    }
}
