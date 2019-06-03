package game.physics;

import game.GameObject;
import game.Vector2D;

public class BoxCollider {
    public Vector2D position;
    public int width;
    public int height;

    public BoxCollider(GameObject master, int width, int height) {
        this.position = master.position;
        this.width = width;
        this.height = height;
    }

    public double top() {
        return position.y;
    }

    public double bot() {
        return top() + height;
    }

    public double left() {
        return position.x;
    }

    public double right() {
        return left() + width;
    }

    public boolean intersects(BoxCollider other) {
        return this.right() >= other.left() &&
                this.left() <= other.right()
                && this.bot() >= other.top()
                && this.top() <= other.bot();
    }
}
