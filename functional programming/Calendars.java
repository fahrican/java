package homework.woche4;

import java.util.Scanner;

public class Calendars {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		int year = 1970, month = 1, day = 1;
		int option;

		do {
			System.out.printf("Current date: %02d.%02d.%4d\n", day, month, year);
			System.out.print("enter option: ");
			option = scan.nextInt();
			System.out.println();
			switch (option) {

			case 1:
				System.out.printf("isLeap(year): %d\n", isLeap(year));
				break;

			case 2:
				System.out.printf("daysInMonth(year, month): %d\n", daysInMonth(year, month));
				break;

			case 3:
				System.out.printf("checkDate1(year): %d\n", checkDate1(year));
				System.out.printf("checkDate2(year, month): %d\n", checkDate(year, month));
				System.out.printf("checkDate3(year, month, day): %d\n", checkDate(year, month, day));
				break;

			case 7:
				System.out.printf("ymd2w(year, month, day): %d\n", ymd2w(year, month, day));
				break;

			case 8:
				System.out.printf("dayNumber(year, month, day): %d\n", dayNumber(year, month, day));
				break;

			case 9:
				System.out.printf("weekNumber(year, month, day): %d\n", weekNumber(year, month, day));
				break;

			case 20:
				System.out.print("printStatistics: ");
				printStatistics(year, month, day);
				System.out.println();
				break;

			case 21:
				System.out.println("printCalendar(year, month, day, 0):");
				printCalendar(year, month, day, 1);
				System.out.println();
				break;

			default:
				break;
			}
			System.out.println();

		} while (option != 666);
		scan.close();

	}

	static int isLeap(int year) {

		if (year < 1582) {
			return -1;
		}

		if (year % 4 == 0 && year % 100 == 0 && year % 400 == 0) {
			return 1;
		} else if (year % 4 == 0 && year % 100 != 0 && year % 400 == 0) {
			return 1;
		} else if (year % 4 == 0 && year % 100 != 0) {
			return 1;
		} else if (year % 100 == 0 && year % 400 != 0) {
			return 0;
		} else {
			return 0;
		}
	}

	static int daysInMonth(int year, int month) {

		if (month == 2 && isLeap(year) == 1) {
			return 29;
		} else if (month == 2) {
			return 28;
		} else if (month == 8 || month == 10 || month == 12 || month % 2 != 0) {
			return 31;
		} else if (month == 9 || month == 11 || month % 2 == 0) {
			return 30;
		}
		return -1;

	}

	static int checkDate1(int year) {

		if (year >= 1582 && year <= 2199) {
			return 1;
		}
		return 0;
	}

	static int checkDate(int year, int month) {

		if (checkDate1(year) == 1) {

			if (year == 1582 && month >= 10 && month <= 12) {
				return 1;
			} else if (month >= 1 && month <= 12) {
				return 1;
			}

		}
		return 0;
	}

	static int checkDate(int year, int month, int day) {

		if (checkDate(year, month) == 1) {

			int daysInMonth = daysInMonth(year, month);
			if (day == 29 && isLeap(year) == -1) {
				return 0;
			}
			if (daysInMonth >= day && day > 0) {
				return 1;
			}
		}
		return 0;
	}

	static int ymd2w(int year, int month, int day) {

		if (checkDate(year, month, day) == 0) {
			return -1;
		}

		int d = day;
		int m = month;
		int year2 = year;

		if (m == 1 || m == 2) {

			if (m == 1) {
				m = 11;
				year2--;
			} else if (m == 2) {
				m = 12;
				year2--;
			}
		} else {
			m -= 2;
		}
		int y = year2 % 100;
		int c = year2 / 100;

		int monthTerm = (int) Math.floor((2.6 * m) - 0.2);
		int A = d + monthTerm + y + (y / 4) + (c / 4) - (2 * c);
		if (A < 0) {

			while (A < 7) {
				A += 7;
			}
		}
		int numberOfWeekday = A % 7;

		return numberOfWeekday;
	}

	static int dayNumber(int year, int month, int day) {

		if (checkDate(year, month, day) == 0) {
			return -1;
		}

		switch (month) {

		case 1:
			return day;

		case 2:
			day += 31;
			return day;

		case 3:
			day += 59;
			if (isLeap(year) == 1) {
				day++;
			}
			return day;

		case 4:
			day += 90;
			if (isLeap(year) == 1) {
				day++;
			}
			return day;

		case 5:
			day += 120;
			if (isLeap(year) == 1) {
				day++;
			}
			return day;

		case 6:
			day += 151;
			if (isLeap(year) == 1) {
				day++;
			}
			return day;

		case 7:
			day += 181;
			if (isLeap(year) == 1) {
				day++;
			}
			return day;

		case 8:
			day += 212;
			if (isLeap(year) == 1) {
				day++;
			}
			return day;

		case 9:
			day += 243;
			if (isLeap(year) == 1) {
				day++;
			}
			return day;

		case 10:
			day += 273;
			if (isLeap(year) == 1) {
				day++;
			}
			return day;

		case 11:
			day += 304;
			if (isLeap(year) == 1) {
				day++;
			}
			return day;

		case 12:
			day += 334;
			if (isLeap(year) == 1) {
				day++;
			}
			return day;

		default:
			return -1;
		}
	}

	static int weekNumber(int year, int month, int day) {

		if (checkDate(year, month, day) == 0) {
			return -1;
		} else if (dayNumber(year, month, day) < 7) {
			return 1;
		} else {

			int daysPassed = dayNumber(year, month, day);
			daysPassed /= 7;

			return daysPassed;
		}
	}

	static void printDayName(int day) {

		switch (day) {
		case 0:
			System.out.print("Sunday");
			break;

		case 1:
			System.out.print("Monday");
			break;

		case 2:
			System.out.print("Tuesday");
			break;

		case 3:
			System.out.print("Wednesday");
			break;

		case 4:
			System.out.print("Thursday");
			break;

		case 5:
			System.out.print("Friday");
			break;

		case 6:
			System.out.print("Saturday");
			break;

		default:
			System.out.printf("invalid day(%d)", day);
		}

	}

	static void printMonth(int month) {

		switch (month) {

		case 1:
			System.out.print("January ");
			break;

		case 2:
			System.out.print("February ");
			break;

		case 3:
			System.out.print("March ");
			break;

		case 4:
			System.out.print("April ");
			break;

		case 5:
			System.out.print("May ");
			break;

		case 6:
			System.out.print("June ");
			break;

		case 7:
			System.out.print("July ");
			break;

		case 8:
			System.out.print("August ");
			break;

		case 9:
			System.out.print("September ");
			break;

		case 10:
			System.out.print("October ");
			break;

		case 11:
			System.out.print("November ");
			break;

		case 12:
			System.out.print("December ");
			break;

		default:
			System.out.printf("invalid month(%d)", month);
		}
	}

	static void printNmberEnding(int n) {

		switch (n) {

		case 1:
			System.out.print("st");
			break;

		case 2:
			System.out.print("nd");
			break;

		case 3:
			System.out.print("rd");
			break;

		default:
			System.out.print("th");
			break;
		}
	}

	static void printDate(int year, int month, int day) {

		if (checkDate(year, month, day) == 0) {
			System.out.printf("invalid date (%02d.%02d.%4d)", day, month, year);
		} else {

			int correctDay = ymd2w(year, month, day);
			printDayName(correctDay);
			System.out.print(", ");
			printMonth(month);
			System.out.print(day);
			printNmberEnding(day);
			System.out.println(" " + year);
		}
	}

	static void printStatistics(int year, int month, int day) {

		if (checkDate(year, month, day) == 0) {
			System.out.println("invalid date");
		} else {

			System.out.println("statistics for");
			printDate(year, month, day);
			if (isLeap(year) == 1) {
				System.out.println(year + " is a leap year");
			} else {
				System.out.println(year + " is not a leap year");
			}
			printMonth(month);
			System.out.printf("%4d has %02d days", year, daysInMonth(year, month));
			System.out.println();
			System.out.printf("it is day %d of year %4d\n", dayNumber(year, month, day), year);
			System.out.printf("it is in week %d of year %4d", weekNumber(year, month, day), year);
		}

	}

	static void printCalendar(int year, int month, int day, int highlight) {

		if (checkDate(year, month, day) == 0) {
			System.out.println("invalid date");
		}
		printMonth(month);
		System.out.println(year);
		System.out.println("Mon Tue Wed Thu Fri Sat Sun");
		int daysOfMonth = daysInMonth(year, month);
		int startingDayOfWeek = ymd2w(year, month, day);

		for (int i = 0; i < 1; i++) {

			if (startingDayOfWeek == 1) {

				for (int j = 1; j <= daysOfMonth; j++) {

					if ((j + startingDayOfWeek - 1) % 7 == 0) {

						if (j == highlight) {
							System.out.printf("<%2d>", j);
						} else {
							System.out.printf("%2d", j);
							System.out.println();
						}
					} else {
						if (j == highlight) {
							System.out.printf("<%2d>", j);
						} else {
							System.out.printf("%2d", j);
							System.out.print("  ");
						}
					}
				}
			} else {

				if (startingDayOfWeek == 2) {

					for (int a = 0; a < startingDayOfWeek; a++) {
						System.out.print("  ");
					}
				} else {
					for (int a = 1; a < startingDayOfWeek; a++) {
						System.out.print("    ");
					}
				}

				for (int j = 1; j <= daysOfMonth; j++) {

					if ((j + startingDayOfWeek - 1) % 7 == 0) {

						if (j == highlight) {
							System.out.printf("<%2d>", j);
						} else {
							System.out.printf("%2d", j);
							System.out.println();
						}
					} else {
						if (j == highlight) {
							System.out.printf("<%2d>", j);
						} else {
							System.out.printf("%2d", j);
							System.out.print("  ");
						}
					}
				}
			}

		}
	}

}// end of class
