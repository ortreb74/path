package bundle.schema.schema;

import bundle.schema.schema.basics.Point;
import bundle.schema.schema.shape.LineWidget;

public class RightSihem extends Sihem {

	public RightSihem(Point s, Point e) {
		super();
				
		lines.add(new LineWidget(s,e));				
		
		Point deux  = new Point(e.x - 5, e.y - 5);
		Point trois = new Point(e.x - 5, e.y + 5);
		
		lines.add(new LineWidget(deux,e));
		lines.add(new LineWidget(trois,e));
	}

}
