package graphicshape;

import appcanvas.Point;

/**
 * Created by guyazran on 6/11/15.
 */
public class Circle extends Shape {

    private Point center;
    private int radius;

    public static final int DEFAULT_X = 21;
    public static final int DEFAULT_Y = 21;
    static final int DEFAULT_RADIUS = 10;

    //constructor
    public Circle(){
        this(DEFAULT_X, DEFAULT_Y);
    }

    public Circle(int x, int y){
        this(new Point(DEFAULT_X, DEFAULT_Y), DEFAULT_RADIUS);
    }

    //cloning constructor
    public Circle(Circle circle){
        this(circle.getCenter(), circle.getRadius());
    }

    public Circle(Point center, int r){
        setCenter(center);
        setRadius(r);
    }

    public Circle(int r){
        this(new Point(DEFAULT_X, DEFAULT_Y), r);
    }

    public Point getCenter(){
        //return center;
        return new Point(center); //returns a pointer to a new object thus denying access to the original center field
    }
    public void setCenter(Point center){
        //this.center = center; //copies the pointer and therefor allows access to the center through the point used to create it
        this.center = new Point(center); //creates a new object which no one has access to
    }

    /*
    a getter and a setter of an object can be written in two ways (example: center)
    getCenter():
    1.return center; this returns the address to the objects and allows manipulating of the object through an external one. this is called aliasing
    2. return new point(center); this returns an address to a new object that was created that is the same as this object. this is without aliasing
    setCenter():
    1. this.center = center; this gives center the address of an existing external object and can now be manipulated through it. aliasing
    2. this.center = new(center); this gives center the address to a new object created with the values of an external object. without aliasing
     */

    public int getRadius() {
        return radius;
    }
    public void setRadius(int radius) {
        if (radius > 0)
            this.radius = radius;
    }

    @Override
    public String toString() {
        return "center = "+center+" and radius = " + radius;
    }

    @Override
    public double area(){ //instances method: uses instance fields from the class
        return Math.PI * radius * radius;
    }

    @Override
    public void fillColor(int newColor) {
        System.out.println("Filling the circle with color " + newColor);
    }

    public void fillColor(byte red, byte green, byte blue){
        System.out.println("fiiling the circle with color using rgb");
    }

    public void fillColor(float hugh, float saturation, float brightness){
        System.out.println("fiiling the circle with color using rgb");
    }

    @Override
    public double perimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (obj == this)
            return true;
        if (obj instanceof Circle){
            Circle other = (Circle)obj;
            return this.center.equals(other.center) && this.radius == other.radius;
        }
        return false;
    }
}
