package bundle.schema.schema.shape;

import bundle.schema.schema.shape.envelope.Disc;
import bundle.schema.schema.shape.envelope.Elipse;
import bundle.schema.schema.shape.envelope.Rectangle;

public class Text extends ComposedPointWidget {
	
	String name;
	Integer x;
	Integer y;
	
	Integer fontSize;
	private int height;
	
	public Text(String entityName) {
		super("text");
		
		this.name = entityName;
		
		attributes.put("text-anchor", "middle");
		
		fontSize = 8;
		height = 20;
		
		// decoration du 3 juillet		
		attributes.put("font-family", "Verdana");
		attributes.put("font-size", "35");
		fontSize = 20;
		height = 40;
		
		content = entityName;		
	}
	
	@Override
	public Integer getWidth() {		
		return name.length() * fontSize;
	}

	public void setEnvelope(String shape) {
		switch (shape) {
			case "step" : envelope = new Elipse(this); break;
			case "disc" : envelope = new Disc(this); break;
			default : envelope = new Rectangle(this);
		}
	}

	public int getHeight() {		
		return height;
	}

	public Integer getUpperOffset() {
		return -16 * getHeight() / 20;
	}

	public Integer getLowerOffset() {
		return 4 * getHeight() / 20;
	}

	public Integer getCenterOffset() {
		return -6 * getHeight() / 20;
	}

}
