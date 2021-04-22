package hust.soict.globalict.test.utils;

import java.util.Scanner;

import hust.soict.globalict.aims.utils.DateUtils;
import hust.soict.globalict.aims.utils.MyDate;

public class DateTest {
	public static Scanner keyboard = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyDate date1 = new MyDate();
		date1.setDay(31);
		date1.setMonth(12);
		date1.setYear(1999);
		date1.print();
		
		MyDate date2 = new MyDate(12, 12, 2001);
		date2.print();
		
		MyDate date3 = new MyDate("February 12th 2045");
		date3.print();
		
		MyDate date4 = new MyDate("twenty ninth", "November", "one thousand five hundred fifty one");
		date4.print();
		String s = keyboard.nextLine();
		date4.print(s);
		
		MyDate[] date = new MyDate[] {date1, date2, date3, date4};
		System.out.println(DateUtils.CompareDates(date1, date2));
		for(int i = 0; i < date.length; i++) {
			date[i].print();
		}
		DateUtils.SortDates(date);
		for(int i = 0; i < date.length; i++) {
			date[i].print();
		}	
	}

}
