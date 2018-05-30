package inheritancewithsuper;


public class Animal {

	public String name;
	
	public Animal() {}
	
	public Animal(String name) {
		this.name = name;
	}
	
	public void eat(){
		System.out.println("animal eating.   name: "+this.name);
	}
	public void run(){
		System.out.println("animal running.   name: "+this.name);
	}
}

class Dog extends Animal{
	
	public int age;
	
	public Dog() {}
	
	public Dog(int age, String name) {
		super(name);
		this.age = age;
	}
	public void bark(){
		System.out.println("Dog id barking.  age: "+this.age);
	}
}

class TestInheritance{
	
	public static void main(String[] args) {
		
		Dog a1 = new Dog(10,"tommy");		
		a1.eat();
		a1.run();
		a1.bark();
		

	}
}
