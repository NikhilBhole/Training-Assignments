package objectorienteddemos;

public class Dog {
	
	public int age;
	public String name;
	
	
	
	
	public void eat() {
		System.out.println("Dog is eating. name= "+name+" age= "+age);
	}
}

class Test {

	public static void main(String[] args) {

		Dog d1 = new Dog();
		d1.age = 10;
		d1.name = "tommy";
		d1.eat();
		
		Dog d2 = new Dog();
		d2.age = 15;
		d2.name = "sizu";
		d2.eat();
		
		Dog d3 = d2;
		d3.eat();
		
		System.out.println(d1.hashCode());
		System.out.println(d2.hashCode());
		System.out.println(d3.hashCode());
	}

}
