package bundle.schema.schema.object;

import bundle.schema.schema.Schema;
import bundle.schema.schema.DownSihem;
import bundle.schema.schema.basics.Point;
import bundle.schema.schema.shape.Text;


public class SchemaFirstList extends Schema {

	int x;
	int y;
	
	Point activeConnector;
	
	public SchemaFirstList() {
		super();
		x = 250;
		y = 50;
	}
	
	
	public void firstStone(String entityName) {
		Text text = new Text(entityName);
		text.setEnvelope("rectangle");
		text.setPosition(x, y);
		
		widgets.addAll(text.getWidgets());
		
		activeConnector = text.getLowerConnector();
		
		y = y + 100;
	}

	public void addPartner(String entityName) {
		//widgets.add(new Sihem(250,y-14));
		
		Text text = new Text(entityName);
		text.setEnvelope("rectangle");
		text.setPosition(x, y);
		
		DownSihem sihem = new DownSihem(activeConnector, text.getUpperConnector());
		widgets.addAll (sihem.getWidgets());
		
		widgets.addAll(text.getWidgets());
		
		activeConnector = text.getLowerConnector();
		
		y = y + 100;		
	}
	
}
