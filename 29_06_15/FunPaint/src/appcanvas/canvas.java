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
        //optimization check
        Point p1 = new Point(4, 5);
        Point p2 = new Point(12, -3);
        long sum = 0;
        double totalDistance = 0;
        for (int i = 0; i < 100; i++) { //loop that checks how long it takes to run a method 100 times
            long start = System.nanoTime();
            p1.setXpos(i);
            totalDistance += p1.distanceFromPoint(p2);
            long end = System.nanoTime();
            sum += end - start;
        }
        long delay = sum/100l; //finds the average time it takes to run
        System.out.println(delay);
        System.out.println(totalDistance);
    }

    public static double sumOfArea(Shape[] shapes){
        double sum = 0;

        for (Shape s : shapes){
            sum += s.area();
        }
        return sum;
    }
}