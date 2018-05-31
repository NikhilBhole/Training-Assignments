
public abstract class Animal {

	public String name;
	
	
	public Animal(String name) {

		this.name = name;
	}
	
	public abstract void run();
	public abstract void bark();
	
	public void eat() {
		System.out.println("Animal is eating..  name = "+this.name);
	}
}
