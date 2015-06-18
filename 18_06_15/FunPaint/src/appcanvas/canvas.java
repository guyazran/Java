package appcanvas;

import graphicshape.Circle;
import graphicshape.Rectangle;
import graphicshape.Shape;

/**
 * Created by guyazran on 6/11/15.
 */
public class canvas {

    public static void main(String[] args) {

//        Circle c = new Circle();
//        System.out.println(c.perimeter());
//
//        Rectangle r = new Rectangle();
//        System.out.println(r.perimeter());
//
//        Shape[] shapes = new Shape[4];
//        shapes[0] = new Circle();
//        shapes[1] = new Rectangle();
//        shapes[2] = new Circle();
//        shapes[3] = new Rectangle();
//
//        System.out.println(Shape.perimeterSum(shapes));
        Circle c1 = new Circle();
        c1.fillColor(12);
        byte red = 60;
        byte green = 28;
        byte blue = -30;
        c1.fillColor(red, green, blue);

        Circle c2 = null;
        //doSomethingWithCircle(c2); This will cause "NullPointerException" error

        c2 = new Circle(3, 4);
        System.out.println(c2);
    }

//    public static void doSomethingWithCircle(Circle c){
//        c.fillColor(15);
//    }

}
