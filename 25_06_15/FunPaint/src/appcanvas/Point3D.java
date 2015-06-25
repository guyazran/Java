package appcanvas;

/**
 * Created by guyazran on 6/24/15.
 */
public class Point3D extends Point {
    private int zPos;

    private int newZ;

    public Point3D(int x, int y, int z) {
        super(x, y);
        setZpos(z);
    }

    public void setZpos(int z){
        zPos = z;
    }

    public int getZpos(){
        return zPos;
    }

    @Override
    protected String componentsByComma() {
        return super.componentsByComma() + ',' + zPos;
    }

    public double distanceFromPoint(int x, int y, int z) {
        newZ = z;
        return super.distanceFromPoint(x, y);
    }

    @Override
    public double distanceFromPoint(int x, int y) {
        return distanceFromPoint(x, y, 0);
    }

    @Override
    public double distanceFromPoint(Point p) {
        if(p instanceof Point3D){
            Point3D theOtherPoint = (Point3D)p;
            return distanceFromPoint(theOtherPoint.getXpos(), theOtherPoint.getYpos(), theOtherPoint.getZpos());
        } else {
            return distanceFromPoint(p.getXpos(), p.getYpos(), 0);
        }
    }

    protected double sumOfSquares(int x, int y, int z) {
        int deltaZ = z - zPos;
        return super.sumOfSquares(x, y) + deltaZ*deltaZ;
    }

    @Override
    protected double sumOfSquares(int x, int y) {
        return sumOfSquares(x, y, newZ);
    }
}
