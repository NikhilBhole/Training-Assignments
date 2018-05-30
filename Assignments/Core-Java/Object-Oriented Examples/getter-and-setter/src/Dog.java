
public class Dog {

	public int age;
	public String name;
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		if(age > 0 ) {
			this.age = age;			
		}
		else {
			System.out.println("age should not be less than 0");
			throw new IllegalArgumentException("wrong value for age"+age);
		}
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public void eat() {
		System.out.println("Dog is eating.  name= "+this.getName()+" age= "+this.getAge());
	}
	
}

class Test{
	
	public static void main(String[] args) {
		
		Dog d1 = new Dog();
		d1.setAge(10);
		d1.setName("tommy");
		d1.eat();
	}
}