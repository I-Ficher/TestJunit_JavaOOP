public class Prism implements IFigure{
    public int n;
    public Point3D[] p1;
    public Point3D[] p2;


    public Prism(Point3D[] p1, Point3D[] p2)
    {

        this.n = p1.length + p2.length;
        this.p1 = new Point3D[this.n/2];
        this.p2 = new Point3D[this.n/2];
        for (int i = 0; i < this.n/2; i++) {
            this.p1[i] = new Point3D(new double[]{p1[i].getX(0), p1[i].getX(1), p1[i].getX(2)});
            this.p2[i] = new Point3D(new double[]{p2[i].getX(0), p2[i].getX(1), p2[i].getX(2)});
        }
    }

    public Prism(Point3D[] p)
    {

        this.n = p.length;
        this.p1 = new Point3D[this.n/2];
        this.p2 = new Point3D[this.n/2];
        for (int i = 0; i < this.p1.length; i++) {
            this.p1[i] = new Point3D(new double[]{p[i].getX(0), p[i].getX(1), p[i].getX(2)});
            this.p2[i] = new Point3D(new double[]{p[this.n/2+i].getX(0), p[this.n/2+i].getX(1), p[this.n/2+i].getX(2)});
        }
    }

    // Геттеры
    public int getN(){return this.n;}

    public Point3D[] getP()
    {
        Point3D[] p = new Point3D[this.n];
        for (int i = 0; i < this.n/2; i++){
            p[i] = new Point3D(new double[]{this.p1[i].getX(0), this.p1[i].getX(1), this.p1[i].getX(2)});
            p[this.n/2+i] = new Point3D(new double[]{this.p2[i].getX(0), this.p2[i].getX(1), this.p2[i].getX(2)});
        }

        return p;
    }

    public Point3D getP(int i)
    {
        Point3D res = null;

        if (i >= this.n/2){
            i -= this.n/2;
            res = new Point3D(new double[]{this.p2[i].getX(0), this.p2[i].getX(1), this.p2[i].getX(2)});
        }
        else {
            res = new Point3D(new double[]{this.p1[i].getX(0), this.p1[i].getX(1), this.p1[i].getX(2)});
        }

        return res;
    }

    // Сеттеры
    public void setP(Point3D[] p)
    {
        this.n = p.length;
        this.p1 = new Point3D[this.n/2];
        this.p2 = new Point3D[this.n/2];
        for (int i = 0; i < this.p1.length; i++) {
            this.p1[i] = new Point3D(new double[]{p[i].getX(0), p[i].getX(1), p[i].getX(2)});
            this.p2[i] = new Point3D(new double[]{p[this.n/2+i].getX(0), p[this.n/2+i].getX(1), p[this.n/2+i].getX(2)});
        }
    }

    public void setP(Point3D p, int i)
    {
        if (i >= this.n/2){
            i -= this.n/2;
            this.p2[i] = new Point3D(new double[]{p.getX(0), p.getX(1), p.getX(2)});
        }
        else {
            this.p1[i] = new Point3D(new double[]{p.getX(0), p.getX(1), p.getX(2)});
        }
    }

    public double lengthVector3D(Point3D p1, Point3D p2)
    {
        return Math.sqrt((p1.getX(0) - p2.getX(0))*(p1.getX(0) - p2.getX(0)) +
                (p1.getX(1) - p2.getX(1))*(p1.getX(1) - p2.getX(1)) +
                (p1.getX(2) - p2.getX(2))*(p1.getX(2) - p2.getX(2)));
    }

    public double squareTriangle3D(Point3D p1, Point3D p2, Point3D p3)
    {
        double a = lengthVector3D(p1, p2);
        double b = lengthVector3D(p1, p3);
        double c = lengthVector3D(p2, p3);
        double p = (a+b+c) / 2;

        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    public  double square()
    {
        double res = 0;
        res += squareTriangle3D(this.p2[0], this.p1[0], this.p1[1]);
        res += squareTriangle3D(this.p2[0], this.p2[1], this.p1[1]);
        for (int i = 1; i < this.n/2 - 1; i++)
        {
            res += squareTriangle3D(this.p1[0], this.p1[i], this.p1[i+1]);
            res += squareTriangle3D(this.p2[0], this.p2[i], this.p2[i+1]);
            res += squareTriangle3D(this.p2[i], this.p1[i], this.p1[i+1]);
            res += squareTriangle3D(this.p2[i], this.p2[i+1], this.p1[i+1]);
        }

        res += squareTriangle3D(this.p2[this.n/2 - 1], this.p1[this.n/2 - 1], this.p1[0]);
        res += squareTriangle3D(this.p2[this.n/2 - 1], this.p2[0], this.p1[0]);

        return res;
    }


    public double volume()
    {
        double res = 0;

        for (int i = 1; i < this.n/2 - 1; i++)
        {
            res += squareTriangle3D(this.p1[0], this.p1[i], this.p1[i + 1]);
        }

        double[] plane1 = PlaneEquation(this.p1[0], this.p1[1], this.p1[2]);
        double[] plane2 = PlaneEquation(this.p2[0], this.p2[1], this.p2[2]);
        double h = DistanceParallelPlanePlane(plane1, plane2);

        res = res * h;

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
    public static double DistanceParallelPlanePlane(double[] place1, double[] place2)
    {
        double res = 0;

        double a1 = Math.abs(place2[3] - place1[3]);
        double a2 = Math.sqrt(place1[0]*place1[0] + place1[1]*place1[1] + place1[2]*place1[2]);
        res = a1 / a2;

        return res;
    }
    @Override
    public String toString()
    {
        String str = "";

        boolean flag = false;
        if (this.p1 == null || this.p2 == null){
            flag = true;
        }
        else {
            for (int i = 0; i < this.n/2; i++){
                if (this.p1[i] == null || this.p2[i] == null ) {
                    flag = true;
                    break;
                }
            }
        }

        str = "Призма с координатами:\nНижнее основание - ";
        for (int i = 0; i < this.n/2; i++){
            str += "[" + this.p1[i].getX(0) + "; " + this.p1[i].getX(1) + "; " + this.p1[i].getX(2) + "] ";
        }
        str += "\nВерхнее основание - ";
        for (int i = 0; i < this.n/2; i++){
            str += "[" + this.p2[i].getX(0) + "; " + this.p2[i].getX(1) + "; " + this.p2[i].getX(2) + "] ";
        }

        return  str;
    }
}
