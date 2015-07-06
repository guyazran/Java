package appcanvas;

import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;
import graphicshape.*;

/**
 * Created by guyazran on 6/11/15.
 */
public class canvas {
    private static boolean[][] canvas = new boolean[50][60];

    public static void clearCanvas(){
        for (int i = 0; i < canvas.length; i++) {
            for (int j = 0; j < canvas[i].length; j++) {
                canvas[i][j] = false;
            }
        }
    }

    public static void drawCanvas() {
        for (int i = 0; i < canvas.length; i++) {
            for (int j = 0; j < canvas[i].length; j++) {
                System.out.print(canvas[i][j] ? "*" : " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

    }

    public static void drawMagenDavid(){
        Triangle triangle1 = new Triangle(new Point(1,10), new Point(40,10), new Point(20,28));
        Triangle triangle2 = new Triangle(new Point(1,18), new Point(40,18), new Point(20,2));
        triangle1.drawOnCanvas(canvas);
        triangle2.drawOnCanvas(canvas);

    }

    public static double sumOfArea(Shape[] shapes){
        double sum = 0;

        for (Shape s : shapes){
            sum += s.area();
        }
        return sum;
    }
}