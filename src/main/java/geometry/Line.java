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
        int amount = 1;
        pointList.add(pointOn);
        while(pointOn.x<endPoint.x&&pointOn.y<endPoint.y)
        {
            pointOn.translate(1,slope);
            pointList.add(pointOn);
            amount++;

        }
        pointList.add(endPoint);
        amount++;
        points = new Point[amount];
        for(int i = 0;i<amount;i++)
        {
            points[i] = pointList.get(i);
        }
    }
    public Point[] getPoints()
    {
        return points;
    }
    private double calculateSlope(Point startPoint, Point endPoint)
    {
        return ((endPoint.y-startPoint.y)/(endPoint.x-startPoint.x));
    }

}
