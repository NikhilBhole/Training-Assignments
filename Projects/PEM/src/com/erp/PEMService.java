package com.erp;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * this class contains most of the operation of PEM application
 * @author Nikhil
 *
 */
public class PEMService {
	
	/**
	 * this repository reference and call static method to create singleton object
	 */
	Repository repository = Repository.getRepository();
	
	/**
	 * this reportService reference are userd to call various different methods to calculate reports
	 */
	ReportService reportService = new ReportService();
	
	/**
	 * this is a standard input stream
	 */
	private Scanner in = new Scanner(System.in);
	
	/**
	 * this variable store the value of user choice
	 */
	private int choice;
	
	
	/**
	 * this is a default constructor which creates the default values by calling prepareDate method
	 */
	public PEMService() {
		preparedDate();
	}
	
	/**
	 * this method prepared PEM menu with switch case and infinite loop
	 */
	public void showMenu() {
		
		while(true) {
			printMenu();
			switch (choice) {
			case 1:
				onAddCategory();
				pressAnyKeyToContinue();
				break;
				
			case 2:
				onCategoryList();
				pressAnyKeyToContinue();
				break;
				
			case 3:
				onExpenseEntry();
				pressAnyKeyToContinue();
				break;
				
			case 4:
				onExpenseList();
				pressAnyKeyToContinue();
				break;
				
			case 5:
				onMonthlyExpenseList();
				pressAnyKeyToContinue();
				break;
				
			case 6:
				onYearlyExpenseList();
				pressAnyKeyToContinue();
				break;
				
			case 7:
				onCategorizedList();
				pressAnyKeyToContinue();
				break;
				
			case 0:
				onExit();
				break;
				
			default:
				break;
			}
			
		}
	}
	
	
	/**
	 * this method show menus
	 */
	public void printMenu() {
		
		System.out.println("----------PEM Menu------------");
		System.out.println("1. Add Category");
		System.out.println("2. Category List");
		System.out.println("3. Expense Entry");
		System.out.println("4. Expense List");
		System.out.println("5. Monthly Expense List");
		System.out.println("6. Yearly Expense List");
		System.out.println("7. Categorized Expense List");
		System.out.println("0. Exit");
		System.out.println("------------------------------");
		
		System.out.print("enter your choice :");
		choice = in.nextInt();
		in.nextLine();

	}
	
