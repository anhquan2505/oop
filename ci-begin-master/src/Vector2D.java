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

    //    public static void main(String[] args) {
//        Vector2D v1 = new Vector2D(3,3);
//        System.out.println(v1.getLength()+ " "+Math.sqrt(18));
//        System.out.println(v1.getAngle()+" "+(Math.PI / 4));
//        v1.setLength(10);
//        System.out.println(v1.getLength()+" "+10);
//        v1.setAngle(Math.PI / 6);
//        System.out.println(v1.getAngle()+" "+ (Math.PI / 6));
//    }
}


//this để trỏ đến phương thức
