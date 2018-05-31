
public class TestSingleton {

	public static void main(String[] args) {

		CompanyInformation com = CompanyInformation.getInstance();
		com.setName("ABC pvt. Ltd.");
		com.setSince("20-05-1995");
		com.setOwnerName("XYZ");
		com.setTotleEmployee(2500);
		
		System.out.println(com);
	}

}
