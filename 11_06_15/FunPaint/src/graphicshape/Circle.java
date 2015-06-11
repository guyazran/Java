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

    public double area(){
        return Math.PI * radius * radius;
    }

}
