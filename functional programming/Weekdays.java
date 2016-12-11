package bwi.prog1B.WS1617.wi16b027_Can.ExerciseSheet03;

import bwi.prog.utils.TextIO;

public class Weekdays {

	public static void main(String[] args) {
		TextIO.putln("enter date (yyyymmdd)");
		
		int date = TextIO.getInt();
		int inDay = date % 100, inMonth = date % 10000 / 100, inYear = date / 10000;
		
		if(validate(inYear, inMonth, inDay)){
			int W = weekday(inDay, inMonth, inYear);
			String weekday = dayName(W);
			TextIO.putf("%02d.%02d.%4d was/is or will be a %s", date % 100, date % 10000 / 100, date / 10000, weekday);
		}else {
			TextIO.putf("invalid date (%d)\n", date);
		}
	}
	
	
	// Checks if given year is between 1582 and 2199
	public static boolean validate(int year) {
		if(year >= 1582 && year <= 2199) {
			return true;
		}
		return false;
	}
	
	// Checks if a given month is valid (1-12)
	// and if the year is 1582, if the month is valid (>=10)
	public static boolean validate(int year, int month) {
		if(month > 0 && month <= 12) {
			if(year == 1582 && month < 10) {
				return false;
			}
			return true;
		}
		return false;
	}
	
	// Checks if a given year is a leap year
	public static boolean isLeap(int inYear) {
		if(inYear % 4 == 0) {
			if(inYear % 100 == 0) {
				if(inYear % 400 == 0) {
					return true;
				} else {
					return false;
				}
			} else {
				return true;
			}
		} else {
			return false;
		}
	}
	
	// Returns the number of days in a month
	public static int nDays(int month, int year) {
		String days = "312831303130313130313031";
		int monthDays = 0;
		
		if(month == 1) {
			monthDays = Integer.parseInt(days.substring(0, 2));
		} else {
			monthDays = Integer.parseInt(days.substring(month*2 - 2, month*2));
			if(month == 2 && isLeap(year)) {
				monthDays += 1;
			}
		}
		
		return monthDays;
	}
	
	// Checks if a given year is valid
	// Valid dates are between Oct 15th 1582 and Dec 31st 2199
	public static boolean validate(int year, int month, int day) {
		if(validate(year)) {
			if(validate(year, month)) {
				if(year == 1582 && month == 10 && day < 16) {
					return false;
				} else if(day <= nDays(month, year)) {
					return true;
				}
				return false;
			}
			return false;
		}
		return false;
	}
	
	// Calculates the weekday according to Gauss' formula
	public static int weekday(int inDay, int inMonth, int inYear) {
		int d, c, y, m;
		int A;
		d = inDay;
		y = inYear % 100;
		c = (inYear - y) / 100;
		
		// Month:
		// 1    2    3    4    5    6    7    8    9    10   11   12
		// Mar  Apr  May  Jun  Jul  Aug  Sep  Oct  Nov  Dec  Jan  Feb
		if(inMonth < 3) {
			m = 10 + inMonth;
			if(y == 0) {
				y = 99;
				c -= 1;
			} else {
				y -= 1;
			}
		} else {
			m = inMonth - 2;
		}
		
		// Gauss' Formula
		A = d + (int)(2.6 * m - 0.2) + y + (y/4) + (c/4) - 2 * c;
		
		while(A < 0 || A > 7) {
			if(A < 0) {
				A = A + 7;
			} else {
				A = A % 7;
			}
		}
		return A;		
	}
	
	
	// Returns the weekday of a number according to the table
	// 0   1   2   3   4   5   6
	// Sun Mon Tue Wed Thu Fri Sat
	public static String dayName(int W) {
		switch(W) {
			case 0:
				return "Sunday";
			case 1:
				return "Monday";
			case 2:
				return "Tuesday";
			case 3:
				return "Wednesday";
			case 4:
				return "Thursday";
			case 5:
				return "Friday";
			case 6:
				return "Saturday";
			default:
				return "False";
		}
	}

}
