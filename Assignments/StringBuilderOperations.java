package retraining;

/**
 * date: 29-05-2018
 * this is StringBuilder class operations java program
 * @author Nikhil
 *
 */

public class StringBuilderOperations {

	public static void main(String[] args) {

		StringBuilder sb = new StringBuilder("Hello");
		System.out.println(sb);
		System.out.println(sb.toString());
		System.out.println(sb.length());
		
		sb.append(" Friends");
		System.out.println(sb);
		
		String s = sb.toString();
		System.out.println(s);
		
		System.out.println(sb.insert(5, " Dear"));
		
		System.out.println(sb.delete(0, 6));
		System.out.println(sb.deleteCharAt(sb.length()-1));
		
		System.out.println(sb.charAt(0));
		
		System.out.println(sb.reverse());
		System.out.println(sb.reverse());
		
		System.out.println(sb.replace(0, 4, "Hello"));
		
		String sub = sb.substring(6);
		System.out.println(sub);
		String sub2 = sb.substring(6, 9);
		System.out.println(sub2);
	}

}
