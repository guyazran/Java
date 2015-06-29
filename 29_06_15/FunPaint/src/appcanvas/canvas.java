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
        Point p1 = new Point(0, 2);
        Point p2 = new Point(6, 0);
        Segment s = new Segment(p1, p2);
        System.out.println(s);
        Point p3 = new Point(-2, -4);
        Segment perpS = new Segment(p3, p1);
        System.out.println(perpS);
        System.out.println(s.distanceFromStraight(p3));
    }

    public static double sumOfArea(Shape[] shapes){
        double sum = 0;

        for (Shape s : shapes){
            sum += s.area();
        }
        return sum;
    }
}