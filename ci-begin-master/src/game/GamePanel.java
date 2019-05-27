package game;
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
        enemy=new Enemy();
        player=new Player();
        background= new Background();
    }

    @Override
    public void paint(Graphics g) {
//        super.paint(g);

        g.setColor(Color.WHITE);
        g.fillRect(0,0,800,600);
        background.render(g);
        player.render(g);
        enemy.render(g);
        g.setColor(Color.red);
        g.drawString("fps:"+ fps ,700,40);
    }

    public void runall(){
        background.run();
        player.run();
        enemy.run();
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
