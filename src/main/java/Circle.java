public class Circle implements IShape{
    public Point2D p;
    public double r;

    Circle(Point2D p,double r){
        this.p=p;
        this.r=r;
    }

    Point2D getP(){
        return p;
    }

    void setP(Point2D p){
        this.p=p;
    }

    double getR(){
        return r;
    }

    void setR(double r){
        this.r=r;
    }

    public double square(){
        double s=Math.PI * Math.pow(r,2);
        return s;
    }


    public double length(){
        double p=2*r*Math.PI;
        return p;
    }

    public Circle shift(Point2D a){
        p.x[0]= p.x[0]+a.x[0];
        p.x[1]= p.x[1]+a.x[1];
        return this;
    }

    public Circle rot(double phi){
        double ugol=phi*(Math.PI/180);
        double x0,y0;
        x0 = p.x[0] * Math.cos(ugol) - p.x[1] * Math.sin(ugol);
        y0 = p.x[0] * Math.sin(ugol) + p.x[1] * Math.cos(ugol);
        p.x[0]=x0;
        p.x[1]=y0;
        return this;
    }

    @Override
    public Circle symAxis(int i) {
        Point2D p = null;

        p = new Point2D(Point.SymAxis(this.p, i).getX());

        return new Circle(p, this.r);
    }

    @Override
    public boolean cross(IShape i){
        boolean res = false;


        if (i instanceof Circle circle){
            double lenCenter = Math.sqrt((this.p.getX(0) - circle.p.getX(0))*(this.p.getX(0) - circle.p.getX(0)) +
                    (this.p.getX(1) - circle.p.getX(1))*(this.p.getX(1) - circle.p.getX(1)));
            double plusR = Math.abs(this.r + circle.r);
            double minusR = Math.abs(this.r - circle.r);
            if (plusR >= lenCenter && lenCenter >= minusR){
                res = true;
            }
        }

        return res;
    }
    @Override
    public String toString()
    {
        String result = new String();
        for(int i=0;i<p.dim;i++){
            result+=String.valueOf(p.x[i]);
            result+=", ";

        }
        result+=r;

        return result;
    }


}
