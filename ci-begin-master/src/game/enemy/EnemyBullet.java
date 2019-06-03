package game.enemy;

import game.GameObject;

import game.Settings;
import game.physics.BoxCollider;
import game.player.Player;
import tklibs.SpriteUtils;



public class EnemyBullet extends GameObject {
    public int damageofenemy;
    public EnemyBullet(){
        image= SpriteUtils.loadImage("assets/images/enemies/bullets/green.png");
        velocity.set(0,Settings.ENEMY_BULLET_RUN);
        hitbox= new BoxCollider(this,16,16);
        damageofenemy=2;
    }

    @Override
    public void run(){
        super.run();
        this.checkPlayer();
    }
    private void checkPlayer() {
        Player player =GameObject.findIntersects(Player.class, this.hitbox);
        if(player !=null){
            //deactive enemy and playerbullet ~ this
//            enemy.deactive();
            this.deactive();
            player.takeDamage(damageofenemy);
        }
    }

}
