package graphicshape;

/**
 * Created by guyazran on 6/11/15.
 */
public abstract class Shape {
    protected int color;

    public void fillColor(int newColor){
        System.out.println("Filling the shape with color " + newColor);
    }

    public abstract double perimeter();

    public abstract double area();

    public static double perimeterSum(Shape[] shapes){
        double result = 0;
        for (int i = 0; i < shapes.length; i++) {
            result += shapes[i].perimeter();
        }
        return result;
    }
}
