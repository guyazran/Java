package graphicshape;

/**
 * Created by guyazran on 6/15/15.
 */
public class Rectangle extends Shape {
    int xPos;
    int yPos;
    int width;
    int height;

    final static int defaultxPos = 10;
    final static int defaultYpos = 10;
    final static int defaultWidth = 10;
    final static int defaultxHeight = 10;

    public Rectangle(){
        this(defaultxPos, defaultYpos);
    }

    public Rectangle(int x, int y){
        this(x, y, defaultWidth, defaultxHeight);
    }
    
    public Rectangle(int x, int y, int w, int h){
        xPos = x;
        yPos = y;
        width = w;
        height = h;
    }

    public Rectangle(int w){
        this(defaultxPos, defaultYpos, w, defaultxHeight);
    }

    @Override
    public double perimeter() {
        return (width + height) * 2;
    }
}
