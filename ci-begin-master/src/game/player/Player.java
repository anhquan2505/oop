package game.player;

import game.GameObject;
import game.KeyEventPress;
import game.Settings;
import tklibs.Mathx;
import tklibs.SpriteUtils;

public class Player extends GameObject {
    int playerH,playerW;

    public Player(){
        image = SpriteUtils.loadImage("assets/images/players/straight/0.png") ;
        position.set(50,500);
        playerH=image.getHeight();
        playerW=image.getWidth();
    }
    @Override
    public void run(){
        this.move();
        this.limitposs();
        this.fire();
    }
int count=0;
    private void fire() {
        count++;
        if (KeyEventPress.IsFirePress && count>20){
            PlayerBullet bullet = new PlayerBullet();
            bullet.position.set(this.position.x,this.position.y);
            count=0;
            PlayerBullet bullet2 = new PlayerBullet();
            bullet2.position.set(this.position.x,this.position.y+15);
            count=0;PlayerBullet bullet3 = new PlayerBullet();
            bullet3.position.set(this.position.x,this.position.y-15);
            count=0;PlayerBullet bullet4 = new PlayerBullet();
            bullet4.position.set(this.position.x,this.position.y+10);
            PlayerBullet bullet5 = new PlayerBullet();
            bullet5.position.set(this.position.x-10,this.position.y);
            count=0;
            PlayerBullet bullet6 = new PlayerBullet();
            bullet6.position.set(this.position.x+10,this.position.y);
            count=0;
            PlayerBullet bullet7 = new PlayerBullet();
            bullet7.position.set(this.position.x-7,this.position.y-10);
            count=0;
            PlayerBullet bullet8 = new PlayerBullet();
            bullet8.position.set(this.position.x+7,this.position.y-10);

        }
    }

    public void limitposs(){
        position.x = Mathx.clamp(position.x,0,Settings.BACKGROUND_WIDTH-playerW);
        position.y =Mathx.clamp(position.y,0, Settings.GAME_HEIGH -playerH);
    }
    public void move(){
        if(KeyEventPress.IsUpPress){
            position.y--;
        }
        if(KeyEventPress.IsDownPress){
            position.y++;
        }
        if(KeyEventPress.IsLeftPress){
            position.x--;
        }
        if(KeyEventPress.IsRightPress){
            position.x++;
        }

    }
}
