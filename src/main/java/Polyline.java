public class Polyline extends OpenFigure implements IPolyPoint {
    int n;
    Point2D[] p;
    Polyline(Point2D[] p){
        this.p=p;
        n= p.length;
    }

    public int getN(){
        return n;
    }

    Point2D[] getP(){
        return p;
    }

    public Point2D getP(int i){
        return p[i];
    }

    void setP(Point2D[] p){
        this.p=p;
    }

    public void setN(int n){
        this.n=n;
    }

    public void setP(Point2D p, int i) {
        this.p[i]=p;
    }

    public Polyline shift(Point2D a)
    {
        Point2D[] p = new Point2D[this.n];


        for (int i = 0; i < this.n; i++) {
            p[i] = new Point2D(Point.add(this.p[i], a).getX());
        }

        return new Polyline(p);
    }

    public Polyline rot(double phi)
    {
        Point2D[] p = null;


        p = new Point2D[this.n];
        for (int i = 0; i < this.n; i++) {
            p[i] = Point2D.rot(this.p[i], phi);
        }

        return new Polyline(p);
    }

    public Polyline symAxis(int i)
    {
        for (int j = 0; j < n; j++)
            p[j].SymAxis(i);
        return this;
    }

    public double length(){
        /*double result = Math.sqrt(Math.pow(finish.x[0] - start.x[0],2)+Math.pow(finish.x[1] - start.x[1],2));*/
        double result=0;
        for(int i=0;i<n;i++){
            if (i!=n-1) {
                result = Math.sqrt(Math.pow(p[i].x[0] - p[i + 1].x[0], 2) + Math.pow(p[i].x[1] - p[i + 1].x[1], 2));
            }
        }
        return result;
    }

    @Override
    public boolean cross(IShape i) {
        boolean res=false;        //проверим существование потенциального интервала для точки пересечения отрезков


        if(i instanceof Polyline polyline){
            for (int j = 0; j < polyline.getN()-1; j++){
                Point2D p1 = polyline.getP(j);
                Point2D p2 = polyline.getP(j+1);
                for (int k = 0; k < this.n-1; k++){
                    res = Cross.checkIntersectionOfTwoLineSegments(this.p[k], this.p[k+1], p1, p2);
                    if (res){
                        break;
                    }
                }
                if (res){
                    break;
                }
            }
            /*for(int j=1;j<this.n;j++){
                for (int z=1;z<polyline.n;z++){
                    if(this.p[j-1].getX(0)==this.p[j].getX(0) && polyline.p[z-1].getX(0)==polyline.p[z].getX(0)){
                        if(this.p[j-1].getX(0) != polyline.p[z-1].getX(0)){
                            return res;
                        }
                        if(Math.min(this.p[j-1].getX(1),this.p[j].getX(1))<Math.min(polyline.p[z-1].getX(1),polyline.p[z].getX(1))){
                            return Math.max(this.p[j-1].getX(1),this.p[j].getX(1))>=Math.min(polyline.p[z-1].getX(1),polyline.p[z].getX(1));
                        }
                        else{
                            return Math.max(polyline.p[z-1].getX(1),polyline.p[z].getX(1))>=Math.min(this.p[j-1].getX(1),this.p[j].getX(1));
                        }

                    }
                    if(this.p[j-1].getX(0)==this.p[j].getX(0)){
                        double a34=(polyline.p[z].getX(1)-polyline.p[z-1].getX(1))/(polyline.p[z].getX(0)-polyline.p[z-1].getX(0));
                        double b34=polyline.p[z-1].getX(1)-a34*polyline.p[z-1].getX(0);
                        double y=a34*this.p[j-1].getX(0)+b34;
                        return y>=Math.min(this.p[j-1].getX(1),this.p[j].getX(1)) &&y<=Math.max(this.p[j-1].getX(1),this.p[j].getX(1))&&this.p[j-1].getX(0)>=Math.min(polyline.p[z-1].getX(0),polyline.p[z].getX(0))&&this.p[j-1].getX(0)<=Math.max(polyline.p[z-1].getX(0),polyline.p[z].getX(0));
                    }
                    if(polyline.p[z-1].getX(0)==polyline.p[z].getX(0)){
                        double a12=(this.p[j].getX(1)-this.p[j-1].getX(1))/(this.p[j].getX(0)-this.p[j-1].getX(0));
                        double b12=this.p[j-1].getX(1)-a12*this.p[j-1].getX(0);
                        double y=a12*polyline.p[z-1].getX(0)+b12;
                        return y>=Math.min(polyline.p[z-1].getX(1),polyline.p[z].getX(1)) &&y<=Math.max(polyline.p[z-1].getX(1),polyline.p[z].getX(1))&&polyline.p[z-1].getX(0)>=Math.min(this.p[j-1].getX(0),this.p[j].getX(0))&&polyline.p[z-1].getX(0)<=Math.max(this.p[j-1].getX(0),this.p[j].getX(0));
                    }
                    double a12=(this.p[j].getX(1)-this.p[j-1].getX(1))/(this.p[j].getX(0)-this.p[j-1].getX(0));
                    double b12=this.p[j-1].getX(1)-a12*this.p[j-1].getX(0);
                    double a34=(polyline.p[z].getX(1)-polyline.p[z-1].getX(1))/(polyline.p[z].getX(0)-polyline.p[z-1].getX(0));
                    double b34=polyline.p[z-1].getX(1)-a34*polyline.p[z-1].getX(0);
                    if(closeToZero(a12-a34)){
                        return closeToZero(b12-b34);
                    }
                    double x = -(b12-b34)/(a12-a34);
                    return x >= Math.min(this.p[j-1].getX(0),this.p[j].getX(0)) && x <= Math.max(this.p[j-1].getX(0),this.p[j].getX(0)) && x >= Math.min(polyline.p[z-1].getX(0),polyline.p[z].getX(0)) && x <= Math.max(polyline.p[z-1].getX(0),polyline.p[z].getX(0));
                    }
                }*/
            }
        return res;
    }

    boolean closeToZero(double v) {
        // Check if double is close to zero, considering precision issues.
        return Math.abs(v) <= 0.0000000000001;
    }

    @Override
    public String toString()
    {
        String str = "";

        for (int i = 0; i < this.n; i++)
        {
            str += "[" + this.p[i].getX(0) + "; " + this.p[i].getX(1) + "]\n";
        }

        return  str;
    }
}
