package graphicshape;

import appcanvas.Segment;

/**
 * Created by guyazran on 6/22/15.
 */
public class Square extends Rectangle {

    public Square(int side) {
        super(side, side);
    }

    public Square(Square square){
        this(square.getSide());
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

    @Override
    public String toString() {
        return "A square with a side at a length of " + getSide();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (obj == this)
            return true;
        if (obj instanceof Segment) {
            Square other = new Square((Square) obj);
            return this.getSide() == other.getSide();
        }
        return false;
    }
}
