package bundle.schema.schema.shape;

import bundle.schema.schema.Widget;
import bundle.schema.schema.basics.Point;

public abstract class PointWidget extends Widget {	
	
	Integer x;
	Integer y;
	protected String xName;
	protected String yName;
	
	
	public PointWidget(String elementName) {
		super(elementName);
		
		xName = "x";
		yName = "y";
	}
	
	public void setPosition(Integer x, Integer y) {
		this.x = x;
		this.y = y;
		
		attributes.put(xName, this.x.toString());
		attributes.put(yName, this.y.toString());
	}

	public void setPosition(Point point) {
		x = point.x;
		y = point.y;
		
		attributes.put(xName, this.x.toString());
		attributes.put(yName, this.y.toString());
		
	}
	
	public abstract Point getLowerConnector();
	
	public abstract Point getUpperConnector();

	public abstract Point getRightConnector();
	
	public abstract Point getLeftConnector();


	
	
}
