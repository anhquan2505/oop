import tklibs.Mathx;
import tklibs.SpriteUtils;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class gamepanel extends JPanel {
    BufferedImage playerimg,enemyimg;
    BufferedImage bgimg;
//    int playerX,
//int enemyX,enemyY;
//    int playerY;
    Vector2D plposs,enposs;
    double fps;
    int bgX;
    int bgY;
    int bgh,playerH,playerW;
    public gamepanel(){
        // tự động gọi lại tất cả hàm tạo cấp cha nếu k khai báo gamepanel
        playerimg= SpriteUtils.loadImage("assets/images/players/straight/0.png");
        bgimg=SpriteUtils.loadImage("assets/images/background/0.png");
        fps=0;
        //vector2D player position
        enemyimg=SpriteUtils.loadImage("assets/images/enemies/level0/black/1.png");
//        playerX=50;
//        playerY=500;
        plposs=new Vector2D(50,500);
        enposs=new Vector2D(0,Mathx.random(0,360));
        playerH=playerimg.getHeight();
        playerW=playerimg.getWidth();

        bgh=bgimg.getHeight();
//        enemyX=0;
//        enemyY=Mathx.random(0,360);
        bgY=600-bgh;
    }

    @Override
    public void paint(Graphics g) {
//        super.paint(g);
        g.setColor(Color.WHITE);
        g.fillRect(0,0,800,600);
        g.drawImage(bgimg,bgX,bgY,null);
        g.drawImage(playerimg,(int)plposs.X,(int)plposs.Y,null);
        g.setColor(Color.red);
        g.drawString("fps:"+ fps ,700,40);
        g.drawImage(enemyimg,(int)enposs.X,(int)enposs.Y,null);
    }
    public void runall(int i){
//        playerX ++;
//        if(playerX>384){
//            playerX=384;
//        }
//        enemyY ++;
//
//        if (enemyX>(bgimg.getWidth())){
//
//            enemyX+=2;
//        }


//        playerX= new Random().nextInt(360);
//        playerY= new Random().nextInt(500);

        bgY=bgY+5;
        if(bgY>=0){
            bgY=0;
        }
        //player run
        if(KeyEventPress.IsUpPress){
            plposs.Y--;
            }
//        if(playerY>=600-playerH){
//            playerY=0;
//        }
        if(KeyEventPress.IsDownPress){
            plposs.Y++;
            }
//        if(playerY<0){
//            playerY=0;
//        }
        if(KeyEventPress.IsLeftPress){
            plposs.X--;
            }
//
        if(KeyEventPress.IsRightPress){
            plposs.X++;

        }
//        if(playerX>=384-32){
//            playerX=384-32;
//        }
//        if(playerX<0){
//            playerX=0;
//        }
        plposs.X=Mathx.clamp(plposs.X,0,384-playerW);
        plposs.Y=Mathx.clamp(plposs.Y,0,600-playerH);
        enposs.Y++;
        if(enposs.Y>600) {
            enposs.Y=0;
            enposs.X = Mathx.random(0,360);
        }

    }



    public void gameloop(){
        //tự động gọi lại hàm paint
        long lastime=0;
        int i=0;
        long delay=1000/70;
        while (true){
            long currentTime=System.currentTimeMillis();
            if (currentTime-lastime>delay){
                fps=1000/(currentTime-lastime);
//                System.out.println(currentTime-lastime);
                repaint();
                runall(i);
                lastime=currentTime;
                i++;
            }

        }

    }
}
