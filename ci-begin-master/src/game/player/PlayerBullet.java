package game.player;

import game.GameObject;
import game.Settings;
import game.Vector2D;
import game.enemy.Enemy;
import game.physics.BoxCollider;
import tklibs.SpriteUtils;

public class PlayerBullet extends GameObject {

    public int damage;
    public PlayerBullet(){
        image=SpriteUtils.loadImage("assets/images/Player-bullets/a/1.png");
        velocity = new Vector2D(-0.5,-3);
        hitbox= new BoxCollider(this,24,24);
        damage=5;
    }

    @Override
    public void run(){
        super.run();
        this.checkEnemy();
        if (this.position.x>(Settings.BACKGROUND_WIDTH-this.image.getWidth())+10){
            this.deactive();
        }
    }

    private void checkEnemy() {
        Enemy enemy =GameObject.findIntersects(Enemy.class, this.hitbox);
        if(enemy !=null){
            this.deactive();
            enemy.takeDamage(damage);
        }
    }
}
