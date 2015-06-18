package graphicshape;

/**
 * Created by guyazran on 6/11/15.
 */
public class Circle extends Shape {
    int xPos;
    int yPos;
    private int radius;

    //constructor
    public Circle(){
        xPos = 20;
        yPos = 20;
        radius = 10;
    }

    @Override
    public String toString() {
        return "center = ("+xPos+","+yPos+")";
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
