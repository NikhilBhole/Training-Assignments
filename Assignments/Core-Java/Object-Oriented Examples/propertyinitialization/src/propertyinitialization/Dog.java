package propertyinitialization;

public class Dog {

	public int age = 2;
	
	public void eat() {
		System.out.println("age is : "+age);
	}
}

class Test{
	
	public static void main(String[] args) {
		
		Dog d1 = new Dog();
		d1.eat();
		
		Dog d2 = new Dog();
		d2.age = 5;
		d2.eat();
	}
}
