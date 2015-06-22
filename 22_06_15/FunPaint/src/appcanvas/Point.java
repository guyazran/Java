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

//    @Override
//    public String toString() {
//        return "(" + xPos + "," + yPos +")";
//    }

    @Override
    public String toString() {
        return "(" + componentsByComma() + ")";
    }

    String componentsByComma(){
        return xPos + "," + yPos;
    }


//    my solution
//    public double distanceFromPoint(Point p){
//        return Math.sqrt(((xPos - p.xPos)*(xPos - p.xPos)+(yPos - p.yPos)*(yPos - p.yPos)));
//    }
//
//    public double distanceFromPoint(int x, int y){
//        return distanceFromPoint(new Point(x, y)); // calls the method by creating an object (worse performance)
//    }
//
//    public double distanceFromOrigin(){
//        return distanceFromPoint(0, 0);
//    }

    // teacher's solution (difference in the helper method)
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
    double sumOfSquares(int x, int y){
        int deltaX = x - xPos;
        int deltaY = y - yPos;
        return deltaX*deltaX + deltaY*deltaY;
    }
}