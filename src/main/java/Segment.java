import javax.swing.text.Utilities;
import java.util.*;

public class Segment extends OpenFigure{
    Point2D start=new Point2D();
    Point2D finish=new Point2D();

    public Segment(Point2D s,Point2D f){
        start=s;
        finish=f;
    }

    Point2D getStart(){
        return start;
    }
    void setStart(Point2D a){
        this.start=a;
    }

    Point2D getFinish(){
        return finish;
    }

    void  setFinish(Point2D a){
        this.finish=a;
    }

    public double length(){
       double result = Math.sqrt(Math.pow(finish.x[0] - start.x[0],2)+Math.pow(finish.x[1] - start.x[1],2));
       return result;
    }



    public Segment shift(Point2D a){
        start.x[0]= start.x[0]+a.x[0];
        start.x[1]= start.x[1]+a.x[1];
        finish.x[0]= finish.x[0]+a.x[0];
        finish.x[1]= finish.x[1]+a.x[1];
        return this;
    }

    public Segment rot(double phi)
    {
        double ugol=phi*(Math.PI/180);
        double x0,y0,x1,y1;
        x0 = start.x[0] * Math.cos(ugol) - start.x[1] * Math.sin(ugol);
        y0 = start.x[0] * Math.sin(ugol) + start.x[1] * Math.cos(ugol);
        x1 = finish.x[0] * Math.cos(ugol) - finish.x[1] * Math.sin(ugol);
        y1 = finish.x[0] * Math.sin(ugol) + finish.x[1] * Math.cos(ugol);
        start.x[0]=x0;
        start.x[1]=y0;
        finish.x[0]=x1;
        finish.x[1]=y1;
        return this;
    }

    public Segment symAxis(int i){

        switch (i){
            case 0:
                start.x[0]=start.x[0];
                start.x[1]=-start.x[1];
                finish.x[0]=finish.x[0];
                finish.x[1]=-finish.x[1];
                break;
            case 1:
                start.x[0]=-start.x[0];
                start.x[1]=start.x[1];
                finish.x[0]=-finish.x[0];
                finish.x[1]=finish.x[1];
                break;
            case 2:
                start.x[0]=-start.x[0];
                start.x[1]=-start.x[1];
                finish.x[0]=-finish.x[0];
                finish.x[1]=-finish.x[1];
                break;
        }
        return this;
    }


