package appcanvas;

import graphicshape.Shape;

/**
 * Created by guyazran on 6/15/15.
 */
public class Triangle extends Shape{


    public void stam(){
        System.out.println(color); // color is protected and allows access from a different package as there is an extension (as opposed to default access)
    }
}
