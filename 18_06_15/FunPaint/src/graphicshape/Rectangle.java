package graphicshape;

/**
 * Created by guyazran on 6/15/15.
 */
public class Rectangle extends Shape {
    int xPos;
    int yPos;
    int width;
    int height;

    public Rectangle(){
        xPos = 10;
        yPos = 10;
        width = 20;
        height = 10;
    }

    @Override
    public double perimeter() {
        return (width + height) * 2;
    }
}
