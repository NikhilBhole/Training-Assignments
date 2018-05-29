package stringdemos;

/**
 * date: 29-05-2018
 * this is java program of mutable class using StringBuilder class.
 * StringBuilder class is not synchronized and because of this it is not Thread-safe
 * @author Nikhil
 *
 */
public class MutableStringBuilder {

	public static void main(String[] args) {

		StringBuilder sb = new StringBuilder("hello");
		System.out.println("StringBuilder value= "+sb+"    hashcode= "+sb.hashCode());
		
		sb.append(" Friends");
		System.out.println("StringBuilder value= "+sb+"    hashcode= "+sb.hashCode());
		
		
	}

}
