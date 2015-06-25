package appcanvas;

/**
 * Created by guyazran on 6/22/15.
 */
public class Point {
    private int xPos;
    private int yPos;

    public Point(int x, int y){
        setXpos(x);
        setYpos(y);
    }

    public int getXpos() {
        return xPos;
    }
    public void setXpos(int xPos) {
        this.xPos = xPos;
    }

    public int getYpos() {
        return yPos;
    }
    public void setYpos(int yPos) {
        this.yPos = yPos;
    }

    @Override
    public String toString() {
        return "(" + componentsByComma() + ")";
    }

    protected String componentsByComma(){
        return xPos + "," + yPos;
    }


    public double distanceFromPoint(int x, int y){
        return Math.sqrt(sumOfSquares(x,y));
    }

    public double distanceFromPoint(Point p){
        return distanceFromPoint(p.getXpos(), p.getYpos()); // calls the function without creating an object (better performance)
    }

    public double distanceFromOrigin(){
        return distanceFromPoint(0,0);
    }

    // helper method
    protected double sumOfSquares(int x, int y){
        int deltaX = x - xPos;
        int deltaY = y - yPos;
        return deltaX*deltaX + deltaY*deltaY;
    }

    @Override // in Object, the method equals compares pointers and must be overridden to compare what it is you want to compare between the specific object.
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (obj == this)
            return true;
        if (obj instanceof Point){
            Point other = (Point)obj;
            return this.xPos == other.xPos && this.yPos == other.yPos;
        }
        return false;
    }
}