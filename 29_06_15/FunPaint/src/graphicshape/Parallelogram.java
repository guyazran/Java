package graphicshape;

import appcanvas.Point;
import appcanvas.Segment;

/**
 * Created by guyazran on 6/29/15.
 */
public class Parallelogram extends Shape {
    Point p1, p2, p3, p4;

    @Override
    public double perimeter() {
        Segment seg1 = new Segment(p1, p2);
        Segment seg2 = new Segment(p2, p3);
        Segment seg3 = new Segment(p3, p4);
        Segment seg4 = new Segment(p4, p1);
        return seg1.length()+seg2.length()+seg3.length()+seg4.length();
    }

    @Override
    public double area() {
        Segment seg1 = new Segment(p1, p2);
        return seg1.length()*seg1.distanceFromPoint(p3);
    }
}
