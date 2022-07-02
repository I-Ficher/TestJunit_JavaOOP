public class Rectangle extends QGon{

    public Rectangle(Point2D[] p) {
        super(p);
    }
    public double square(){
        double res = 0;
        res = new Segment(this.getP(0), this.getP(1)).length() * new Segment(this.getP(1), this.getP(2)).length();

        return res;
    }
}
