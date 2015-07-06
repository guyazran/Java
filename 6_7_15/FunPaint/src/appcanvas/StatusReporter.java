package appcanvas;

import graphicshape.Shape;

/**
 * Created by guyazran on 7/2/15.
 */
public class StatusReporter {

    public static Shape.Color getDescriptiveColor(Shape.Color color){
        //anonymous class
        return new Shape.Color(color){
            @Override
            public String toString() {
                if (alpha < -100) {
                    return "transparent";
                }
                if (red > 100 && green < 100 && blue < 100) {
                    return "reddish";
                } else {
                    return "blueish";
                }
            }
        };
    }
}
