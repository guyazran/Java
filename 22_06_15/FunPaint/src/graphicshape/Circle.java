package graphicshape;

/**
 * Created by guyazran on 6/11/15.
 */
public class Circle extends Shape {
    int xPos;
    int yPos;
    private int radius;

    final static int defaultXpos = 20; //static variables belong to the class (like static methods)
    final static int defaultYpos = 20; //final variables cannot be changed (not even in the class itself)

    //constructor
    public Circle(){
        this(defaultXpos, defaultYpos); // "this" refers to the current object. Cannot use "Circle" because it does not exist yet.
    }

    public Circle(int x, int y){
        this(x, y, 10);
    }

    public Circle(int x, int y, int r){
        xPos = x;
        yPos = y;
        radius = r;
    }

    public Circle(int r){
        this(defaultXpos, defaultYpos, r);
    }

    @Override
    public String toString() {
        return "center = ("+xPos+","+yPos+") and radius = " + radius;
    }

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
}
