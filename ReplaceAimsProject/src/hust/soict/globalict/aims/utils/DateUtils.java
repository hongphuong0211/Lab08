package hust.soict.globalict.aims.utils;

public class DateUtils {

	public static int CompareDates(MyDate date1, MyDate date2) {
		if(date1.getYear() > date2.getYear()) return 1;
		else if(date1.getYear() < date2.getYear()) return -1;
		else {
			if(date1.getMonth() > date2.getMonth()) return 1;
			else if(date1.getMonth() < date2.getMonth()) return -1;
			else {
				if(date1.getDay() > date2.getDay()) return 1;
				else if(date1.getDay() < date2.getDay()) return -1;
				else return 0;
			}
		}
	}
	
	public static void SortDates(MyDate[] date) {
		for(int i = 0; i < date.length; i++) {
			for(int j = i + 1; j < date.length; j++) {
				if(CompareDates(date[i], date[j]) > 0) {
					MyDate tmp = new MyDate(date[i].getDay(), date[i].getMonth(), date[i].getYear());
					date[i].setDay(date[j].getDay());
					date[i].setMonth(date[j].getMonth());
					date[i].setYear(date[j].getYear());
					date[j].setDay(tmp.getDay());
					date[j].setMonth(tmp.getMonth());
					date[j].setYear(tmp.getYear());
				}
			}
		}
	}

}
