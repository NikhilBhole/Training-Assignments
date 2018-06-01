import java.util.Scanner;

import javax.swing.JOptionPane;

public class InputAndOutput {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		System.out.println("enter int value ");
		int num = sc.nextInt();
		System.out.println("value = "+num);
		
		System.out.println("enter float value ");
		float num2 = sc.nextFloat();
		System.out.println("value = "+num2);
		
		System.out.println("enter your name ");
		String str = sc.next();
		System.out.println("value = "+str);
		
		sc.nextLine();
		
		System.out.println("enter line ");
		String str1 = sc.nextLine();
		System.out.println("value = "+str1);		
		
		
	}

}
