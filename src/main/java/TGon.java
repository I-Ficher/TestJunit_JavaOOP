public class TGon extends NGon{
    public TGon(Point2D[] p) {
        super(p);
    }

    public double square() {
        double res = 0;
        double a = (new Segment(this.getP(0), this.getP(1))).length();
        double b = (new Segment(this.getP(1), this.getP(2))).length();
        double c = (new Segment(this.getP(2), this.getP(0))).length();
        double p = (a+b+c) / 2;
        res = Math.sqrt(p * (p - a) * (p - b) * (p - c));
        /*формула герона*/

        return res;
    }
}
