package bundle.schema.schema.shape.envelope;

// ce package contient des PointWidget
import bundle.schema.schema.basics.Point;
import bundle.schema.schema.shape.PointWidget;
import bundle.schema.schema.shape.Text;

/**
 * Created by pierre donzel on 28/07/2016.
 */

public class Disc extends PointWidget {

    //^C^V = factoriser

    private Point lowerConnector;
    private Point upperConnector;
    private Point rightConnector;
    private Point leftConnector;

    Integer radius;

    Integer size;
    Integer offset;

    // je ne sais pas ce que je dois mettre dans elementName
    // c'est le nom SVG
    public Disc(Text text) {
        // model : <circle cx="600" cy="200" r="100" fill="red" stroke="blue" stroke-width="10"  />
        super("circle");
        // pourrait être factorisé
        attributes.put("stroke", "black");
        attributes.put("fill-opacity", "0");
        // le point se nomme cx,cy ce qui n'est pas normal
        xName = "cx";
        yName = "cy";
        // le rayon est fonction de la taille du texte
        size = text!=null ? text.getWidth() : 100;
        offset = text.getCenterOffset();
        setK(0.6);
    }

    public void setK(Double k) {
        k = k * size;
        radius = k.intValue();
        attributes.put("r", String.valueOf(radius));
    }

    @Override
    public void setPosition(Point point) {
        Point center = new Point(point.x, point.y + offset);

        upperConnector = new Point(center.x , center.y - radius);
        lowerConnector = new Point(center.x , center.y + radius);
        rightConnector = new Point(center.x + radius, center.y);
        leftConnector = new Point(center.x - radius, center.y);

        super.setPosition(center);
    }

    @Override
    public Point getLowerConnector() {
        return lowerConnector;
    }

    @Override
    public Point getUpperConnector() {
        return upperConnector;
    }

    @Override
    public Point getRightConnector() {
        return rightConnector;
    }

    @Override
    public Point getLeftConnector() {
        return leftConnector;
    }
}
