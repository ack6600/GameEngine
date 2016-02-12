package geometry;

/**
 * Created by Adam on 2/12/2016.
 */
public class Point
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
    public boolean compare(Point toCompare)
    {
        return (this.x)
    }


}
