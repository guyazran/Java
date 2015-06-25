package appcanvas;

import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;
import graphicshape.Circle;
import graphicshape.Rectangle;
import graphicshape.Shape;
import graphicshape.Square;

/**
 * Created by guyazran on 6/11/15.
 */
public class canvas {

    public static void main(String[] args) {

        Point3D p1 = new Point3D(5, 6, 12);
        System.out.println(p1);
        System.out.println(p1.distanceFromPoint(9, 3, 5));
        System.out.println(p1.distanceFromPoint(3, 14));
        Point3D p2 = new Point3D(18, 44, 11);
        System.out.println(p1.distanceFromPoint(p2));
        Point p3 = new Point(11, 5);
        System.out.println(p1.distanceFromPoint(p3));
        System.out.println(p1.distanceFromOrigin());
    }

    public static double sumOfArea(Shape[] shapes){
        double sum = 0;

        for (Shape s : shapes){
            sum += s.area();
        }
        return sum;
    }
}