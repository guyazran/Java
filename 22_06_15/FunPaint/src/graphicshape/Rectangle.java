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
        setWidth(width);
        setHeight(height);
    }

    //getter: a function that returns a value of a field in a controlled manner
    public int getWidth(){
        return width;
    }

    //setter: a function that changes the value of a field in a controlled manner
    public void setWidth(int width){
        if (width > 0)
            this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        if (height > 0)
            this.height = height;
    }

    @Override
    public double perimeter() {
        return (width + height) * 2;
    }
}
