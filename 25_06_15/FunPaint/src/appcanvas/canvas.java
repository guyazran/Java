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
//        Point3D p1 = new Point3D(5, 6, 12);
//        System.out.println(p1);
//        System.out.println(p1.distanceFromPoint(9, 3, 5));
//        System.out.println(p1.distanceFromPoint(3, 14));
//        Point3D p2 = new Point3D(18, 44, 11);
//        System.out.println(p1.distanceFromPoint(p2));
//        Point p3 = new Point(11, 5);
//        System.out.println(p1.distanceFromPoint(p3));
//        System.out.println(p1.distanceFromOrigin());

        Point p1 = new Point(3, 4);
        Point p2 = new Point(3, 4);
        if (p1 == p2){ // the comparison compares the pointers and not the value of their fields, therefor they will be different for all field values.
            System.out.println("p1 and p2 are the same");
        } else {
            System.out.println("p1 and p2 are different");
        }

        Point p3 = new Point(3, 4);
        Point p4 = new Point(3, 4);
        if (p3.equals(p4)){
            System.out.println("p1 and p2 are the same");
        } else {
            System.out.println("p1 and p2 are different");
        }

    }

    public static double sumOfArea(Shape[] shapes){
        double sum = 0;

        for (Shape s : shapes){
            sum += s.area();
        }
        return sum;
    }
}