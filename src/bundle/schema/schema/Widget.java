package bundle.schema.schema;

import java.util.HashMap;
import java.util.Map;

import bundle.schema.schema.basics.Point;
import bundle.schema.es.XMLWriter;

public abstract class Widget  {

	private String elementName;
	protected Map <String,String> attributes;
	protected String content;
	
	public abstract Point getLowerConnector();
	
	public abstract Point getUpperConnector();

	
	public Widget(String elementName) {
		attributes = new HashMap<String, String>();		
		this.elementName = elementName;
	}
	
	final public void toSvg(XMLWriter writer) {
		writer.startElement(elementName);
		
		for (Map.Entry<String, String> entry : attributes.entrySet()) writer.attribute (entry.getKey(), entry.getValue());
		
		if (content != null) writer.text(content);
		
		writer.endElement();		
	
	}
		
}