    public boolean cross(IShape i){

        boolean res=false;        //проверим существование потенциального интервала для точки пересечения отрезков


        if(i instanceof Segment segment){
            Point2D p1 = segment.getStart();
            Point2D p2 = segment.getFinish();
            res = Cross.checkIntersectionOfTwoLineSegments(this.start, this.finish, p1, p2);
        }
            /*if(this.start.getX(0)==this.finish.getX(0) && segment.start.getX(0)==segment.finish.getX(0)){
                if(this.start.getX(0) != segment.start.getX(0)){
                    return res;
                }
                if(Math.min(this.start.getX(1),this.finish.getX(1))<Math.min(segment.start.getX(1),segment.finish.getX(1))){
                    return Math.max(this.start.getX(1),this.finish.getX(1))>=Math.min(segment.start.getX(1),segment.finish.getX(1));
                }
                else{
                    return Math.max(segment.start.getX(1),segment.finish.getX(1))>=Math.min(this.start.getX(1),this.finish.getX(1));
                }

            }
            if(this.start.getX(0)==this.finish.getX(0)){
                double a34=(segment.finish.getX(1)-segment.start.getX(1))/(segment.finish.getX(0)-segment.start.getX(0));
                double b34=segment.start.getX(1)-a34*segment.start.getX(0);
                double y=a34*this.start.getX(0)+b34;
                return y>=Math.min(this.start.getX(1),this.finish.getX(1)) &&y<=Math.max(this.start.getX(1),this.finish.getX(1))&&this.start.getX(0)>=Math.min(segment.start.getX(0),segment.finish.getX(0))&&this.start.getX(0)<=Math.max(segment.start.getX(0),segment.finish.getX(0));
            }
            if(segment.start.getX(0)==segment.finish.getX(0)){
                double a12=(this.finish.getX(1)-this.start.getX(1))/(this.finish.getX(0)-this.start.getX(0));
                double b12=this.start.getX(1)-a12*this.start.getX(0);
                double y=a12*segment.start.getX(0)+b12;
                return y>=Math.min(segment.start.getX(1),segment.finish.getX(1)) &&y<=Math.max(segment.start.getX(1),segment.finish.getX(1))&&segment.start.getX(0)>=Math.min(this.start.getX(0),this.finish.getX(0))&&segment.start.getX(0)<=Math.max(this.start.getX(0),this.finish.getX(0));
            }
            double a12=(this.finish.getX(1)-this.start.getX(1))/(this.finish.getX(0)-this.start.getX(0));
            double b12=this.start.getX(1)-a12*this.start.getX(0);
            double a34=(segment.finish.getX(1)-segment.start.getX(1))/(segment.finish.getX(0)-segment.start.getX(0));
            double b34=segment.start.getX(1)-a34*segment.start.getX(0);
            if(closeToZero(a12-a34)){
                return closeToZero(b12-b34);
            }
            double x = -(b12-b34)/(a12-a34);
            return x >= Math.min(this.start.getX(0),this.finish.getX(0)) && x <= Math.max(this.start.getX(0),this.finish.getX(0)) && x >= Math.min(segment.start.getX(0),segment.finish.getX(0)) && x <= Math.max(segment.start.getX(0),segment.finish.getX(0));
        }*/
            /*{
            if(this.start.getX(0)>=this.finish.getX(0)){
                Point2D temp = this.start;
                this.start = this.finish;
                this.finish = temp;
            }
            if(segment.start.getX(0)>=segment.finish.getX(0)){
                Point2D temp = segment.start;
                segment.start = segment.finish;
                segment.finish = temp;
            }
            if(this.start.getX(1)==this.finish.getX(1)){
                k1=0;
            }
            else{
                k1=(this.finish.getX(1)-this.start.getX(1))/(this.finish.getX(0)-this.start.getX(0));
            }

            if(segment.start.getX(1)==segment.finish.getX(1)){
                k2=0;
            }
            else{
                k2=(segment.finish.getX(1)-segment.start.getX(1))/(segment.finish.getX(0)-segment.start.getX(0));
            }
            if(k1==k2){
                res=false;
            }
            if((this.start.getX(0)<=segment.finish.getX(0) && segment.finish.getX(0)<= this.finish.getX(0)) ||
                    (this.start.getX(0)<=segment.start.getX(0) && segment.start.getX(0)<= this.finish.getX(0)) )
            {
                b1=this.start.getX(1)-k1*this.start.getX(0);
                b2=segment.start.getX(1)-k2*segment.start.getX(0);
                double[] newArr = result(b1, b2, k1,k2);
                res = true;
            }
            else
            {res = false;
            }


        }*/
        return res;
    }

    boolean closeToZero(double v) {
        // Check if double is close to zero, considering precision issues.
        return Math.abs(v) <= 0.0000000000001;
    }

    private static double[] result( double b1, double b2, double k1, double k2)
    {
        double[] arriItersection = new double[2];

        arriItersection[0] = (b2-b1)/(k2-k1);
        arriItersection[1] = k1*arriItersection[0]-b1;

        return arriItersection;
    }


    private double[] swap(double a, double b) {
        double temp =0;
        temp = a;
        a = b;
        b= temp;
        return new double[]{a,b};
    }

    public String toString()
    {
        String result = new String();

        for(int i=0;i<start.getDim();i++){
            result += String.valueOf(start.x[i]);
            result  += ", ";

        }
        for (int i=0;i<finish.getDim();i++){
            result += String.valueOf(finish.x[i]);
            result  += ", ";
        }
        result += "; ";


        return result;
    }
}
