package graphicshape;

/**
 * Created by guyazran on 6/22/15.
 */
public class Square extends Rectangle {

    public Square(int side) {
        super(side, side);
    }

    public void setSide(int side){
        if (side > 0) {
            super.setWidth(side);
            super.setHeight(side); // without the "super." setheight would call the overridden method and cause an infinite loop
        }
    }

    public int getSide(){
        return getHeight();
    }

    @Override
    public void setHeight(int height) {
        setSide(height);
    }

    @Override
    public void setWidth(int width) {
        setSide(width);
    }
}
