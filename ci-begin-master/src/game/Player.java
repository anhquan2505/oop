package game;

import tklibs.Mathx;
import tklibs.SpriteUtils;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Player {
    BufferedImage PlayerImage;//Player image
    Vector2D playerpossition;
    ArrayList<PlayerBullet> bullets;
    int playerH,playerW;


    public Player(){
        PlayerImage = SpriteUtils.loadImage("assets/images/players/straight/0.png") ;
        playerpossition= new Vector2D(50,500);
        playerH=PlayerImage.getHeight();
        playerW=PlayerImage.getWidth();

        bullets=new ArrayList<>();


    }
    public void render(Graphics g){
        g.drawImage(PlayerImage,(int)playerpossition.X,(int)playerpossition.Y,null);
        for(int i=0;i<bullets.size();i++){
            PlayerBullet bullet= bullets.get(i);
            bullet.render(g);
        }
    }
    public void run(){
        this.move();
        this.limitposs();
        this.bulletsRun();
        this.fire();
    }
int count=0;
    private void fire() {
        count++;

        if (KeyEventPress.IsFirePress && count>20){
            PlayerBullet bullet = new PlayerBullet();
            bullet.position.set(this.playerpossition.X,this.playerpossition.Y);
            bullets.add(bullet);
            count=0;
        }
    }

    private void bulletsRun() {
        for (int i=0;i<bullets.size();i++){
            PlayerBullet bullet = bullets.get(i);
            bullet.run();
        }
    }

    public void limitposs(){
        playerpossition.X= Mathx.clamp(playerpossition.X,0,384-playerW);
        playerpossition.Y=Mathx.clamp(playerpossition.Y,0,600-playerH);

    }
    public void move(){
        if(KeyEventPress.IsUpPress){
            playerpossition.Y--;
        }
        if(KeyEventPress.IsDownPress){
            playerpossition.Y++;
        }
//        if(KeyEventPress.IsLeftPress){
//            playerpossition.X--;
//        }
//        if(KeyEventPress.IsRightPress){
//            playerpossition.X++;
//        }
        playerpossition.X=Mathx.random(0,360);
    }
}
