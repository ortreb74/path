package bundle.schema.schema.shape.envelope;

import bundle.schema.schema.basics.Point;
import bundle.schema.schema.shape.PointWidget;
import bundle.schema.schema.shape.Text;

public class Elipse extends PointWidget {
	
	Integer width;
	Integer height;
	
	private Point lowerConnector;
	private Point upperConnector;
	private Point rightConnector;
	private Point leftConnector;
		
	
	public Elipse(Text text) {
		super("path");
		
		//attributes.put("fill", "white");
		attributes.put("stroke", "black");
		attributes.put("fill-opacity", "0");
		
		width = text!=null ? text.getWidth() : 100;		
		height = text!=null ? text.getHeight() : 30; // *1.5 ?
		
		//attributes.put ("width", width.toString());
	}

	@Override
	public void setPosition(Integer x, Integer y) {	
		upperConnector = new Point(x,y-14);
		lowerConnector = new Point(x,y+6);		
		rightConnector = new Point(x+width/2,y);
		
		
		x = x - width / 2;
		y = y-14;
		super.setPosition(x, y);
	}
	
	@Override
	public void setPosition(Point point) {
		Integer x = point.x; 
		Integer y = point.y;
		
		attributes.put ("d", "M" + String.valueOf(x-width / 2) + "," + String.valueOf(y-height+getYOffset()) + " a20,20 0 0,0 0," + String.valueOf(height) + " h" + String.valueOf(width)+ " a20,20 0 0,0 0,-" + String.valueOf(height) + " h-" + String.valueOf(width));
		
		upperConnector = new Point(point.x,y-height+getYOffset());
		lowerConnector = new Point(point.x,y+getYOffset());	
		rightConnector = new Point(point.x+width/2 + 20,y-height+getYOffset()+height/2);
		leftConnector = new Point(point.x-width/2 - 20,y-height+getYOffset()+height/2);		
		
	}	
	
	private int getYOffset() {
		return 10;
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
	
	private Integer getUpperOffset() {
		return -4 * height/20;
	}

	private Integer getLowerOffset() {
		return 16 * height/20;
	}

}
