
public class Dog extends Animal {

	public Dog(String name) {
		super(name);
	}
	
	@Override
	public void run() {
		System.out.println("Dog is running.  name = "+super.name);
	}
	
	public void bark() {
		System.out.println("Dog is barking.   name = "+super.name);
	}
	
	

}
