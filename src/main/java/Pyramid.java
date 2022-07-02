public class Pyramid implements IFigure{
    private Point3D p0;
    private int n;
    private Point3D[] p;

    public Pyramid(Point3D p0, Point3D[] p)
    {
        this.n = p.length + 1;
        this.p = new Point3D[this.n];
        this.p0 = new Point3D(new double[]{p0.getX(0), p0.getX(1), p0.getX(2)});
        this.p[0] = this.p0;
        for (int i = 1; i < this.n; i++) {
            this.p[i] = new Point3D(new double[]{p[i-1].getX(0), p[i-1].getX(1), p[i-1].getX(2)});
        }
    }

    public Pyramid(Point3D[] p)
    {

        this.n = p.length;
        this.p = new Point3D[this.n];
        this.p0 = new Point3D(new double[]{p[0].getX(0), p[0].getX(1), p[0].getX(2)});
        this.p[0] = this.p0;
        for (int i = 1; i < this.n; i++) {
            this.p[i] = new Point3D(new double[]{p[i].getX(0), p[i].getX(1), p[i].getX(2)});
        }
    }


    public int getN(){return this.n;}

    public Point3D[] getP()
    {
        Point3D[] p = new Point3D[this.n];

        for (int i = 0; i < this.n; i++)
        {
            p[i] = new Point3D(new double[]{this.p[i].getX(0), this.p[i].getX(1), this.p[i].getX(2)});
        }

        return p;
    }

    public Point3D getP(int i)
    {
        Point3D res = null;

        res = new Point3D(new double[]{this.p[i].getX(0), this.p[i].getX(1), this.p[i].getX(2)});

        return res;
    }


    public void setP(Point3D[] p)
    {

        this.n = p.length;
        this.p = new Point3D[this.n];
        this.p0 = new Point3D(new double[]{p[0].getX(0), p[0].getX(1), p[0].getX(2)});
        this.p[0] = this.p0;
        for (int i = 1; i < this.n; i++) {
            this.p[i] = new Point3D(new double[]{p[i].getX(0), p[i].getX(1), p[i].getX(2)});
        }
    }

    public void setP(Point3D p, int i)
    {

        this.p[i] = new Point3D(new double[]{p.getX(0), p.getX(1), p.getX(2)});
    }


    private double lengthVector3D(Point3D p1, Point3D p2)
    {
        return Math.sqrt((p1.getX(0) - p2.getX(0))*(p1.getX(0) - p2.getX(0)) +
                (p1.getX(1) - p2.getX(1))*(p1.getX(1) - p2.getX(1)) +
                (p1.getX(2) - p2.getX(2))*(p1.getX(2) - p2.getX(2)));
    }

    private double squareTriangle3D(Point3D p1, Point3D p2, Point3D p3)
    {
        double a = lengthVector3D(p1, p2);
        double b = lengthVector3D(p1, p3);
        double c = lengthVector3D(p2, p3);
        double p = (a+b+c) / 2;

        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    // Методы
    public  double square()
    {
        double res = 0;
        for (int i = 1; i < this.n-1; i++)
        {
            res += squareTriangle3D(this.p0, this.p[i], this.p[i+1]);
            if (i != 1)
            {
                res += squareTriangle3D(this.p[1], this.p[i], this.p[i+1]);
            }

        }

        res += squareTriangle3D(this.p0, this.p[this.n-1], this.p[1]);

        return res;
    }

    @Override
    public double volume() {
        double res=0;
        for (int i = 2; i < this.n-1; i++)
        {
            res += squareTriangle3D(this.p[1], this.p[i], this.p[i+1]);
        }

        double[] plane = PlaneEquation(this.p[1], this.p[2], this.p[3]);
        double h = DistancePointPlane(plane, this.p0);

        res = (res * h) / 3;

        return res;
    }
    public static double DistancePointPlane(double[] place, Point3D p0)
    {
        double res = 0;

        double a1 = Math.abs(place[0]*p0.getX(0) + place[1]*p0.getX(1) + place[2]*p0.getX(2) + place[3]);
        double a2 = Math.sqrt(place[0]*place[0] + place[1]*place[1] + place[2]*place[2]);
        res = a1 / a2;

        return res;
    }

    public static double[] PlaneEquation(Point3D p1, Point3D p2, Point3D p3)
    {
        double a = 0;
        double b = 0;
        double c = 0;
        double d = 0;

        // Вектор 1
        double a1 = p2.getX(0) - p1.getX(0);
        double b1 = p2.getX(1) - p1.getX(1);
        double c1 = p2.getX(2) - p1.getX(2);
        // Вектор 2
        double a2 = p3.getX(0) - p1.getX(0);
        double b2 = p3.getX(1) - p1.getX(1);
        double c2 = p3.getX(2) - p1.getX(2);

        // Посик коэффецентов уравнения плоскости
        a = b1 * c2 - b2 * c1;
        b = a2 * c1 - a1 * c2;
        c = a1 * b2 - b1 * a2;
        d = (- a * p1.getX(0) - b * p1.getX(1) - c * p1.getX(2));

        return new double[]{a, b, c, d};
    }

    public String toString()
    {
        String str = "";


        str = "Пирамида с координатами:\nВершина - [" + this.p[0].getX(0) + "; " + this.p[0].getX(1) + "; " + this.p[0].getX(2) + "]\n";
        for (int i = 1; i < this.n; i++){
            str += "[" + this.p[i].getX(0) + "; " + this.p[i].getX(1) + "; " + this.p[i].getX(2) + "]\n";
        }

        return  str;
    }
}
