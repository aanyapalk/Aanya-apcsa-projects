package polygon;
import java.awt.geom.*;
public class Main {
    public static void main(String [] args)
    {
        IrregularPolygon myPolygon = new IrregularPolygon();
        myPolygon.add (new Point2D.Double(0,0));
        myPolygon.add (new Point2D.Double(100,50));
        myPolygon.add (new Point2D.Double(100,0));
        myPolygon.add (new Point2D.Double(0,50));
        myPolygon.draw();

        TestSuite.run();

    }
    
}
