public interface IShape extends IMoveable {
    double length();
    double square();
    boolean cross(IShape i);

}
