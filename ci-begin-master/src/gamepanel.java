import tklibs.SpriteUtils;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class gamepanel extends JPanel {
    BufferedImage playerimg,enemyimg;
    BufferedImage bgimg;
    int playerX,enemyX,enemyY;
    int playerY;
    double fps;
    int bgX;
    int bgY;
    int bgh;
    public gamepanel(){
        // tự động gọi lại tất cả hàm tạo cấp cha nếu k khai báo gamepanel
        playerimg= SpriteUtils.loadImage("assets/images/players/straight/0.png");
        bgimg=SpriteUtils.loadImage("assets/images/background/0.png");
        fps=0;
        enemyimg=SpriteUtils.loadImage("assets/images/enemies/level0/black/1.png");
        playerX=50;
        playerY=500;
        bgh=bgimg.getHeight();
        enemyX=0;
        enemyY=0;
        bgY=600-bgh;
    }

    @Override
    public void paint(Graphics g) {
//        super.paint(g);
        g.setColor(Color.WHITE);
        g.fillRect(0,0,800,600);
        g.drawImage(bgimg,bgX,bgY,null);
        g.drawImage(playerimg,playerX,playerY,null);
        g.setColor(Color.red);
        g.drawString("fps:"+ fps ,700,40);
        g.drawImage(enemyimg,enemyX,enemyY,null);
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
        enemyX= new Random().nextInt(384);
        enemyY= new Random().nextInt(500);

        playerX= new Random().nextInt(384);
        playerY= new Random().nextInt(500);

        bgY=bgY+5;
        if(bgY>=0){
            bgY=0;
        }
    }



    public void gameloop(){
        //tự động gọi lại hàm paint
        long lastime=0;
        int i=0;
        long delay=1000/40;
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
