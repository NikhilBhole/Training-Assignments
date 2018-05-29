package stringdemos;

/**
 * date: 29-05-2018
 * this is java program of String class operations
 * @author Nikhil
 *
 */

public class StringOperationsDemo {

	public static void main(String[] args) {

		String s = "Hello Friends";
		
		System.out.println(s);
		System.out.println(s.length());
		System.out.println(s.toUpperCase());
		System.out.println(s.toLowerCase());
		System.out.println(s.charAt(6));
		System.out.println(s.indexOf("F"));
		System.out.println(s.indexOf("e"));
		System.out.println(s.lastIndexOf("e"));
		System.out.println(s.substring(6));
		System.out.println(s.substring(6, 9));
		System.out.println(s.replace("e", "X"));
		System.out.println(s);
		System.out.println(s.concat(" Welcome to java"));
		System.out.println(s.contains("Hello"));
		
		String ss = s+" Welcome to java";
		System.out.println(ss);
		
		String s2 = "p1,p2,p3,p4,p5";
		String[] arr = s2.split(",");
		for(int i = 0;i<arr.length; i++){
			System.out.println(arr[i]);
		}
		
		String s3 = "";
		System.out.println(s3.length());
		System.out.println(s3.isEmpty());
		
		System.out.println(s2.contains("p3"));
		System.out.println(s2.contains("p7"));
		
		System.out.println(s.startsWith("Hello"));
		System.out.println(s.endsWith("s"));
	}

}
