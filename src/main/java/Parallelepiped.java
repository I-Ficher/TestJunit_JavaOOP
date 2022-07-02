public class Parallelepiped extends Prism{
    public Parallelepiped(Point3D[] p){
        super(p);
    }

    @Override
    public double volume()
    {

        double res = 0;

        for (int i = 1; i < this.getN()/2 - 1; i++) {
            res += squareTriangle3D(this.getP(0), this.getP(i), this.getP(i+1));
        }

        double[] plane1 = PlaneEquation(this.getP(0), this.getP(1), this.getP(2));
        double[] plane2 = PlaneEquation(this.getP(this.getN()/2), this.getP(this.getN()/2+1), this.getP(this.getN()/2+2));
        double h = DistanceParallelPlanePlane(plane1, plane2);
        res = res * h;

        return res;
    }

    @Override
    public String toString()
    {
        String str = "";

        boolean flag = false;
        if (this.getP() == null){
            flag = true;
        }
        else {
            for (int i = 0; i < this.getN(); i++){
                if (this.getP(i) == null) {
                    flag = true;
                    break;
                }
            }
        }

        str = "Параллелепипед с координатами:\n";
        for (int i = 0; i < this.getN(); i++){
            str += "[" + this.getP(i).getX(0) + "; " + this.getP(i).getX(1) + "; " + this.getP(i).getX(2) + "]\n";
        }

        return  str;
    }
}
