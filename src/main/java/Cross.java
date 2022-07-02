

public class Cross {
    public static boolean checkIntersectionOfTwoLineSegments(Point p1, Point p2,
                                                       Point p3, Point p4) {
        boolean res=false;
        //сначала расставим точки по порядку, т.е. чтобы было p1.x <= p2.x
        if (p2.getX(0) < p1.getX(0)) {

            Point tmp = p1;
            p1 = p2;
            p2 = tmp;
        }
        //и p3.x <= p4.x
        if (p4.getX(0) < p3.getX(0)) {

            Point tmp = p3;
            p3 = p4;
            p4 = tmp;
        }

        //проверим существование потенциального интервала для точки пересечения отрезков
        if (p2.getX(0)< p3.getX(0)) {
            return false; //ибо у отрезков нету взаимной абсциссы
        }

        //если оба отрезка вертикальные
        if((p1.getX(0) - p2.getX(0) == 0) && (p3.getX(0) - p4.getX(0) == 0)) {

            //если они лежат на одном X
            if(p1.getX(0) == p3.getX(0)) {

                //проверим пересекаются ли они, т.е. есть ли у них общий Y
                //для этого возьмём отрицание от случая, когда они НЕ пересекаются
                if (!((Math.max(p1.getX(1), p2.getX(1)) < Math.min(p3.getX(1), p4.getX(1))) ||
                        (Math.min(p1.getX(1), p2.getX(1)) > Math.max(p3.getX(1), p4.getX(1))))) {

                    return true;
                }
            }

            return false;
        }

        //найдём коэффициенты уравнений, содержащих отрезки
        //f1(x) = A1*x + b1 = y
        //f2(x) = A2*x + b2 = y

        //если первый отрезок вертикальный
        if (p1.getX(0) - p2.getX(0) == 0) {

            //найдём Xa, Ya - точки пересечения двух прямых
            double Xa = p1.getX(0);
            double A2 = (p3.getX(1) - p4.getX(1)) / (p3.getX(0) - p4.getX(0));
            double b2 = p3.getX(1) - A2 * p3.getX(0);
            double Ya = A2 * Xa + b2;

            if (p3.getX(0) <= Xa && p4.getX(0) >= Xa && Math.min(p1.getX(1), p2.getX(1)) <= Ya &&
                    Math.max(p1.getX(1), p2.getX(1)) >= Ya) {

                return true;
            }

            return false;
        }

        //если второй отрезок вертикальный
        if (p3.getX(0) - p4.getX(0) == 0) {

            //найдём Xa, Ya - точки пересечения двух прямых
            double Xa = p3.getX(0);
            double A1 = (p1.getX(1) - p2.getX(1)) / (p1.getX(0) - p2.getX(0));
            double b1 = p1.getX(1) - A1 * p1.getX(0);
            double Ya = A1 * Xa + b1;

            if (p1.getX(0) <= Xa && p2.getX(0) >= Xa && Math.min(p3.getX(1), p4.getX(1)) <= Ya &&
                    Math.max(p3.getX(1), p4.getX(1)) >= Ya) {

                return true;
            }

            return false;
        }

        //оба отрезка невертикальные
        double A1 = (p1.getX(1) - p2.getX(1)) / (p1.getX(0) - p2.getX(0));
        double A2 = (p3.getX(1) - p4.getX(1)) / (p3.getX(0) - p4.getX(0));
        double b1 = p1.getX(1) - A1 * p1.getX(0);
        double b2 = p3.getX(1) - A2 * p3.getX(0);

        if (A1 == A2) {
            return false; //отрезки параллельны
        }

        //Xa - абсцисса точки пересечения двух прямых
        double Xa = (b2 - b1) / (A1 - A2);

        res = (!(Math.min(p2.getX(0), p4.getX(0)) < Xa)) && (!(Xa < Math.max(p1.getX(0), p3.getX(0))));

        return res;
    }
}
