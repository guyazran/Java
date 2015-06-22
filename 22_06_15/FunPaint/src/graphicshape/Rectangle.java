package graphicshape;

/**
 * Created by guyazran on 6/15/15.
 */
public class Rectangle extends Shape {
    private int width;
    private int height;

    public Rectangle(){
        this(20, 40);
    }
    
    public Rectangle(int width, int height){
        if (width > 0)
            this.width = width;
        else
            this.width = 0;
        if (height > 0)
            this.height = height;
        else
            this.height = 0;
    }

    @Override
    public double perimeter() {
        return (width + height) * 2;
    }
}
