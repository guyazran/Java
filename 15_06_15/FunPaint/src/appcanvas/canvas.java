package appcanvas;

import graphicshape.Circle;
import graphicshape.Rectangle;
import graphicshape.Shape;

/**
 * Created by guyazran on 6/11/15.
 */
public class canvas {

    public static void main(String[] args) {
//        System.out.println("in main of Canvas");
//        Circle c1 = new Circle();
//        System.out.println(c1.area());
        //System.out.println(Circle.calculateArea(20));

//        Shape myShape = new Shape();
//        myShape.color = 123; // will not work because color is protected

//        Circle c = new Circle();
//        c.fillColor(123);
//        Shape s = new Shape();
//        s.fillColor(444);
//        Shape s2 = new Circle();
//        s2.fillColor(1234);
//        s2 = new Rectangle();
//        if(s2 instanceof Circle) {
//            Circle c2 = (Circle) s2;
//            c2.area();
//        }else{
//            System.out.println("s2 is not a circle");
//        }
//        System.out.println("end");

//        Shape myShape = new Shape();
//        myShape.fillColor(123);
//
//        Circle myCircle = new Circle();
//        myCircle.fillColor(123);
//
//        Shape myShape2 = new Circle(); //The type of the pointer deternines which methods will be available.
//        myShape2.fillColor(123); //The actual type of the object determines which method will be executed in runtime.

        Circle c = new Circle();
        System.out.println(c.perimeter());

        Rectangle r = new Rectangle();
        System.out.println(r.perimeter());

        Shape[] shapes = new Shape[4];
        shapes[0] = new Circle();
        shapes[1] = new Rectangle();
        shapes[2] = new Circle();
        shapes[3] = new Rectangle();

        System.out.println(Shape.perimeterSum(shapes));
    }

}
