package com.erp;

import java.util.Date;
import java.util.Map;
import java.util.TreeMap;

/**
 * this class contains various method to calculate PEM app reports
 * @author Nikhil
 *
 */
public class ReportService {
	
	/**
	 * this is repository referance variable to refer existance instance of repository class
	 */
	private Repository repo = Repository.getRepository();
	
	/**
	 * this methos is calculate monthly expense 
	 * @return
	 */
	public Map<String, Float> calculateMonthlyTotle(){
		
		Map<String, Float> map = new TreeMap<>();
		for (Expense exp : repo.expList) {
			Date expDate = exp.getDate();
			String yearMonth = DateUtil.getYearAndMonth(expDate);
			if(map.containsKey(yearMonth)) {
				float totle = map.get(yearMonth);
				totle = totle + exp.getAmmount();
				map.put(yearMonth, totle);
			}
			else {
				map.put(yearMonth, exp.getAmmount());
			}
		}
		
		
		return map;
		
	}
	
	/**
	 * this methos is calculate yearly expense 
	 * @return
	 */
	public Map<Integer, Float> calculateYearlyTotle(){
		
		Map<Integer, Float> map = new TreeMap<>();
		for (Expense exp : repo.expList) {
			Date expDate = exp.getDate();
			Integer year = DateUtil.getYear(expDate);
			if(map.containsKey(year)) {
				float totle = map.get(year);
				totle = totle + exp.getAmmount();
				map.put(year, totle);
			}
			else {
				map.put(year, exp.getAmmount());
			}
		}
		
		
		return map;
		
	}
	
	/**
	 * this method calculate expense on category based
	 * @return
	 */
	public Map<String, Float> calculateCategorizedTotle(){
		
		Map<String, Float> map = new TreeMap<>();
		for (Expense exp : repo.expList) {
			Long categoryId = exp.getCategoryId();
			String categoryName = this.getCategoryNameById(categoryId);
			if(map.containsKey(categoryName)) {
				float totle = map.get(categoryName);
				totle = totle + exp.getAmmount();
				map.put(categoryName, totle);
			}
			else {
				map.put(categoryName, exp.getAmmount());
			}
		}
		
		
		return map;
		
	}
	
	/**
	 * this method is used to get category name
	 * @param categoryId as Long
	 * @return category name
	 */
	public String getCategoryNameById(long categoryId) {
		for (Category c : repo.catList) {
			if(c.getCategoryId() == categoryId) {
				return c.getName();
			}
		}
		return null;
	}

}
