package appcanvas;

import graphicshape.Circle;

/**
 * Created by guyazran on 6/11/15.
 */
public class canvas {

    public static void main(String[] args) {
        System.out.println("in main of Canvas");
        Circle circle = new Circle();
        System.out.println(circle.area()); //instances method: uses instances from a specific object
        System.out.println(Circle.calculateArea(20)); // public method: uses parameters and is activated through a class
    }

}
