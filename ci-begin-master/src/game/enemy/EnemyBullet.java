package game.enemy;

import game.GameObject;

import game.Settings;
import tklibs.SpriteUtils;



public class EnemyBullet extends GameObject {
    public EnemyBullet(){
        image= SpriteUtils.loadImage("assets/images/enemies/bullets/green.png");

    }
    public void run(){
        position.y += Settings.ENEMY_BULLET_RUN;
    }
}
