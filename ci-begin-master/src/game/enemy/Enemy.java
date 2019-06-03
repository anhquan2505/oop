package game.enemy;
import game.GameObject;
import game.Settings;
import game.Vector2D;
import game.physics.BoxCollider;
import tklibs.Mathx;
import tklibs.SpriteUtils;

public class Enemy extends GameObject {
    int count,count2;
    public int hp;
    public Enemy(){
        image=SpriteUtils.loadImage("assets/images/enemies/level0/black/1.png");
        position.set(0,0);
        velocity.set(0,3);
        hitbox=new BoxCollider(this,34,50);
        hp=50;
    }
    public void takeDamage(int damage){
        hp-=damage;
        if(hp<=0){
            hp=0;
            this.deactive();
        }
    }
    @Override
    public void run(){
        this.move();
        this.fire();
    }

    private void fire() {

        count++;
        if( count>50){
                EnemyBullet bullet = new EnemyBullet();
                bullet.position.set(this.position.x, this.position.y);
                count=0;
                EnemyBullet bullet2 = new EnemyBullet();
                bullet2.position.set(this.position.x+22, this.position.y-10);
                count=0;
                EnemyBullet bullet3 = new EnemyBullet();
                bullet3.position.set(this.position.x-7, this.position.y-10);
                count=0;
                EnemyBullet bullet5 = new EnemyBullet();
                bullet5.position.set(this.position.x+7.5, this.position.y+10);
                count=0;
                EnemyBullet bullet4 = new EnemyBullet();
                bullet4.position.set(this.position.x+15, this.position.y);
                count=0;


        }
    }

    private void move() {
        count2 ++;
        if (count2>70) {
            position.x = Mathx.random(0, 360);
            count2=0;
        }
    }
}

