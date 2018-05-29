package retraining;

/**
 * date: 29-05-2018
 * this is java program of mutable String using StringBuffer class.
 * StringBuffer class is Synchronized class and because of this StringBuffer class is Thread-safe.
 * if one thread is manipulating with object, other thread is waiting outside lock
 * @author Nikhil
 *
 */
public class MutableStringBuffer {

	public static void main(String[] args) {
		
		StringBuffer sb = new StringBuffer("hello");
		System.out.println("StringBuffer value= "+sb+"    hashcode= "+sb.hashCode());
		
		sb.append(" Friends");
		System.out.println("StringBuffer value= "+sb+"    hashcode= "+sb.hashCode());

	}

}
