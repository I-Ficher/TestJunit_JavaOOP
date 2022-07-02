public class Point {
    int dim;
    double x[];

    public Point(int dim){
        this.dim=dim;
    }
    public Point(int dim,double x[]){
        this.dim=dim;
        this.x=x;
    }


    int getDim(){
        return x.length;
    }

    public double[] getX(){
        return x;
    }

    public double getX(int i){
        return x[i];
    }

    public void setX(double[] x){
        this.x=x;
    }

    public void setX(double x,int i){
        this.x[i]=x;
    }

    double abs(){
        double abslo=0;
        for(int i=0;i<dim;i++)
        {
            abslo+=Math.pow(x[i],2);
        }
        return Math.sqrt(abslo);
    }

    static Point add(Point a,Point b){
        Point z=new Point(a.getDim());
        double y[] = new double[a.getDim()];
        for(int i=0;i<a.getDim();i++){
            y[i] = a.getX(i)+b.getX(i);
        }
        z.setX(y);
        return z;
    }

    Point add(Point b){
        Point z=new Point(b.getDim());
        double y[] = this.x;
        for(int i=0;i<b.getDim();i++){
            y[i] +=b.getX(i);
        }
        z.setX(y);
        return z;
    }

    static Point sub(Point a,Point b){
        Point z=new Point(a.getDim());
        double y[] = new double[a.getDim()];
        for(int i=0;i<a.getDim();i++){
            y[i] = a.getX(i)-b.getX(i);
        }
        z.setX(y);
        return z;
    }

    Point sub(Point b){
        Point z=new Point(b.getDim());
        double y[] = this.x;
        for(int i=0;i<b.getDim();i++){
            y[i] -=b.getX(i);
        }
        z.setX(y);
        return z;
    }

    static Point mult(Point a,double r){
        Point z=new Point(a.getDim());
        double y[] = new double[a.getDim()];
        for(int i=0;i<a.getDim();i++){
            y[i] = r*a.getX(i);
        }
        z.setX(y);
        return z;
    }

    Point mult(double r){
        Point z=new Point(this.dim,this.x);
        double y[] = new double[z.getDim()];
        for(int i=0;i<z.getDim();i++){
            y[i] = r*z.getX(i);
        }
        z.setX(y);
        return z;
    }

    /*static double mult(Point a,Point b){
        a.getX(0) * b.getX(0) + a.getX(1) * b.getX(1) +a.getX(2) * b.getX(2);
        Point z=new Point(a.getDim());
        double p[] = new double[a.getDim()];
        double y=0;
        for(int i=0;i<a.getDim();i++){
            y = a.getX(i)*b.getX(i);
            z.setX(p,y);
        }
        return y;
    }*/

    double mult(Point b){
        double res = 0;

        for (int i = 0; i < this.dim; i++)
        {
            res += this.x[i] * b.x[i];
        }

        return res;
    }

    public static double mult(Point a, Point b)
    {
        double res = 0;

        for (int i = 0; i < a.dim; i++)
        {
            res += a.x[i] * b.x[i];
        }

        return res;
    }

    public static Point SymAxis(Point a,int i){

        Point c = new Point(a.getDim());
        for(int j = 0; j < a.getDim(); j++)
        {
            if (i != j)
                c.x[j] = - a.x[j];
            else
                c.x[j] = a.x[j];
        }
        return c;
    }

    Point SymAxis(int i){
        for (int j = 0; j < this.dim; j++)
        {
            if (j != i){
                this.x[j] *= -1;
            }
        }

        return this;
    }

    public String toString()
    {
        String result = new String();

        result += "{";

        for (int i = 0; i < dim - 1; ++i)
        {
            result+= String.valueOf(x[i]);
            result+= ", ";
        }

        result += String.valueOf(x[dim-1]);
        result += "}";

        return result;
    }

}
