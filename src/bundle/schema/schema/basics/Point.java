package bundle.schema.schema.basics;

public class Point {

	public Integer x;
	public Integer y;
	
	public Point(Integer x, Integer y) {
		this.x = x;
		this.y = y;
	}

	public Point goingDown() {		
		return new Point(x, y + 80);
	}

	public Point genPointDelta(int i, int j) {
		Point point = new Point(x + i, y + j);
		return point;
	}

}
