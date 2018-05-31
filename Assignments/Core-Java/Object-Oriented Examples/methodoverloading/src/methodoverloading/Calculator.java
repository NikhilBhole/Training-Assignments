package methodoverriding;

public class Calculator {
	
	public void add(int a, int b) {
		System.out.println("Int addition = "+(a+b));
	}
	public void add(float a, float b) {
		System.out.println("Float addition = "+(a+b));
	}
	public void add(int a, float b) {
		System.out.println("Int and Float addition = "+(a+b));
	}
	public void add(float a, int b) {
		System.out.println("Float and Int addition = "+(a+b));
	}
	

	public static void main(String[] args) {

		Calculator cal = new Calculator();
		cal.add(10, 20);
		cal.add(10.5f, 20.5f);
		cal.add(10.5f, 20);
		cal.add(10, 20.5f);
	}

}
