package bundle.schema.schema.shape;

import java.util.ArrayList;
import java.util.List;

import bundle.schema.schema.Widget;
import bundle.schema.schema.basics.Point;

public abstract class ComposedPointWidget extends PointWidget {

	PointWidget envelope;
	
	public ComposedPointWidget(String elementName) {
		super(elementName);	
	}
	
	@Override
	public void setPosition(Integer x, Integer y) {
		super.setPosition(x,y);
		envelope.setPosition (x ,y);
	}
	
	public PointWidget getEnvelope() {		
		return envelope;
	}

	public Point getLowerConnector() {		
		return envelope.getLowerConnector();
	}

	@Override
	public Point getUpperConnector() {
		return envelope.getUpperConnector();
	}

	@Override
	public Point getRightConnector() {
		return envelope.getRightConnector();
	}

	@Override
	public Point getLeftConnector() {
		return envelope.getLeftConnector();
	}	
	
	public List<Widget> getWidgets() {
		ArrayList<Widget> result = new ArrayList<Widget>();		
		result.add(envelope);
		result.add(this);
		return result;
	}

	public void setPosition(Point point) {
		super.setPosition(point);
		envelope.setPosition (point);		
	}	

	public abstract Integer getWidth() ;

}
