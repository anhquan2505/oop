
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

/**
 * Created by huynq on 7/4/17.
 */

//public class Program {
//    public static double[] ptb2(double a, double b,double c) {
//        if (a == 0) {
//            if (b == 0) {
//                return null;
//            } else {
//                double[] result = {-b / c, -b / c};
//                return result;
//            }
//        } else {
//            double denta = b * b - 4 * a * c;
//            if (denta >= 0) {
//                double[] result = new double[2];
//                result[0] = (-b + Math.sqrt(denta)) / (2 * a);
//                result[1] = (-b - Math.sqrt(denta)) / (2 * a);
//                return result;
//            } else {
//                return null;
//            }
//        }
//    }
//    public static void sumAndPrint(double a, double b){
//        System.out.println(a+b);

//    public static void main(String[] args) {
//        student st1 = new student();
//        student st2 = new student("Tran Van vu",11);
//
//        System.out.println(st1.name);
//        st1.eat();
//        System.out.println(st2.name);
//        st2.sleep();
//            double []result=ptb2(1,2,1);
//            if(result==null){
//                System.out.println("Đ có nghiệm");
//            }
//            else{
//                System.out.println("x1="+result[0]+" x2= "+result[1]);
//            }


//        String message = "hello world";
//        int x =1;//byte, short, int, long
//        double b=2; //lon hon float
//        char c = 'x'; //120
//        boolean bool=true;
//        System.out.println(message);
//        System.out.println(x);
//        System.out.println(b+c);//2+120
//        System.out.println(bool);
//        System.out.println(message+b);
//        int a=1;
//        double b; // mac dinh tat ca cac so neu k khai bao thi gan = o
//        boolean c;// =false
//        String s;//=null
//        System.out.println(a);
//        System.out.println(b);
//        System.out.println(sum(2,5));
//
//        double sum =sum(10,111);
//        System.out.println(sum);
//    }

//        int random=11111;
//        if (random>10000){
//            System.out.println("number too large"); }
//        else if(random<10){
//            System.out.println("number too small");
//        }
//        else{
//            System.out.println("this is number: "+random);
//        }
//        switch (random){
//            case 11111: {
//                System.out.println("number is 11111!");
//                break;
//            }
//            case 1:{
//                System.out.println("number is 1!");
//                break;
//            }
//        }
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
        window.setTitle("Game Touhou");
//        window.setSize(800, 600); //px
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

            }
        });
        gamepanel panel = new gamepanel();
        panel.setBackground(Color.blue);
        window.add(panel);
//        BufferedImage playerImage = SpriteUtils.loadImage("assets/images/players/straight/0.png");
//        System.out.println(playerImage.getWidth());
//        System.out.println(playerImage.getHeight());
        long timemili = System.currentTimeMillis();
        System.out.println(timemili / 60 / 60 / 24 / 1000 / 365);

        panel.setPreferredSize(new Dimension(800,600));
        window.pack();
        window.setVisible(true);

        panel.gameloop();// start game
        //alt enter : fix code
        //fn+shift+f6: rename
        //ctr alt L:format code


//        btvn làm với con enemies
    }
}
//    }

