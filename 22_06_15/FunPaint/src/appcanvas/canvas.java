package appcanvas;

import graphicshape.Circle;
import graphicshape.Rectangle;
import graphicshape.Shape;
import graphicshape.Square;

/**
 * Created by guyazran on 6/11/15.
 */
public class canvas {

    public static void main(String[] args) {
        Square square = new Square(4);
        square.setSide(5);
        square.setWidth(12);
        System.out.println(square.area());
        System.out.println(square.perimeter());
    }

    public static double sumOfArea(Shape[] shapes){
        double sum = 0;

//        for (Shape s : shapes){
//            if (s instanceof Rectangle){
//                Rectangle rect = (Rectangle)s;
//                sum += rect.area();
//            }
//            if (s instanceof Circle){
//                Circle c = (Circle)s;
//                sum = c.area();
//            }
//        }

        for (Shape s : shapes){
            sum += s.area();
        }
        return sum;
    }
}