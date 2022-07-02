public class Point2D extends Point{
    public Point2D()
    {
        super(2);
    }

    public Point2D(double[] x)
    {
        super(2,x);

    }

    public Point2D(double x, double y)
    {
        super(2);
        this.x[0] = x;
        this.x[1] = y;
    }


    public static Point2D rot(Point2D p, double phi)
    {
        Point2D n = new Point2D();

        n.x[0] = p.x[0] * Math.cos(phi) - p.x[1] * Math.sin(phi);
        n.x[1] = p.x[0] * Math.sin(phi) + p.x[1] * Math.cos(phi);
        return n;
    }

    public Point2D rot(double phi)
    {

        double tx0 = x[0] * Math.cos(phi) + x[1] * Math.sin(phi);
        double tx1 = x[0] * -Math.sin(phi) + x[1] * Math.cos(phi);
        x[0] = tx0;
        x[1] = tx1;

        return this;
    }



}
