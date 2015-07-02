package graphicshape;

/**
 * Created by guyazran on 6/11/15.
 */
public abstract class Shape {
    protected Color color;

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

    //static nested class
    public static class Color{ //a class that is meant mostly for shape but can be used from the outside
        protected byte red, green, blue, alpha;
        public Color(byte r, byte g, byte b, byte a){
            red = r;
            green = g;
            blue = b;
            alpha = a;
        }

        public Color(Color color){
            this(color.red, color.green, color.blue, color.alpha);
        }

        @Override
        public String toString() {
            return "red: " + red + ", green: " + green + ", blue: " + blue + ", alpha: " + alpha;
        }
    }

}
