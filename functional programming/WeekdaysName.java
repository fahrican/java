package homework.woche3;

import java.util.Scanner;

public class Weekdays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		System.out.print("Enter a date (YYYY/MM/DD): ");
		//int date = scan.nextInt();
		int date = 0;
		boolean invalidInput = true;
		int m = 0;
		int d = 0;
		int year = 0;

		do {
			
			date = Integer.parseInt(scan.nextLine());
			if (date < 15821015) {
				System.out.println("Invalid input!");
				System.out.print("Enter a date: ");
			} else {

				m = date % 10000;
				m = m / 100;
				year = date / 10000;
				d = date % 100;
				if (m < 1 || m > 12) {

					System.out.println("impossible month!");
					System.out.print("Enter a date: ");
				}
				else if (d < 1 || d > 31) {

					System.out.println("impossible day!");
					System.out.print("Enter a date: ");
				} else if (d >= 29 && m == 2) {

					if (d > 29) {
						System.out.println("impossible day!");
						System.out.print("Enter a date: ");
					}
					else if (!checkLeapYear(year)) {

						System.out.println("impossible day!");
						System.out.print("Enter a date: ");
					}
					else {
						invalidInput = false;
					}
				} else if (d == 31 && !(m == 1 || m == 3 || m == 5 || m == 7 || m == 8 || m == 10 || m == 12)) {

					System.out.println("impossible day!");
					System.out.print("Enter a date: ");
				} else {
					invalidInput = false;
				}
			}

		} while (invalidInput);

		int originMonth = m;
		int originYear = year;

		if (m == 1 || m == 2) {

			if (m == 1) {
				m = 11;
				year -= 1;
			} else if (m == 2) {
				m = 12;
				year -= 1;
			}
		}
		else {
			m -= 2;
		}
		int y = year % 100;
		int c = year / 100;
		scan.close();

		// System.out.println(d + " " + m + " " + c + " " + y);
		
		int monthTerm = (int) Math.floor((2.6 * m) - 0.2);
		int A = d + monthTerm + y + (y / 4) + (c / 4) - (2 * c);
		if (A < 0) {
			
			while (A < 7) {
				A += 7;
			}
		}
		int solution = A % 7;
		
		//int solution = ((d + ((m+1) * 26) / 10) + y + (y/4) + (c/4) + (5*c)) % 7;
		
		switch (solution) {
		case 0:
			System.out.printf("%02d/%02d/%d (month/date/year) was, is or will be a Sun!\n", originMonth, d, originYear);
			break;

		case 1:
			System.out.printf("%02d/%02d/%d (month/date/year) was, is or will be a Mon!\n", originMonth, d, originYear);
			break;

		case 2:
			System.out.printf("%02d/%02d/%d (month/date/year) was, is or will be a Tue!\n", originMonth, d, originYear);
			break;

		case 3:
			System.out.printf("%02d/%02d/%d (month/date/year) was, is or will be a Wed!\n", originMonth, d, originYear);
			break;

		case 4:
			System.out.printf("%02d/%02d/%d (month/date/year) was, is or will be a Thu!\n", originMonth, d, originYear);
			break;

		case 5:
			System.out.printf("%02d/%02d/%d (month/date/year) was, is or will be a Fri!\n", originMonth, d, originYear);
			break;

		case 6:
			System.out.printf("%02d/%02d/%d (month/date/year) was, is or will be a Sat!\n", originMonth, d, originYear);
			break;

		default:
			System.out.println("Something went terribly wrong!");
			break;
		}

	}// end of main
	
	public static boolean checkLeapYear(int jahr) {
		
		if (jahr % 4 == 0 && jahr % 100 == 0 && jahr % 400 == 0) {
			return true;
		}
		else if (jahr % 4 == 0 && jahr % 100 != 0 && jahr % 400 == 0) {
			return true;
		}
		else if (jahr % 4 == 0 && jahr % 100 != 0) {
			return true;
		}
		else if (jahr % 100 == 0 && jahr % 400 != 0) {
			return false;
		}
		return false;
	}//end of method checkLeapYear

}
