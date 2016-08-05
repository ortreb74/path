package bundle.schema.schema.object;

import bundle.schema.schema.Schema;
/*
import schema.Sihem;
import schema.shape.Text;
*/


public class SchemaGWD extends Schema {

	protected int x;
	protected int y;
	
	public SchemaGWD() {
		super();
		x = 150;
		y = 50;
	}
	
	/*
	public void firstStone(String entityName) {
		Text text = new Text(entityName);
		text.setEnvelope("rectangle");
		text.setPosition(x, y);
		
		widgets.addAll(text.getWidget());
		
		activeConnector = text.getLowerConnector();
		
		y = y + 100;
	}

	public void addPartner(String entityName) {
		//widgets.add(new Sihem(250,y-14));
		
		Text text = new Text(entityName);
		text.setEnvelope("rectangle");
		text.setPosition(x, y);
		
		Sihem sihem = new Sihem(activeConnector, text.getUpperConnector());
		widgets.addAll (sihem.getWidgets());
		
		widgets.addAll(text.getWidget());
		
		activeConnector = text.getLowerConnector();
		
		y = y + 100;		
	}
	*/
	
}
