package game;

import game.physics.BoxCollider;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class GameObject {
    //quản lý đối tượng(static)
    public static ArrayList<GameObject> objects = new ArrayList<>();

    public static <E extends GameObject> E findIntersects(Class<E> cls, BoxCollider hitBox) {
//        E~
        //cls~
        //for(Gameobject) object:objects
        //object.active
        //object.hitbox = null
        //object.hitbox.intersect(hitbox)
        //object laf 1 doi tuong thuoc class cls
//        return objects
        //neu k return object thoa man thi return null
        for (int i = 0; i < objects.size(); i++) {
            GameObject object = objects.get(i);
            if (object.active &&
                    object.hitbox != null &&
                    object.hitbox.intersects(hitBox) &&
                    cls.isAssignableFrom(object.getClass())) {
                return (E) object;
            }
        }
        return null;
    }

    // find gameObject
    public static void renderAll(Graphics g) {
        for (int i = 0; i < objects.size(); i++) {
            GameObject object = objects.get(i);
            if (object.active) {
                object.render(g);
            }
        }
    }

    public static void runAll() {
        for (int i = 0; i < objects.size(); i++) {
            GameObject object = objects.get(i);
            if (object.active) {
                object.run();
            }
        }
    }

    //dinh nghia đối tượng
    public BufferedImage image;
    public Vector2D position, velocity;
    public BoxCollider hitbox;
    public boolean active;

    public GameObject() {
        objects.add(this);
        velocity = new Vector2D(0, 0);
        position = new Vector2D();
        active = true;

    }

    public void render(Graphics g) {
        if (image != null) {
            g.drawImage(image, (int) position.x, (int) position.y, null);
        }
    }

    public void run() {
        position.add(velocity.x, velocity.y);
    }

    public void deactive() {
        active = false;
    }

    public void reset() {
        active = true;
    }
}
