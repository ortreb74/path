package bundle.schema.schema;

import java.util.ArrayList;
import java.util.List;

import bundle.schema.es.XMLWriter;

public class Schema {
	
	//protected Point activeConnector;
	
	protected List<Widget> widgets;
	
	public Schema() {
		widgets = new ArrayList<Widget>();		
	}

	public void toSvg(String fileName) {
		XMLWriter xmlWriter = new XMLWriter();
		
		xmlWriter.startSvgDocument(fileName);
		
		for (Widget widget : widgets) widget.toSvg(xmlWriter);
		
		xmlWriter.close();

		
	}

}
