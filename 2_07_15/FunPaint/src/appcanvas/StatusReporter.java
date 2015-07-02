package appcanvas;

import graphicshape.Shape;

/**
 * Created by guyazran on 7/2/15.
 */
public class StatusReporter {

    public static Shape.Color getDescriptiveColor(Shape.Color color){
        //local inner class
        //this class is for use only within this method.
        class DescriptiveColor extends Shape.Color{

            public DescriptiveColor(Shape.Color color) {
                super(color);
            }

            void stam(){ //this method can only be used from this method (getDescriptiveColor())
                System.out.println("in stam()");
            }

            @Override
            public String toString() {
                if (alpha<-100){
                    return "transparent";
                }
                if (red>100 && green<100 && blue<100){
                    return "reddish";
                }else {
                    return "blueish";
                }
            }
        }

        DescriptiveColor myDescriptiveColor = new DescriptiveColor(color);
        myDescriptiveColor.stam(); //this method cannot be used outside this method but will be activated when the method getDescriptiveColor() is used

        return myDescriptiveColor;
    }
}
