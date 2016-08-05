package bundle.schema.schema;

import java.util.ArrayList;
import java.util.List;

public class Lines  {

	List<String> lines;
	
	public Lines(String text) {
		lines = new ArrayList<String>();
		lines.add(text);
	}

}
