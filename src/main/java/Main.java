import java.util.ArrayList;
import java.util.List;


public class Main {

    public static void main(String[] args) {

        /*double z[]= {1,4,5,4,4};
        double z2[]= {1,4,5,4,33};
        Point x=new Point(5,z);
        Point y=new Point(5,z);*/

        /*Point g = Point.add(x,y);
        for(int i=0;i<g.getDim();i++){
            System.out.println(g.getX(i));
        }*/
       /* Point h=new Point(5,z2);
        h=h.sub(x);
        for(int i=0;i<h.getDim();i++){
            System.out.println(h.getX(i));
        }*/

        /*Point h=new Point(5,z2);
        h=h.mult(4);
        for(int i=0;i<h.getDim();i++){
            System.out.println(h.getX(i));
        }*/


        /*for(int i=0;i<x.getDim();i++){
            System.out.println(Point.mult(x,y));
        }*/
        /*List<IShape> point=new List<IShape>(){

        };*/
        /*double squareMath = 0;
        double lengthMath = 0;
        double square3DMath = 0;
        double valume3DMath = 0;
        int figuresCount = 8;
        int figures3DCount = 4;*/
        /*double []point_3dA={0,1,3.5};
        double []point_3dB={-1,0,1.5};
        double []point_3dC={-1,2,1.5};
        double []point_3dD={1,1,1.5};
        double []st={1,1};
        double []fs={10,1};
        double []fst={7,8};
        double []fsts={2,8};
        Point2D str=new Point2D();
        Point2D fns=new Point2D();
        Point2D nst=new Point2D();
        Point2D nsts=new Point2D();
        Prism prism=new Prism(new Point3D[]{new Point3D(new double[]{4,-1,1}), new Point3D(new double[]{1.5,-1,1}), new Point3D(new double[]{1.5,3,1}),
        new Point3D(new double[]{4,3,1})}, new Point3D[]{new Point3D(new double[]{4,-1,-1}), new Point3D(new double[]{1.5,-1,-1}), new Point3D(new double[]{1.5,3,-1}), new Point3D(new double[]{4,3,-1})
        });*/
        /*Parallelepiped parallelepiped=new Parallelepiped(new Point3D[]{new Point3D(new double[]{4,-1,1}), new Point3D(new double[]{1.5,-1,1}), new Point3D(new double[]{1.5,3,1}),
                new Point3D(new double[]{4,3,1}), new Point3D(new double[]{4,-1,-1}), new Point3D(new double[]{1.5,-1,-1}), new Point3D(new double[]{1.5,3,-1}), new Point3D(new double[]{4,3,-1})
        });

        System.out.println(parallelepiped.volume());*/
        /*Point3D point3DA=new Point3D();
        Point3D point3DB=new Point3D();
        Point3D point3DC=new Point3D();
        Point3D point3DD=new Point3D();
        Point3D p12[]=new Point3D[]{point3DB,point3DD,point3DC};

        point3DA.setX(point_3dA);
        point3DB.setX(point_3dB);
        point3DC.setX(point_3dC);
        point3DD.setX(point_3dD);
        str.setX(st);
        fns.setX(fs);
        nst.setX(fst);
        nsts.setX(fsts);
        Point2D[] arr = new Point2D[]{str,fns};
        Segment now=new Segment(str,fns).symAxis(2);*/
        /*Circle circle=new Circle(str,2).rot(80);*/
/*
        Pyramid pyramid=new Pyramid(new Point3D(new double[]{0,1,3.5}),new Point3D[]{new Point3D(new double[]{-1,0,1.5}),new Point3D(new double[]{-1,2,1.5}),new Point3D(new double[]{1,1,1.5})});
*/

        /*System.out.println("Ширина " +prism.lengthVector3D(prism.getP(0),prism.getP(1)));
        System.out.println("Высота "+prism.lengthVector3D(prism.getP(0),prism.getP(4)));
        System.out.println("Длина"+prism.lengthVector3D(prism.getP(0),prism.getP(3)));
        System.out.println(prism.volume());*/
        /*double []AB={point3DB.getX(0)-point3DA.getX(0),point3DB.getX(1)-point3DA.getX(1),point3DB.getX(2)-point3DA.getX(2)};
        double []AC={point3DC.getX(0)-point3DA.getX(0),point3DC.getX(1)-point3DA.getX(1),point3DC.getX(2)-point3DA.getX(2)};
        double []AD={point3DD.getX(0)-point3DA.getX(0),point3DD.getX(1)-point3DA.getX(1),point3DD.getX(2)-point3DA.getX(2)};
        point3DB.setX(AB);
        point3DC.setX(AC);
        point3DD.setX(AD);
        double res;
        float result=1/6f;
        res= Point3D.mix_prod(point3DB,point3DC,point3DD);
        System.out.println(pyramid.volume());*/
        /*System.out.println(AB[0]+","+AB[1]+","+AB[2]);
        System.out.println(AC[0]+","+AC[1]+","+AC[2]);
        System.out.println(AD[0]+","+AD[1]+","+AD[2]);*/


        /*Circle circle=new Circle(str,2);
        Point2D[] arp=new Point2D[]{str,fns,nst,nsts};
        Rectangle rectangle=new Rectangle(arp);
        Trapeze trapeze=new Trapeze(arp);
        NGon nGon=new NGon(arp);
        QGon qGon=new QGon(arp);

        Polyline polyline=new Polyline(arr);




        List<IShape> iShapes=new ArrayList<IShape>();

        iShapes.add(new Segment(str,fns));
        iShapes.add(new Polyline(arr));
        iShapes.add(new Circle(str,2));
        iShapes.add(new NGon(arp));
        iShapes.add(new QGon(arp));
        iShapes.add(new TGon(arp));
        iShapes.add(new Rectangle(arp));
        iShapes.add(new Trapeze(arp));
        for(int i = 0; i < figuresCount; i++) {
            squareMath += iShapes.get(i).square();
            lengthMath += iShapes.get(i).length();
        }
        IShape _newFigure;
        IShape _newFigureComparison;
        _newFigure = new Segment(new Point2D(new double[]{0, 1}), new Point2D(new double[]{1, 0}));
        _newFigureComparison = new Segment(new Point2D(new double[]{0, 2}), new Point2D(new double[]{2, 0}));
        iShapes.add(_newFigure);
        System.out.println("Изначальная фигура "+ _newFigure +", Новая фигура "+ _newFigureComparison +", пересекаются: "+ _newFigure.cross(_newFigureComparison));*/
        /*System.out.println("Средняя площадь 2Д: "+ squareMath / figuresCount);
        System.out.println("Общая площадь всех 2Д фигур: "+ squareMath);
        System.out.println("Общая длина всех 2Д фигур: "+ lengthMath);

        for (int i = 0; i < iShapes.size(); i++)
            System.out.println(iShapes.get(i).length());*/


        /*IShape iShape=new Segment(str,fns);
        System.out.println(iShape.length());*/

        /*Point3D po=new Point3D(5);

        Point po1=new Point(5);
        String ss = po1.toString();
	    System.out.println(po);
        System.out.println(ss);*/
        double _squareMath = 0;
        double _lengthMath = 0;
        double _square3DMath = 0;
        double _valume3DMath = 0;
        List<IShape> figures2d = new ArrayList<IShape>();
        List<IFigure> figure3D = new ArrayList<IFigure>();
        int figCount = 4;
        int fig3DCount = 4;
        IShape _newFigure;
        IShape _newFigureComparison;

        for(int i = 1; i <= figCount; i++) {
            switch(i) {
                case 1:
                    _newFigure = new Circle(new Point2D(new double[]{1, 1}), 1);
                    _newFigureComparison = new Circle(new Point2D(new double[]{0, 2}), 2);

                    figures2d.add(_newFigure);

                    System.out.println("Фигура типа Circle");
                    System.out.println("Изначальная фигура "+ _newFigure +", Новая фигура "+ _newFigureComparison +", пересекаются: "+ _newFigure.cross(_newFigureComparison));
                    System.out.println("Передвижение фигуры "+ _newFigure +": "+ _newFigure.shift(new Point2D(new double[]{3, 3})));
                    System.out.println("Изначальная фигура "+ _newFigure +", Новая фигура "+ _newFigureComparison +", пересекаются: "+ _newFigure.cross(_newFigure.shift(new Point2D(new double[]{3, 3}))));
                    System.out.println();
                    break;
                case 2:
                    _newFigure = new Segment(new Point2D(new double[]{0, 2}), new Point2D(new double[]{1, 1}));
                    _newFigureComparison = new Segment(new Point2D(new double[]{0, 1}), new Point2D(new double[]{2, 3}));

                    figures2d.add(_newFigure);

                    System.out.println("Фигура типа Segment");
                    System.out.println("Изначальная фигура "+ _newFigure +", Новая фигура "+ _newFigureComparison +", пересекаются: "+ _newFigure.cross(_newFigureComparison));
                    System.out.println("Вращение фигуры "+ _newFigure +": "+ _newFigureComparison.rot(1));
                    System.out.println("Изначальная фигура "+ _newFigure +", Новая фигура "+ _newFigureComparison +", пересекаются: "+ _newFigure.cross(_newFigureComparison.rot(1)));
                    System.out.println();
                    break;
                case 3:
                    _newFigure = new Polyline(new Point2D[]{
                            new Point2D(new double[]{0, 3}), new Point2D(new double[]{2, 1}), new Point2D(new double[]{1, 1})
                    });
                    _newFigureComparison = new Polyline(new Point2D[]{
                            new Point2D(new double[]{0, 1}), new Point2D(new double[]{-1, 2}),
                            new Point2D(new double[]{2, 3}), new Point2D(new double[]{1, 0})
                    });

                    figures2d.add(_newFigure);

                    System.out.println("Фигура типа Polyline");
                    System.out.println("Изначальная фигура "+ _newFigure +", Новая фигура "+ _newFigureComparison +", пересекаются: "+ _newFigure.cross(_newFigureComparison));
                    System.out.println("Передвижение фигуры "+ _newFigure +": "+ _newFigure.symAxis(0));
                    System.out.println("Изначальная фигура "+ _newFigure +", Новая фигура "+ _newFigureComparison +", пересекаются: "+ _newFigure.cross(_newFigureComparison.symAxis(0)));
                    System.out.println();
                    break;
                case 4:
                    _newFigure = new NGon(new Point2D[]{
                            new Point2D(new double[]{1, 1}), new Point2D(new double[]{2, 3}), new Point2D(new double[]{4, 6}),
                            new Point2D(new double[]{3, 0}), new Point2D(new double[]{1, 0})
                    });
                    _newFigureComparison = new NGon(new Point2D[]{
                            new Point2D(new double[]{5, 2}), new Point2D(new double[]{8, 3}), new Point2D(new double[]{9, 1}),
                            new Point2D(new double[]{8, -2}), new Point2D(new double[]{6, -2})
                    });

                    figures2d.add(_newFigure);

                    System.out.println("Фигура типа NGon");
                    System.out.println("Изначальная фигура "+ _newFigure +", Новая фигура "+ _newFigureComparison +", пересекаются: "+ _newFigure.cross(_newFigureComparison));
                    System.out.println("Передвижение фигуры "+ _newFigure +": "+ _newFigure.shift(new Point2D(new double[]{-2,1})));
                    System.out.println("Изначальная фигура "+ _newFigure +", Новая фигура "+ _newFigureComparison +", пересекаются: "+ _newFigure.cross(_newFigure.shift(new Point2D(new double[]{-2,1}))));
                    System.out.println();
                    break;
            }
        }

        for(int i = 0; i < figCount; i++) {
            _squareMath += figures2d.get(i).square();
            _lengthMath += figures2d.get(i).length();
        }

        System.out.println("СРедняя площадь 2Д: "+ _squareMath / figCount);



        System.out.println("Общая площадь всех 2Д фигур: "+ _squareMath);
        System.out.println("Общая длина всех 2Д фигур: "+ _lengthMath);

        IFigure _sphere = new Ball(new Point3D(new double[]{1, 1, 1}), 2);
        IFigure _parallepipid = new Parallelepiped(new Point3D[]{
                new Point3D(new double[]{1,2,0}), new Point3D(new double[]{3,3,1}), new Point3D(new double[]{5,3,3}),
                new Point3D(new double[]{3,2,2}), new Point3D(new double[]{2,3,1}), new Point3D(new double[]{4,4,2}),
                new Point3D(new double[]{6,4,4}), new Point3D(new double[]{4,3,3})
        });
        IFigure _prism=new Prism(new Point3D[]{new Point3D(new double[]{0,0,1}), new Point3D(new double[]{2,3,2}), new Point3D(new double[]{3,4,1}),
                }, new Point3D[]{new Point3D(new double[]{1,1,2}), new Point3D(new double[]{3,4,3}), new Point3D(new double[]{4,5,2})
        });
        IFigure _pyramida = new Pyramid(new Point3D(new double[]{1,3,5}),new Point3D[]{new Point3D(new double[]{0,1,0}),new Point3D(new double[]{2,3,4}),new Point3D(new double[]{2,3,3}),new Point3D(new double[]{1,2,1})});


        figure3D.add(_sphere);
        figure3D.add(_parallepipid);
        figure3D.add(_prism);
        figure3D.add(_pyramida);

        for(int i = 0; i < fig3DCount; i++) {
            _square3DMath += figure3D.get(i).square();
            _valume3DMath += figure3D.get(i).volume();
        }


        System.out.println("Общая площадь всех 3Д фигур: "+ _square3DMath);
        System.out.println("Общая объём всех 3Д фигур: "+ _valume3DMath);
        System.out.println("Средний объём по всем 3Д фигурам: "+ _valume3DMath / fig3DCount);
    }
}
