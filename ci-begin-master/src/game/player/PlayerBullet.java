package game.player;

import game.GameObject;
import game.Settings;
import tklibs.SpriteUtils;

public class PlayerBullet extends GameObject {

    public PlayerBullet(){
        image=SpriteUtils.loadImage("assets/images/Player-bullets/a/1.png");
    }
    public void run(){
        position.y-= Settings.PLAYER_BULLET_RUN;

    }
}
