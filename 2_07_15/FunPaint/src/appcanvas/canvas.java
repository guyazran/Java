package appcanvas;

import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;
import graphicshape.*;

/**
 * Created by guyazran on 6/11/15.
 */
public class canvas {
    private static boolean[][] canvas = new boolean[50][60];

    public static void clearCanvas(){
        for (int i = 0; i < canvas.length; i++) {
            for (int j = 0; j < canvas[i].length; j++) {
                canvas[i][j] = false;
            }
        }
    }

    public static void drawCanvas() {
        for (int i = 0; i < canvas.length; i++) {
            for (int j = 0; j < canvas[i].length; j++) {
                System.out.print(canvas[i][j] ? "*" : " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        byte r = 18, g = -8, b = 100, a = 127;
        Shape.Color myColor = new Shape.Color(r,g,b,a); // constructor of a static class is used in a similar way to static methods
        System.out.println(myColor);

//        Segment.Border = new Segment.Border();
//        Segment seg = new Segment(new Point(3, 4), new Point(5, 6));
//        seg.Border = new Border();
//        Border is an inner class and cannot be used from outside the Segment class

        Shape.Color myOherColor = StatusReporter.getDescriptiveColor(myColor);
        System.out.println(myOherColor); //myOtherColor is a DescriptiveColor and therefor toString will work as it is in DescriptiveColor
        //DescriptiveColor doesn't exist by the time myOtherColor is printed out, but its type is kept as a Descriptive class.
        //local inner classes are used to override the inherited class's methods

        //anonymous inner class
        //a class that inherits from a class but does not have a name of its own.
        //this will be used for creating objects that will be used only once.
        //example: there is only one login button out of all the buttons in an app, and therefor it makes no sense to create a new class for it.
        Parallelogram para = new Parallelogram(){
            @Override
            public double area() {
                stam(); //this is the only place this method can be used
                return super.area() + 1;
            }
            void stam(){ //this method has no way to be used in any case except inside overriden methods
                System.out.println("in stam...");
            }
        };
        System.out.println(para.area());
    }

/*

Nested Classes:

- Static nested class
- Inner Class
- Local inner Class
- Anonymous inner Class

 */

    public static void drawMagenDavid(){
        Triangle triangle1 = new Triangle(new Point(1,10), new Point(40,10), new Point(20,28));
        Triangle triangle2 = new Triangle(new Point(1,18), new Point(40,18), new Point(20,2));
        triangle1.drawOnCanvas(canvas);
        triangle2.drawOnCanvas(canvas);

    }

    public static double sumOfArea(Shape[] shapes){
        double sum = 0;

        for (Shape s : shapes){
            sum += s.area();
        }
        return sum;
    }
}