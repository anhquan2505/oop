package game;

public class Vector2D {
    public double X;
    public double Y;
    public double rate;

    public Vector2D(){
        this(0,0);
    }
    public Vector2D(double X,double Y){
        this.X=X;
        this.Y=Y;
    }
    public void add(double X,double Y){
        this.X+=X;
        this.Y+=Y;

    }
    public void subtract(double X,double Y){
        this.X-=X;
        this.Y-=Y;
    }
    public void scale(double rate){
        this.X *=rate;
        this.Y *=rate;

    }
    public Vector2D clone(){
        return new Vector2D(X,Y);
    }
    public void set(double X,double Y){
        this.X=X;
        this.Y=Y;
    }

    public double getLength() {
        return Math.sqrt(X*X+Y*Y);
    }

    public void setLength(double Length) {
        double oldLength=this.getLength();
        if (oldLength!=0) {
            X = X * Length / oldLength;
            Y = Y * Length / oldLength;
        }
    }

    public double getAngle() {
        return Math.atan(Y/X);
    }

    public void setAngle(double angle) {
        double Length = this.getLength();
        if (Length!=0) {
        X=Math.cos(angle)*Length;
        Y=Math.sin(angle)*Length;
        }
    }

    public double getX() {
        return X;
    }

    @Override
    public String toString() {
        return
                "X=" + X +
                ", Y=" + Y
                ;
    }
}


//this để trỏ đến phương thức
