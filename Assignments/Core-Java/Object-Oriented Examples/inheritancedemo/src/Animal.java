
public class Animal {

	public String name;
	public void eat(){
		System.out.println("animal eating "+name);
	}
	public void run(){
		System.out.println("animal running "+name);
	}
}

class Dog extends Animal{
	
	public void bark(){
		System.out.println("Dog id barking ");
	}
}

class Cat extends Animal{
	
	public void bite(){
		System.out.println("Cat is biting ");
	}
}

class TestInheritance{
	
	public static void main(String[] args) {
		
		Dog a1 = new Dog();		
		a1.eat();
		a1.run();
		a1.bark();
		
		System.out.println();
		
		Cat c1 = new Cat();
		c1.eat();
		c1.run();
		c1.bite();
	}
}