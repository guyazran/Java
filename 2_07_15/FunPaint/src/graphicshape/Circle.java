package graphicshape;

import appcanvas.Point;

/**
 * Created by guyazran on 6/11/15.
 */
public final class Circle extends Shape { //no other class can inherit from a final class

    private Point center;
    private int radius;

    public static final int DEFAULT_X = 21;
    public static final int DEFAULT_Y = 21;
    static final int DEFAULT_RADIUS = 10;


    public Circle(){
        this(DEFAULT_X, DEFAULT_Y);
    }

    public Circle(int x, int y){
        this(new Point(DEFAULT_X, DEFAULT_Y), DEFAULT_RADIUS);
    }

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
        return new Point(center);
    }
    public void setCenter(Point center){
        this.center = new Point(center);
    }


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
