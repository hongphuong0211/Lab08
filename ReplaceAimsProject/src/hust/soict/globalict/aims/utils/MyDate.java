package hust.soict.globalict.aims.utils;

import java.util.Scanner;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyDate {
	private final String[] Month = new String[] { "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" };
	private final String[] Day = new String[] {"first", "second", "third", "fourth", "fifth", "sixth", "seventh", "eighth", "ninth", "tenth", "eleventh", "twelfth", "thirteenth", "fourteenth","fifteenth", "sixteenth", "seventeenth", "eighteenth", "nineteenth", "twentieth", "twenty first", "twenty second", "twenty third", "twenty fourth", "twenty fifth", "twenty sixth", "twenty seventh", "twenty eighth", "twenty ninth", "thirtieth", "thirty first"};
	private final String[] Number = new String[] {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen", "twenty", "een", "y", "hundred", "thousand", "milion", "bilion", "thirdty", "fifty", "and"};

	Scanner keyboard = new Scanner(System.in);
	private int day;
	private int month;
	private int year;
	public MyDate() {
		// TODO Auto-generated constructor stub
	}
	
	public MyDate(int day, int month, int year) {
		super();
		this.day = day;
		this.month = month;
		this.year = year;
	}
	
	public MyDate(String day, String month, String year) {
		day = day.trim();
		month = month.trim();
		year = year.trim();
		for(int i = 0; i < 31; i++) {
			if(day.equalsIgnoreCase(Day[i])) {
				this.day = i+1;
				break;
			}
		}
		for(int i = 0; i < 12; i++) {
			if(month.equalsIgnoreCase(Month[i])) {
				this.month = i+1;
				break;
			}
		}
		String j = null;
		int l = 0;
		while(year != null) {
			for(int i = 0; i < 30; i++) {
				if(year.startsWith(Number[i])) {
					if(i < 10) {
						if(l == 0)
							j += Integer.toString(i);
						else {
							j = "null" + Integer.toString(Integer.parseInt(j.substring(4)) + i);
							l--;
						}
					}else if(i == 10) {
						if(l == 0)
							j += Integer.toString(i);
						else {
							j = "null" + Integer.toString(Integer.parseInt(j.substring(4)) + i);
							l = 0;
						}
					}else if(i <= 20) {
						if(l < 2)
							j += Integer.toString(i);
						else {
							j = "null" + Integer.toString((Integer.parseInt(j.substring(4)) / 10 * 10) + i);
						}
						if( i == 20) l = 1;
					}else if(i == 21){
						if(l > 1) {
							if(j.length() > 1)
								j = j.substring(0, j.length() - 2) + Integer.toString(1) + j.substring(j.length() - 1); 
							else j = Integer.toString(1) + j;
						}else {
							if(j.length() > 1)
								j = j.substring(0, j.length() - 1) + Integer.toString(1) + j.substring(j.length() - 1); 
							else j = Integer.toString(1) + j;
						}
					}else if(i == 22) {
						if(l > 0)
							j = "null" + Integer.toString(Integer.parseInt(j.substring(4)) / 10 * 10 + (Integer.parseInt(j.substring(4)) % 10) * 10);
						else if(l == 0) {
							System.out.println(j);
							if(Integer.parseInt(j.substring(4)) / 10 / 100 == 0) j = "null" + Integer.toString(Integer.parseInt(j.substring(4)) / 10 * 100 + (Integer.parseInt(j.substring(4)) % 10) * 10);
							else j = "null" + Integer.toString(Integer.parseInt(j.substring(4)) / 10 * 10 + (Integer.parseInt(j.substring(4)) % 10) * 10);
						}
						l = 1;
					}else if(i == 27){
						if(l > 1) j = "null" + Integer.toString(Integer.parseInt(j.substring(4)) + 30);
						else j += "30";
						l = 1;
					}else if(i == 28) {
						if(l > 1) j = "null" + Integer.toString(Integer.parseInt(j.substring(4)) + 50);
						else j += "50";
						l = 1;
					}else if(i == 29) {
						l = 1;
					}else {
						int k = (Integer.parseInt(j.substring(4)) % 10) * (int) Math.pow(10, i - 21);
						j = "null" + Integer.toString(Integer.parseInt(j.substring(4)) / 10 * 10 + k);
						l = i - 21;
					}
					if(Number[i].length() < year.length()) year = year.substring(Number[i].length() + 1);
					else year = null;
					break;
				}
			}
		}
		this.year = Integer.parseInt(j.substring(4));
		
	}
	
	public MyDate(String day, String month, int year) {
		for(int i = 0; i < 31; i++) {
			if(day.equalsIgnoreCase(Day[i])) {
				this.day = i+1;
				break;
			}
		}
		for(int i = 0; i < 12; i++) {
			if(month.equalsIgnoreCase(Month[i])) {
				this.month = i+1;
				break;
			}
		}
		this.year = year;
	}
	
	public MyDate(int day, String month, int year) {
		this.day = day;
		this.year = year;
		for(int i = 0; i < 12; i++) {
			if(month.equalsIgnoreCase(Month[i])) {
				this.month = i+1;
				break;
			}
		}
	}
		
	public MyDate(String myDate) {
		super();
		for(int i = 0; i < 12; i++) {
			if(myDate.startsWith(Month[i])) {
				int endMonth = Month[i].length();
				int startTH = myDate.indexOf("th");
				this.month = i + 1;
				this.day = Integer.parseInt(myDate.substring(endMonth + 1, startTH));
				this.year = Integer.parseInt(myDate.substring(startTH + 3));
				break;
			}
		}
	}
	
	

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
	
	public void accept() {
		System.out.println("Enter a date: ");
		String date = keyboard.nextLine();
		String[] Month = new String[] { "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" };
		for(int i = 0; i < 12; i++) {
			if(date.startsWith(Month[i])) {
				int endMonth = Month[i].length();
				int startTH = date.indexOf("th");
				this.month = i + 1;
				this.day = Integer.parseInt(date.substring(endMonth + 1, startTH));
				this.year = Integer.parseInt(date.substring(startTH + 3));
				break;
			}
		}
	}
	
	public void print() {
		System.out.println("Current date: " + Month[this.month - 1] + " " + this.day + ((this.day == 1 || this.day == 31)?"st":(this.day == 2)?"nd":(this.day == 3)?"rd":"th") + " " + this.year);
	}

	public void print(String s) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(s);
		SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			date = ft.parse(Integer.toString(this.year) + "-" + Integer.toString(this.month) + "-" + Integer.toString(this.day));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String date1 = simpleDateFormat.format(date);
		System.out.println(date1);
		
	}
}
