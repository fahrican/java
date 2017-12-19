package homework.woche3;

import java.util.Scanner;

public class OneMonthCalendar {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int daysOfMonth;
		int startingDayOfWeek;

		do {
			System.out.print("Enter number of days in month: ");
			daysOfMonth = scan.nextInt();
		} while (daysOfMonth < 28 || daysOfMonth > 31);
		do {
			System.out.print("Enter starting day of the week (1=Monday, 7=Sunday): ");
			startingDayOfWeek = scan.nextInt();
		} while (startingDayOfWeek < 1 || startingDayOfWeek > 7);
		scan.close();
		System.out.println();
		System.out.println("Mon Tue Wed Thu Fri Sat Sun");
		

		for (int i = 0; i < 1; i++) {
			
			if (startingDayOfWeek == 1) {
				
				for (int j = 1; j <= daysOfMonth; j++) {
					
					if ((j+startingDayOfWeek-1) % 7 == 0) {
						System.out.printf("%2d", j);
						System.out.println();
					}
					else {
						System.out.printf("%2d", j);
						System.out.print("  ");
					}
				}
			}
			else {
				
				if (startingDayOfWeek == 2) {
					
					for (int a = 0; a < startingDayOfWeek; a++) {
						System.out.print("  ");
					}
				}
				else {
					for (int a = 1; a < startingDayOfWeek; a++) {
						System.out.print("    ");
					}
				}
				
				for (int j = 1; j <= daysOfMonth; j++) {

					if ((j + startingDayOfWeek - 1) % 7 == 0) {
						System.out.printf("%2d", j);
						System.out.println();
					} else {
						System.out.printf("%2d", j);
						System.out.print("  ");
					}
				}
			}
			
		}

	}// end of main

}// end of class
