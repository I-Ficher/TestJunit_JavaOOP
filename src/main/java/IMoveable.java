public interface IMoveable {
    IShape shift(Point2D a);
    IShape rot(double phi);
    IShape symAxis(int i);


}
