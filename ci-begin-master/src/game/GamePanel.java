package game;
import game.enemy.Enemy;
import game.player.Player;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    Enemy enemy;
    Player player;
    Background background;
    double fps;

    public GamePanel(){
        // tự động gọi lại tất cả hàm tạo cấp cha nếu k khai báo GamePanel
        fps=0;
        background= new Background();
        enemy=new Enemy();

        player=new Player();

    }

    @Override
    public void paint(Graphics g) {

        g.setColor(Color.WHITE);
        g.fillRect(0,0,Settings.GAME_WIDTH,Settings.GAME_HEIGH);
        GameObject.renderAll(g);
        g.setColor(Color.red);
        g.drawString("fps:"+ fps ,700,40);
    }

    public void runall(){
        GameObject.runAll();//bulletRun()
    }

    public void gameloop(){
        long lastime=0;
        int i=0;
        long delay=1000/70;
        while (true){
            long currentTime=System.currentTimeMillis();
            if (currentTime-lastime>delay){
                fps=1000/(currentTime-lastime);
                repaint();
                runall();
                lastime=currentTime;
                i++;
            }
        }
    }
}
