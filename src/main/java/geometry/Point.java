package geometry;

/**
 * Created by Adam on 2/12/2016.
 */
public class Point extends BasicShape
{
    public double x;
    public double y;
    public Point(double x, double y)
    {
        this.x = x;
        this.y = y;
    }
    public void translate(double x, double y)
    {
        this.x += x;
        this.y += y;
    }

    @Override
    public Point[] getPoints()
    {
        Point[] points = new Point[1];
        points[0] = new Point(this.x,this.y);
        return points;
    }
}
