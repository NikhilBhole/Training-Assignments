
public class TestPizza {

	public static void main(String[] args) {

		Pizza pizza = new Pizza.Builder(12)
				 .addCheese()
				 .addPepperoni()
				 .addBacon()
				 .build();
		
		System.out.println(pizza);
	}

}
