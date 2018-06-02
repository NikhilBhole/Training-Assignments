package com.erp;

/**
 * This class are the starting point of our PERSONAL EXPENSE MANAGER Application
 * @author Nikhil
 *
 */

public class StartApp {
	
	/**
	 * this method create <code>PEMService</code> object and 
	 * show app menu by calling showMenu method of PEMService class
	 * @param args
	 */
	public static void main(String[] args) {
		
		PEMService service = new PEMService();
		service.showMenu();

	}

}
