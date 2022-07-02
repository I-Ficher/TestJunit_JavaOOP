public class NGon implements IPolyPoint,IShape{

    public int n;
    public Point2D[] p;

    public NGon(Point2D[] p){
        this.p=p;
        n= p.length;
    }

    public int getN() {
        return n;
    }

    public Point2D[] getP(){
        return p;
    }


    public Point2D getP(int i) {
        return p[i];
    }

    public void setP(Point2D p, int i) {
        this.p[i]=p;
    }

    @Override
    public double length() {
        return 0;
    }

    public double square(){

        double res=0;
        for (int i = 0; i < n-1; i++){
            res += (p[i].getX(0)+p[i+1].getX(0))*(p[i].getX(1)-p[i+1].getX(1));
        }
        res += (p[n-1].getX(0)+p[0].getX(0))*(p[n-1].getX(1)-p[0].getX(1));

        return Math.abs(res) / 2;
    }

    @Override
    public boolean cross(IShape i) {
        boolean res = false;
        if (i instanceof NGon nGon){
            for (int j = 0; j < nGon.getN()-1; j++){
                Point2D p1 = nGon.getP(j);
                Point2D p2 = nGon.getP(j+1);
                for (int k = 0; k < this.n-1; k++){
                    res = Cross.checkIntersectionOfTwoLineSegments(this.p[k], this.p[k+1], p1, p2);
                    if (res){
                        break;
                    }
                }
                if (!res) {
                    res = Cross.checkIntersectionOfTwoLineSegments(this.p[this.n - 1], this.p[0], p1, p2);
                }
                else {
                    break;
                }
            }
            if (!res) {
                Point2D p1 = nGon.getP(nGon.getN() - 1);
                Point2D p2 = nGon.getP(0);
                for (int k = 0; k < this.n - 1; k++) {
                    res = Cross.checkIntersectionOfTwoLineSegments(this.p[k], this.p[k + 1], p1, p2);
                    if (res) {
                        break;
                    }
                }
                if (!res) {
                    res = Cross.checkIntersectionOfTwoLineSegments(this.p[this.n - 1], this.p[0], p1, p2);
                }
            }
        }
        return res;
    }

    public double lenght(){
        double res=0;
        for (int i = 0; i < this.n - 1; i++) {
            Point N = Point2D.sub(this.p[i], this.p[i+1]);
            res += Math.sqrt(N.getX(0)*N.getX(0) + N.getX(1)*N.getX(1));
        }
        Point N = Point2D.sub(this.p[this.n - 1], this.p[0]);
        res += Math.sqrt(N.getX(0)*N.getX(0) + N.getX(1)*N.getX(1));
        return res;
    }

    public NGon shift(Point2D a) {
        Point2D[] p = null;
        p = new Point2D[this.n];
        for (int i = 0; i < this.n; i++)
        {
            p[i] = new Point2D(Point.add(this.p[i], a).getX());
        }

        return new NGon(p);
    }
    public NGon rot(double phi)
    {
        Point2D[] p = new Point2D[this.n];
        double ugol=phi*(Math.PI/180);
        for (int i = 0; i < this.n; i++)
        {
            p[i] = Point2D.rot(this.p[i], ugol);
        }

        return new NGon(p);
    }
    public NGon symAxis(int i){
        Point2D[] p = new Point2D[this.n];
        for (int j = 0; j < this.n; j++) {
            p[j] = new Point2D(Point.SymAxis(this.p[j], i).getX());
        }

        return new NGon(p);
    }

    @Override
    public String toString() {
        String str = "";

        boolean flag = false;
        if (this.p == null){
            flag = true;
        }
        else {
            for (int i = 0; i < this.n; i++){
                if (this.p[i] == null) {
                    flag = true;
                    break;
                }
            }
        }

        for (int i = 0; i < this.n; i++){
            str += "[" + this.p[i].getX(0) + "; " + this.p[i].getX(1) + "]\n";
        }

        return  str;
    }
}
