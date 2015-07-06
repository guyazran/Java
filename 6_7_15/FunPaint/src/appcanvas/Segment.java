package appcanvas;

/**
 * Created by guyazran on 6/25/15.
 */
public class Segment {
    private Point p1;
    private Point p2;
    private double length;
    private boolean lengthCalculated = false;

    public Segment(Point p1, Point p2) {
        setP1(p1);
        setP2(p2);
    }

    public Segment(Segment segment){
        this(segment.getP1(), segment.getP2());
    }

    public Point getP1() {
        return new Point(p1);
    }

    public void setP1(Point p1) {
        this.p1 = new Point(p1);
        lengthCalculated = false;
    }

    public Point getP2() {
        return new Point(p2);
    }

    public void setP2(Point p2) {
        this.p2 = new Point(p2);
        lengthCalculated = false; // if a point is changed, the length must be recalculated
    }

    public double length(){ // this method will only calculate the length of the segment on the first time
        if (!lengthCalculated)
            calculateLength();
        return length;
    }

    public void calculateLength(){
        length = p1.distanceFromPoint(p2);
        lengthCalculated = true;
    }

    public double slope(){
        double deltaX = p1.getXpos() - p2.getXpos();
        double deltaY = p1.getYpos() - p2.getYpos();
        if(deltaX == 0){
            return Double.MAX_VALUE; //"infinity"
        }
        return deltaY/deltaX;
    }

    public double distanceFromPoint(Point p){
        double x1, y1, x2, y2, x0, y0;
        x1 = this.p1.getXpos();
        y1 = this.p1.getYpos();
        x2 = this.p2.getXpos();
        y2 = this.p2.getYpos();
        x0 = p.getXpos();
        y0 = p.getYpos();
        double temp = (y2 - y1)*x0 - (x2 - x1)*y0 + x2*y1 - y2*x1;
        if(temp<0){
            temp *= -1;
        }
        return temp/length();
    }

    double perpendicularSlope(){
        return (-1/this.slope());
    }

    double yIntercept(){
        return yIntercept(p1, this.slope());
    }

    double yIntercept(Point p, double slope){
        return p.getYpos() - (p.getXpos()*slope);
    }

    double findCommonX(double slope, double yIntercept){
        return (yIntercept - this.yIntercept())/(this.slope() - slope);
    }

    double findCommonY(double x){
        return this.slope()*x + this.yIntercept();
    }

    protected boolean isPointNearSegment(Point p){ // this function is meant to be used only in drawOnCanvas(). no need to check border
        //Border border = getBorder(); //there is no need to check the border when called from drawOnCanvas()(performance)
        double d = distanceFromPoint(p);
        return d < 0.4;

    }

    public boolean isPointOnSegment(Point p){ //a border will be created only when checking another point, drawOnCanvas() skips this method
        Border border = getBorder(); // drawOnCanvas() skips this method and thus creates less objects
        if(p.getXpos() >= border.leftBorder  && p.getXpos() <= border.rightBorder && p.getYpos() >= border.topBorder && p.getYpos() <= border.bottomBorder) {
            return isPointNearSegment(p);
        }
        return false;
    }

    @Override
    public String toString() {
        return "The segment starts at " + p1 + "and ends at" + p2 + ". The linear equation is y = " + this.slope() + "x + " + this.yIntercept();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (obj == this)
            return true;
        if (obj instanceof Segment) {
            Segment other = new Segment((Segment) obj);
            return this.p1.equals(other.p1) && this.p2.equals(other.p2);
        }
        return false;
    }

    public void drawOnCanvas(boolean[][] canvas){
        Border border = getBorder();
        if(canvas == null)
            return;
        Point p = new Point(0,0);
        for (int i = border.topBorder; i <= border.bottomBorder+1; i++) {
            for (int j = border.leftBorder; j <= border.rightBorder; j++) {
                p.setXpos(j); // Point p = new Point(j,i);
                p.setYpos(i); // in this method performance is optimized because an object is not created for every iteration of the loop
                if(isPointNearSegment(p)) // skips the border check in order to create less objects and skip the long "if" statement in isPointOnSegment()
                    p.drawOnCanvas(canvas);
            }
        }
    }

    public Border getBorder(){
        int leftBorder = p1.getXpos();
        int rightBorder = p2.getXpos();
        if(p1.getXpos() > p2.getXpos()) {
            leftBorder = p2.getXpos();
            rightBorder = p1.getXpos();
        }
        int topBorder = p1.getYpos();
        int bottomBorder = p2.getYpos();
        if (p1.getYpos() > p2.getYpos()) {
            topBorder = p2.getYpos();
            bottomBorder = p1.getYpos();
        }
        Border border = new Border();
        border.leftBorder = leftBorder;
        border.rightBorder = rightBorder;
        border.topBorder = topBorder;
        border.bottomBorder = bottomBorder;
        return border;
    }
    //inner class

    class Border { // can only be used within segment. the keyword public will not make a difference
        int leftBorder, rightBorder, topBorder, bottomBorder;
    }
}