
public class Point {
	
	public int x;
	public int y;
	
	public Point() {
		this(1,1);
	}
	
	public Point(int x, int y) {
		System.out.println("------parameterized constructor called-------------");
		this.x = x;
		this.y = y;
	}
	
	public Point(Point p) {
		this(p.x,p.y);
	}
	
	public void displayPoint() {
		System.out.println("x = "+this.x+" y = "+this.y);
	}

}

class TestPoint{
	
	public static void main(String[] args) {
		
		Point p1 = new Point();
		p1.displayPoint();
		
		Point p2 = new Point(10, 20);
		p2.displayPoint();
		
		Point p3 = new Point(p2);
		p3.displayPoint();
		
		System.out.println(p1.hashCode());
		System.out.println(p2.hashCode());
		System.out.println(p3.hashCode());
	}
}
