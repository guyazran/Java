package graphicshape;

/**
 * Created by guyazran on 6/11/15.
 */
public class Shape {
    protected int color;

//    protected void perimeter(){
//
//    }

    public void fillColor(int newColor){
        System.out.println("Filling the shape with color " + newColor);
    }

    public double perimeter(){
        return 0;
    }

    public static double perimeterSum(Shape[] shapes){
        double result = 0;
        for (int i = 0; i < shapes.length; i++) {
            result += shapes[i].perimeter();
        }
        return result;
    }
}
