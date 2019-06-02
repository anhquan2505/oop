package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Created by huynq on 7/4/17.
 */

//
//        int[] array ={1,1,2,7};
//        int[] array2 = new int[5];// {0,0,0,0,0}
//        for (int i=0;i<array.length;i++){
//            System.out.println(array[i]);
//        }
//        for (int i=0;i<array2.length;i++){
//            System.out.println(array2[i]);
//        }
//        int i=0;
//        while (i<array.length){
//            System.out.println(array[i]);
//            i++;
//        }
public class Program {
    public static void main(String[] args) {
        JFrame window = new JFrame();
        //        ArrayList<String> strings = new ArrayList<>();
//        strings.add("hello");
//        strings.add("world");
//        System.out.println(strings);
//        System.out.println(strings.size());
//        for (int i = 0; i<strings.size();i++){
//            String element=strings.get(i);
//            System.out.println(element);
//        }
//        ArrayList<Vector2D> vectorS= new ArrayList<>();
//        vectorS.add(new Vector2D(0,0));
//
        //add(),remove(),get(),size()
        window.setTitle("Game Touhou");
        window.setResizable(false);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode()==KeyEvent.VK_UP){
                    KeyEventPress.IsUpPress=true;
                }
                if (e.getKeyCode()==KeyEvent.VK_LEFT){
                    KeyEventPress.IsLeftPress=true;
                }
                if (e.getKeyCode()==KeyEvent.VK_DOWN){
                    KeyEventPress.IsDownPress=true;
                }
                if (e.getKeyCode()==KeyEvent.VK_RIGHT){
                    KeyEventPress.IsRightPress=true;
                }
                if (e.getKeyCode()==KeyEvent.VK_SPACE){
                    KeyEventPress.IsFirePress =true;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode()==KeyEvent.VK_UP){
                    KeyEventPress.IsUpPress=false;
                }
                if (e.getKeyCode()==KeyEvent.VK_LEFT){
                    KeyEventPress.IsLeftPress=false;
                }
                if (e.getKeyCode()==KeyEvent.VK_DOWN){
                    KeyEventPress.IsDownPress=false;
                }
                if (e.getKeyCode()==KeyEvent.VK_RIGHT){
                    KeyEventPress.IsRightPress=false;
                }
                if (e.getKeyCode()==KeyEvent.VK_SPACE){
                    KeyEventPress.IsFirePress =false;
                }

            }
        });
        GamePanel panel = new GamePanel();
        panel.setBackground(Color.blue);
        window.add(panel);
        long timemili = System.currentTimeMillis();
        System.out.println(timemili / 60 / 60 / 24 / 1000 / 365);
        panel.setPreferredSize(new Dimension(Settings.GAME_WIDTH,Settings.GAME_HEIGH));
        window.pack();
        window.setVisible(true);
        panel.gameloop();// start game
//        alt enter : fix code
//        fn+shift+f6: rename
//        ctr alt L:format code
    }
}


