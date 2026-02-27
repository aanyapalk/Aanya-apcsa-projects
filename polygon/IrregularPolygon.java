package polygon;

import java.awt.geom.*; // for Point2D.Double
import java.util.ArrayList; // for ArrayList
import gpdraw.*; // for DrawingTool

public class IrregularPolygon {
    private ArrayList<Point2D.Double> myPolygon = new ArrayList<Point2D.Double>();

    // constructor
    public IrregularPolygon() {}

    // public methods
    public void add(Point2D.Double aPoint)
    {
          myPolygon.add(aPoint);
    }

    public double perimeter() {
        double perimeter = 0.0;

        if (myPolygon.size() < 2)
            return 0.0;

        for (int i = 0; i < myPolygon.size(); i++) {
            Point2D.Double p1 = myPolygon.get(i);
            Point2D.Double p2;

            if (i == myPolygon.size() - 1)
                p2 = myPolygon.get(0); 
            else
                p2 = myPolygon.get(i + 1);

            perimeter += p1.distance(p2);
            }
        return perimeter;
    }
    public double area() {
        // TODO: Calculate the area.
        Double area = 0.0;

        if (myPolygon.size() < 3)
            return 0.0;
        double sum = 0.0;

    for (int i = 0; i < myPolygon.size(); i++) {
        Point2D.Double p1 = myPolygon.get(i);
        Point2D.Double p2;

        if (i == myPolygon.size() - 1) {
            p2 = myPolygon.get(0);
        } else {
            p2 = myPolygon.get(i + 1);
        }

        sum += (p1.x * p2.y) - (p2.x * p1.y);
    }

    return Math.abs(sum) / 2.0;
    }

    public void draw()
    {
        // Wrap the DrawingTool in a try/catch to allow development without need for graphics.
        try {
             if (myPolygon.size() < 2)
            return;

            DrawingTool myDrawingTool = new DrawingTool(new SketchPad(500, 500));
            Point2D.Double firstPoint = myPolygon.get(0);
            myDrawingTool.up();
            myDrawingTool.move(firstPoint.x, firstPoint.y);
            myDrawingTool.down();
            for (int i = 1; i < myPolygon.size(); i++) {
                Point2D.Double point = myPolygon.get(i);
                myDrawingTool.move(point.x, point.y);
        }
            myDrawingTool.move(firstPoint.x, firstPoint.y);

        } catch (java.awt.HeadlessException e) {
            System.out.println("Exception: No graphics support available.");
        }
    }

}
