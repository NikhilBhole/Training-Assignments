package interfacedemo;

public class TestInterface {

	public static void main(String[] args) {

		Shape shape = new Rectangle();
		shape.draw();
		
		Shape shape1 = new Circle();
		shape1.draw();
	}

}
