import junit.framework.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PyramidTest {

    @Test
    void square() {
        Pyramid pyramid=new Pyramid(new Point3D(new double[]{0,1,3.5}),new Point3D[]{new Point3D(new double[]{-1,0,1.5}),new Point3D(new double[]{-1,2,1.5}),new Point3D(new double[]{1,1,1.5})});
        double actual= Math.round(pyramid.square());
        double expected= 2;
        Assert.assertEquals(expected,actual);
    }

    @Test
    void volume() {
        Pyramid pyramid=new Pyramid(new Point3D(new double[]{0,1,3.5}),new Point3D[]{new Point3D(new double[]{-1,0,1.5}),new Point3D(new double[]{-1,2,1.5}),new Point3D(new double[]{1,1,1.5})});
        double actual= Math.round(pyramid.volume());
        double expected= 1;
        Assert.assertEquals(expected,actual);

    }
}