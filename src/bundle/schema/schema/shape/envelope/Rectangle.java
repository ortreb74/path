package bundle.schema.schema.shape.envelope;

import bundle.schema.schema.basics.Point;
import bundle.schema.schema.shape.PointWidget;
import bundle.schema.schema.shape.Text;

public class Rectangle extends PointWidget {
	
	Integer width;
	Integer height;	
	
	private Point lowerConnector;
	private Point upperConnector;
	private Point rightConnector;
	private Point leftConnector;
		
	
	public Rectangle(Text text) {
		super("rect");
		
		//attributes.put("fill", "white");
		attributes.put("stroke", "black");
		attributes.put("fill-opacity", "0");
		
		width = text!=null ? text.getWidth() : 100;
		height = text!=null ? text.getHeight() : 20;
		
		attributes.put ("height", height.toString());
		attributes.put ("width", width.toString());
	}

	@Override
	public void setPosition(Integer x, Integer y) {	
		upperConnector = new Point(x, y + getUpperOffset());
		lowerConnector = new Point(x, y + getLowerOffset());
		rightConnector = new Point(x + width/2, y);
		
		x = x - width / 2;
		y = y - getUpperOffset();
		super.setPosition(x, y);
	}
	
	private Integer getUpperOffset() {
		return -16 * height/20;
	}

	private Integer getLowerOffset() {
		return 4 * height/20;
	}

	@Override
	public void setPosition(Point point) {
		Integer x = point.x; 
		Integer y = point.y;
		
		x = x - width / 2;
		y = y+getUpperOffset();
		
		upperConnector = new Point(point.x,y);
		lowerConnector = new Point(point.x,y+height);	
		rightConnector = new Point(point.x+width/2,y+height/2);
		leftConnector = new Point(point.x-width/2,y+height/2);
		
		
		super.setPosition(x, y);
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
