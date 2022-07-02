public class Point3D extends Point{
    Point3D() {
        super(3);
    }
    Point3D(double[] x){
        super(3, x);
    }
    static Point3D cross_prod(Point3D p1,Point3D p2){
        Point3D point3D=new Point3D();
        point3D.setX(p1.getX(1)*p2.getX(2) - p1.getX(2)*p2.getX(1), 0);
        point3D.setX(p1.getX(2)*p2.getX(0) - p1.getX(0)*p2.getX(2), 1);
        point3D.setX(p1.getX(0)*p2.getX(1) - p1.getX(1)*p2.getX(0), 2);

        return point3D;
    }

    Point3D cross_prod(Point3D p){
        double x = this.getX(0);
        double y = this.getX(1);
        double z = this.getX(2);
        this.setX(y*p.getX(2) - z*p.getX(1), 0);
        this.setX(z*p.getX(0) - x*p.getX(2), 1);
        this.setX(x*p.getX(1) - y*p.getX(0), 2);

        return this;
    }

    static double mix_prod(Point3D p1,Point3D p2,Point3D p3){

        double res = 0;

        res = mult(p1, p2.cross_prod(p3));

        return res;
    }

    double mix_prod(Point3D p1,Point3D p2){
        double res = 0;

        res = mult(this, cross_prod(p1, p2));

        return res;
    }
}
