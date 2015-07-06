package graphicshape;

/**
 * Created by guyazran on 6/15/15.
 */
public class Rectangle extends Shape {
    private int width;
    private int height;

    public Rectangle(Rectangle rect){
        this(rect.getWidth(), rect.getHeight());
    }

    public Rectangle(int width, int height){
        setWidth(width);
        setHeight(height);
    }

    public int getWidth(){
        return width;
    }

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
    public double area(){
        return width*height;
    }

    @Override
    public double perimeter() {
        return (width + height) * 2;
    }
}
