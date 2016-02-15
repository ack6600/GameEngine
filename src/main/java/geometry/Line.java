package geometry;

import render.RenderObject;

import java.util.ArrayList;

/**
 * Created by Adam on 2/12/2016.
 */
public class Line extends BasicShape
{
    private Point[] points;
    private double resolution;
    public Line(int startX, int startY, int endX, int endY,boolean customResolution,double resolution)
    {
        if(customResolution)
        {
            this.resolution = resolution;
        }
        else
        {
            this.resolution = 1;
        }
        generatePoints(new Point(startX,startY),new Point(endX,endY));

    }
    private void generatePoints(Point startPoint, Point endPoint)
    {
        double slope = calculateSlope(startPoint,endPoint);
        slope = slope*resolution;
        ArrayList<Point> pointList = new ArrayList<Point>();
        Point pointOn = new Point(startPoint.x,startPoint.y);
        pointList.add(new Point(pointOn.x,pointOn.y));
        while(pointOn.x<endPoint.x&&pointOn.y<endPoint.y)
        {
            pointOn.translate(resolution,slope);
            pointList.add(new Point(pointOn.x,pointOn.y));
        }
        pointList.add(endPoint);
        points = new Point[pointList.size()];
        pointList.toArray(points);
    }
    @Override
    public Point[] getPoints()
    {
        return points;
    }
    private double calculateSlope(Point startPoint, Point endPoint)
    {
        return ((endPoint.y-startPoint.y)/(endPoint.x-startPoint.x));
    }

}
