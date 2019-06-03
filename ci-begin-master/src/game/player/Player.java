package game.player;

import game.GameObject;
import game.KeyEventPress;
import game.Settings;
import game.enemy.Enemy;
import game.physics.BoxCollider;
import tklibs.Mathx;
import tklibs.SpriteUtils;

public class Player extends GameObject {
    int playerH,playerW,hp;

    public Player(){
        image = SpriteUtils.loadImage("assets/images/players/straight/0.png") ;
        position.set(50,500);
        playerH=image.getHeight();
        playerW=image.getWidth();
        hp=20;
        hitbox=new BoxCollider(this,32,48);

    }
    @Override
    public void run(){
        super.run();// position.add(velocity)
        this.move();
        this.limitposs();
        this.fire();
        this.checkintersect();
    }
int count=0;
    private void fire() {
        count++;
        if (KeyEventPress.IsFirePress && count>20){
            double stepAngle=Math.abs((Settings.PLAYER_BULLET_END_ANGEL-Settings.PLAYER_BULLET_START_ANGEL)
                    /(Settings.PLAYER_BULLET_NUMBER_BULLETS-1));
            double stepX = Math.abs(Settings.PLAYER_BULLET_END_X-Settings.PLAYER_BULLET_START_X)
                    /(Settings.PLAYER_BULLET_NUMBER_BULLETS-1);
            for (int i=0;i<Settings.PLAYER_BULLET_NUMBER_BULLETS;i++){
            PlayerBullet bullet = new PlayerBullet();
            bullet.position.set(this.position.x+(Settings.PLAYER_BULLET_START_X-stepX*i),this.position.y);
            bullet.velocity.setAngle(Math.toRadians(Settings.PLAYER_BULLET_START_ANGEL - (stepAngle*i)));
            count=0;
            }
        }
    }

    public void limitposs(){
        position.x = Mathx.clamp(position.x,0,Settings.BACKGROUND_WIDTH-playerW);
        position.y =Mathx.clamp(position.y,0, Settings.GAME_HEIGH -playerH);
    }
    public void move(){
        double vx =0;
        double vy=0;
        if(KeyEventPress.IsUpPress){
            vy--;
            this.image=SpriteUtils.loadImage("assets/images/players/straight/6.png");
        }
        if(KeyEventPress.IsDownPress){
            vy++;
            this.image=SpriteUtils.loadImage("assets/images/players/straight/6.png");
        }
        if(KeyEventPress.IsLeftPress){
            this.image=SpriteUtils.loadImage("assets/images/players/left/5.png");
            vx--;
        }
        if(KeyEventPress.IsRightPress){
            this.image=SpriteUtils.loadImage("assets/images/players/right/5.png");
            vx++;
        }
        if(!KeyEventPress.IsPress){
            this.image=SpriteUtils.loadImage("assets/images/players/straight/6.png");
        }

        velocity.set(vx,vy);
        velocity.setLength(2);
    }
    public void takeDamage(int damage) {
        hp -= damage;
        if (hp <= 0) {
            hp = 0;
            this.deactive();
        }

    }
    public void checkintersect(){
        Enemy enemy=GameObject.findIntersects(Enemy.class, this.hitbox);
        if(enemy!=null){
            this.deactive();
        }
    }
}
