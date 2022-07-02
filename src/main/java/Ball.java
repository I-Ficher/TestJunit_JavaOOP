public class Ball implements IFigure{
    private Point3D p;
    private double r;


    public Ball (Point3D p, double r)
    {
        this.p = new Point3D(new double[]{p.getX(0), p.getX(1), p.getX(2)});
        this.r = r;
    }


    public Point3D getP() {return new Point3D(new double[]{this.p.getX(0), p.getX(1), p.getX(2)});}
    public double getR() {return this.r;}


    public void setP(Point3D p)
    {
        this.p = new Point3D(new double[]{p.getX(0), p.getX(1), p.getX(2)});
    }

    public void setR(double r) {this.r = r;}


    public double square()
    {
        return 4 * Math.PI * this.r*this.r;
    }

    public double volume()
    {
        return (4 * Math.PI * this.r*this.r*this.r) / 3;
    }

    @Override
    public String toString()
    {
        String str = "";
        str = "Шар:\nРадиус = " + this.r + "\nЦентр шара = [" + this.p.getX(0) +"; " + this.p.getX(1) +"; " + this.p.getX(2) + "]";

        return  str;
    }
}
