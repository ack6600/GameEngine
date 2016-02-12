package geometry;

import java.util.ArrayList;

/**
 * Created by Adam on 2/12/2016.
 */
public class Line
{
    private Point[] points;
    public Line(int startX, int startY, int endX, int endY)
    {
        generatePoints(new Point(startX,startY),new Point(endX,endY));
    }
    private void generatePoints(Point startPoint, Point endPoint)
    {
        double slope = calculateSlope(startPoint,endPoint);
        ArrayList<Point> pointList = new ArrayList<Point>();
        Point pointOn = new Point(startPoint.x,startPoint.y);
        while()
        {

        }
    }
    private double calculateSlope(Point startPoint, Point endPoint)
    {
        return ((endPoint.y-startPoint.y)/(endPoint.x/endPoint.y));
    }

}