	/**
	 * this method hold the screen after processing request task and 
	 * wait for any char input to continue the menu
	 */
	public void pressAnyKeyToContinue() {
		
		try {
			System.out.println("press any key to continue...");
			System.in.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * this method used to add new category in list
	 */
	public void onAddCategory() {
		in.nextLine();
		System.out.print("enter category : ");
		String catName = in.nextLine();
		Category cat = new Category(catName);
		repository.catList.add(cat);
		System.out.println("category added...");
	}
	
	/**
	 * this method are print the category list
	 */
	public void onCategoryList() {
		System.out.println("list of category");
		List<Category> clist = repository.catList;
		for(int i = 0; i < clist.size(); i++) {
			Category c = clist.get(i);
			System.out.println((i+1)+". "+c.getName()+" "+c.getCategoryId());
		}
	}
	
	/**
	 * this method are used to add new expense entry in list
	 */
	public void onExpenseEntry() {
		System.out.println("enter details of expense...");
		onCategoryList();
		System.out.print("enter category : ");
		int catId = in.nextInt();
		Category selectedCat = repository.catList.get(catId-1);
		System.out.println("you choose category : "+selectedCat.getName());
		System.out.print("enter amount : ");
		float amount = in.nextFloat();
		in.nextLine();
		System.out.print("enter remark : ");
		String remark = in.nextLine();
		System.out.println("enter date (dd/mm/yyyy)");
		String dateAsString = in.nextLine();
		
		Date date = DateUtil.stringToDate(dateAsString);
		
		Expense expense = new Expense();
		expense.setCategoryId(selectedCat.getCategoryId());
		expense.setRemark(remark);
		expense.setDate(date);
		expense.setAmmount(amount);
		
		repository.expList.add(expense);
		System.out.println("expense added...");
		
	}
	
	/**
	 * this methos is used to show full list of expenses
	 */
	public void onExpenseList() {
		System.out.println("expense list..");
	
		List<Expense> expList = repository.expList;
		for(int i = 0; i<expList.size(); i++) {
		Expense expense = expList.get(i);
		String categoryName = reportService.getCategoryNameById(expense.getCategoryId());
		String dateAsString = DateUtil.dateToString(expense.getDate());
		System.out.println((i+1)+". "+categoryName+" "+expense+" "+dateAsString);
		}
		//TODO
	}
	
	
	/**
	 * this method is used to print expense on monthly based
	 */
	public void onMonthlyExpenseList() {
		System.out.println("monthly totle Expense....");
		Map<String, Float> resultMap = reportService.calculateMonthlyTotle();
		Set<String> keys = resultMap.keySet();
		Float total = 0.0F;
		for (String yearMonth : keys) {
			String[] arr = yearMonth.split(",");
			String year = arr[0];
			Integer monthNo = new Integer(arr[1]);
			String monthName = DateUtil.getMonthName(monthNo);
			Float exp = resultMap.get(yearMonth);
			total = total + exp;
			System.out.println(year+", "+monthName+": "+exp);
		}
		System.out.println("--------------------------");
		System.out.println("total Expenses : "+total);
	}
	
	/**
	 * this method is used to show expenses on yearly based
	 */
	public void onYearlyExpenseList() {
		System.out.println("yearly...");
		Map<Integer, Float> resultMap = reportService.calculateYearlyTotle();
		Set<Integer> years = resultMap.keySet();
		Float total = 0.0F;
		for (Integer year : years) {
			Float exp =  resultMap.get(year);
			total = total+exp;
			System.out.println(year+" : "+exp);
		}
		System.out.println("------------------------------");
		System.out.println("Total expenses : "+total);
	}
	
	/**
	 * this method is used to show expenses on category based
	 */
	public void onCategorizedList() {
		System.out.println("categorized...");
		Map<String, Float> resultMap = reportService.calculateCategorizedTotle();
		Set<String> keys = resultMap.keySet();
		Float total = 0.0F;
		for (String categoryName : keys) {
			Float exp = resultMap.get(categoryName);
			total = total + exp;
			System.out.println(categoryName+" : "+exp);
		}
		System.out.println("----------------------------");
		System.out.println("total expenses : "+total);
	}
	
	/**
	 * this method is used to exit the application
	 */
	public void onExit() {
		System.out.println("exit...");
		System.exit(0);
	}
	
	/**
	 * this method prepared default data of user
	 */
	public void preparedDate() {
		
		Category catParty = new Category("Party");
		delay();
		Category catShopping = new Category("Shopping");
		delay();
		Category catGift = new Category("Gift");
		delay();
		
		repository.catList.add(catParty);		
		repository.catList.add(catShopping);		
		repository.catList.add(catGift);
		
		Expense e1 = new Expense(catParty.getCategoryId(), 5000.0f, DateUtil.stringToDate("02/05/2016"), "party");
		delay();
		Expense e2 = new Expense(catParty.getCategoryId(), 500.0f, DateUtil.stringToDate("03/06/2016"), "party");
		delay();
		Expense e3 = new Expense(catShopping.getCategoryId(), 15000.0f, DateUtil.stringToDate("04/05/2017"), "marriage shopping");
		delay();
		Expense e4 = new Expense(catShopping.getCategoryId(), 5000.0f, DateUtil.stringToDate("02/05/2016"), "casual shopping");
		delay();
		Expense e5 = new Expense(catGift.getCategoryId(), 10000.0f, DateUtil.stringToDate("09/08/2016"), "gift to brother");
		delay();
		Expense e6 = new Expense(catGift.getCategoryId(), 6000.0f, DateUtil.stringToDate("07/06/2017"), "gift to son");
		delay();
		
		repository.expList.add(e1);
		repository.expList.add(e2);
		repository.expList.add(e3);
		repository.expList.add(e4);
		repository.expList.add(e5);
		repository.expList.add(e6);		
	}
	
	/**
	 * the method sleep thread for 10 ms
	 */
	private void delay() {
		
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
