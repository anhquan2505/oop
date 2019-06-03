package game;

public class Vector2D {
    public double x;
    public double y;


    public Vector2D(){
        this(0,0);
    }
    public Vector2D(double X,double Y){
        this.x =X;
        this.y =Y;
    }


    public void add(double x, double y) {
        this.x += x;
        this.y += y;
    }

    public void substract(double x, double y) {
        this.x -= x;
        this.y -= y;
    }

    public void scale(double rate) {
        this.x *= rate;
        this.y *= rate;
    }

    public Vector2D clone() {
        return new Vector2D(x, y);
    }



    public void set(double X,double Y){
        this.x =X;
        this.y =Y;
    }

    public double getLength() {
        return Math.sqrt(x * x + y * y);
    }

    public void setLength(double Length) {
        double oldLength=this.getLength();
        if (oldLength!=0) {
            x = x * Length / oldLength;
            y = y * Length / oldLength;
        }
    }

    public double getAngle() {
        return Math.atan(y / x);
    }

    public void setAngle(double angle) {
        double Length = this.getLength();
        if (Length!=0) {
        x =Math.cos(angle)*Length;
        y =Math.sin(angle)*Length;
        }
    }

    public double getX() {
        return x;
    }

    @Override
    public String toString() {
        return
                "x=" + x +
                ", y=" + y
                ;
    }
}



