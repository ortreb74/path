package bundle.schema.schema;

import bundle.schema.schema.basics.Point;
import bundle.schema.schema.shape.PointWidget;
import bundle.schema.schema.shape.Text;

public class SchemaStudio extends Schema {

	PointWidget connectingWidget;
	private String state;
	
	public SchemaStudio() {
		super();
		state = "";

	}	
	
	public void place(String entityName, Point point) {
		place(entityName, "rectangle", point);
		
	}

	public void place(String entityName, String envelopeId, Point point) {
		//ComposedPointWidget composedPointWidget = getForm(content);		
		
		Text text = new Text(entityName);
		text.setEnvelope(envelopeId);
		text.setPosition(point);
		
		widgets.addAll(text.getWidgets());
		
		//activeConnector = text.getLowerConnector();
		connectingWidget = text.getEnvelope();
	}	

	public void next(String entityName) {
		next (entityName, "rectangle");
		
	}

	public void next(String entityName,  String envelopeId) {
		Text text = new Text(entityName);
		text.setEnvelope(envelopeId);
		text.setPosition(getNextRelativePosition());
		
		Sihem sihem;
		
		if (rState()) {		
			sihem = new RightSihem(getActiveConnector() , text.getLeftConnector());
		} else {
			sihem = new DownSihem(getActiveConnector() , text.getUpperConnector());
		}
		
		widgets.addAll (sihem.getWidgets());
		
		widgets.addAll(text.getWidgets());
		
		//activeConnector = text.getLowerConnector();
		connectingWidget = text.getEnvelope();
		
		unsetRState();
		
	}
	
	public void near(String entityName, String envelopeId) {
		Text text = new Text(entityName);
		text.setEnvelope(envelopeId);
		text.setPosition(getActiveConnector().genPointDelta(0, 50));
		
		Sihem sihem;
		
		if (rState()) {		
			sihem = new RightSihem(getActiveConnector() , text.getLeftConnector());
		} else {
			sihem = new DownSihem(getActiveConnector() , text.getUpperConnector());
		}
		
		widgets.addAll (sihem.getWidgets());
		
		widgets.addAll(text.getWidgets());
		
		//activeConnector = text.getLowerConnector();
		connectingWidget = text.getEnvelope();
		
		unsetRState();
		
	}

	public Point getNextRelativePosition() {	
		// ce 12 est douteux
		if (rState()) return getActiveConnector().genPointDelta(200, 12);
		
		//return getActiveConnector().genPointDelta(0, 50);
		return getActiveConnector().genPointDelta(0, 150);
	}
	

	public void setRState() {
		state = "R";		
	}
	
	private Point getActiveConnector() {
		if (rState()) return connectingWidget.getRightConnector();
		return connectingWidget.getLowerConnector();
	}

	private void unsetRState() {
		state = "";
	}

	private boolean rState() {		
		return state.equals("R");
	}


}
