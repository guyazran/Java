package appcanvas;

/**
 * Created by guyazran on 6/25/15.
 */
public class Segment {
    private Point p1;
    private Point p2;

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
    }

    public Point getP2() {
        return new Point(p2);
    }

    public void setP2(Point p2) {
        this.p2 = new Point(p2);
    }

    public double length(){
        return p1.distanceFromPoint(p2);
    }

    public double slope(){
        double deltaX = p1.getXpos() - p2.getXpos();
        double deltaY = p1.getYpos() - p2.getYpos();
        return (double)deltaY/deltaX;
    }

    public double distanceFromStraight(Point p){
//        return Math.abs((p2.getYpos() - p1.getYpos())*p.getXpos() - (p2.getXpos() - p1.getXpos())*p.getYpos()+ p2.getXpos()*p1.getYpos() - p2.getYpos()*p1.getXpos())
//               /this.length();
        double otherSlope = this.perpendicularSlope();
        double otherYintercept = yIntercept(p, otherSlope);
        double commonX = findCommonX(otherSlope, otherYintercept);
        double commonY = findCommonY(commonX);

        return distanceFromPoint(p, commonX, commonY);
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

    static double distanceFromPoint(Point p, double x, double y){
        double deltaX = x - p.getXpos();
        double deltaY = y - p.getYpos();
        return Math.sqrt(deltaX*deltaX + deltaY*deltaY);
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

    /*
    methods:
    1. returns the length of the segment (double)
    2. what is the distance from any point to the straight that continues the segment (double)
    3. return the slope of the line - deltaY/deltaX

    override the methods: equals and toString
     */
}
