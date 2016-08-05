package bundle.schema.schema.shape;

import bundle.schema.schema.Widget;
import bundle.schema.schema.basics.Point;

public class LineWidget extends Widget {

	public LineWidget(Point s, Point e) {
		super("line");
		attributes.put ("stroke", "black");
		attributes.put("x1", s.x.toString());
		attributes.put("x2", e.x.toString());		 
		attributes.put ("y1", s.y.toString());		
		attributes.put ("y2", e.y.toString());
	}

	@Override
	public Point getLowerConnector() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Point getUpperConnector() {
		// TODO Auto-generated method stub
		return null;
	}

}
