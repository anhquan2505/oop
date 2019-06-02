package game;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class GameObject {
    //quản lý đối tượng(static)
    public static ArrayList<GameObject> objects=new ArrayList<>();
    // find gameObject
    public static void renderAll(Graphics g){
        for (int i=0;i<objects.size();i++){
            GameObject object = objects.get(i);
            object.render(g);
        }
    }
    public static void runAll(){
        for(int i=0;i<objects.size();i++){
            GameObject object = objects.get(i);
            object.run();
        }
    }
    //dinh nghia đối tượng
    public BufferedImage image;
    public Vector2D position;
    public GameObject(){
        objects.add(this);
        
        position = new Vector2D();
    }
    public void render(Graphics g){
        if (image!=null){
            g.drawImage(image,(int)position.x,(int)position.y,null);
        }
    }
    public void run(){

    }
}
