package appcanvas;

/**
 * Created by guyazran on 6/24/15.
 */
public class Point3D extends Point {
    private int zPos;

    public Point3D(int x, int y, int z) {
        super(x, y);
        zPos = z;
    }

    public void setZpos(int z){
        zPos = z;
    }

    public int getZpos(){
        return zPos;
    }

    @Override
    String componentsByComma() {
        return super.componentsByComma() + ',' + zPos;
    }

    public double distanceFromPoint(int x, int y, int z) {
        return Math.sqrt(sumOfSquares(x,y,z));
    }

    @Override
    public double distanceFromPoint(int x, int y) {
        return distanceFromPoint(x, y, 0);
    }

    public double distanceFromPoint(Point3D p){
        return distanceFromPoint(p.getXpos(), p.getYpos(), p.getZpos());
    }

    @Override
    public double distanceFromPoint(Point p) {
        return distanceFromPoint(p.getXpos(), p.getYpos(), 0);
    }

    double sumOfSquares(int x, int y, int z) {
        int deltaZ = z - zPos;
        return super.sumOfSquares(x, y) + deltaZ*deltaZ;
    }

    @Override
    double sumOfSquares(int x, int y) {
        return sumOfSquares(x, y, 0);
    }

}
