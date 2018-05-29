package retraining;

/**
 * date: 29-05-2018
 * this is simple String compare java program
 * @author Nikhil
 *
 */
public class StringCompareDemo {

	public static void main(String[] args) {

		String s1 = "Hello";
		String s2 = new String("Hello");
		
		char[] arr = new char[] {'H','e','l','l','o'};
		String s3 = new String(arr);
	
		// Reference comparison
		System.out.println(s1 == s2);
		System.out.println(s2 == s3);
		System.out.println(s3 == s1);
		
		// value comparison
		System.out.println(s1.equals(s2));
		System.out.println(s2.equals(s3));
		System.out.println(s3.equals(s1));
		
		String s4 = s3;
		System.out.println(s3 == s4);
		System.out.println(s3.equals(s4));
	}

}
