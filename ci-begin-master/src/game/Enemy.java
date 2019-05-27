package game;

import tklibs.Mathx;
import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Enemy {
    BufferedImage img;
    Vector2D poss;
    ArrayList<EnemyBullet> bullets;
    int count;
    public Enemy(){
        img=SpriteUtils.loadImage("assets/images/enemies/level0/black/1.png");
        poss=new Vector2D(0, Mathx.random(0,360));
        bullets=new ArrayList<>();
    }

    public void render(Graphics g){
        g.drawImage(img,(int)poss.X,(int)poss.Y,null);
        for(int i=0;i<bullets.size();i++){
            EnemyBullet bullet= bullets.get(i);
            bullet.render(g);}
    }
    public void run(){
        this.move();
        this.bulletsRun();
        this.fire();
    }

    private void fire() {
        count++;
        if(poss.Y>5 & count>20){
                EnemyBullet bullet = new EnemyBullet();
                bullet.position.set(this.poss.X, this.poss.Y);
                bullets.add(bullet);
                count=0;
        }
    }

    private void bulletsRun() {
        for (int i=0;i<bullets.size();i++){
            EnemyBullet bullet = bullets.get(i);
            bullet.run();}
    }

    private void move() {
        poss.Y+=2;
        poss.X=Mathx.random(0,360);
        if(poss.Y>600) {
            poss.Y=0;
            poss.X = Mathx.random(0,360);
        }
    }
}

