public class QGon extends NGon{

    public QGon(Point2D[] p) {
        super(p);
    }

    public double Square(){
        double res = 0;

        for (int i = 0; i < 3; i++){
            res += (this.getP(i).getX(0) + this.getP(i+1).getX(0)) * (this.getP(i).getX(1) - this.getP(i+1).getX(1));
        }
        res += (this.getP(this.getN()-1).getX(0) + this.getP(0).getX(0)) * (this.getP(this.getN()-1).getX(1) - this.getP(0).getX(1));
        res = Math.abs(res) / 2;

        return res;
    }
}
