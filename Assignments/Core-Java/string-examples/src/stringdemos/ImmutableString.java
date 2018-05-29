package stringdemos;

/**
 * date: 29-05-2018
 * this is java program for immutable String demo
 * @author Nikhil
 *
 */

public class ImmutableString {

	public static void main(String[] args) {

		String s1 = "Hello";
		String s2 = "Friends";
		
		System.out.println("String s1 : "+s1+"   hashcode : "+s1.hashCode());
		
		s1 = s1+s2;
		
		System.out.println("String s1 : "+s1+"   hashcode : "+s1.hashCode());
	}

}
