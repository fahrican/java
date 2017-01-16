package bwi.prog1B.WS1617.wi16b027_Can.LabWork;

import bwi.prog.utils.TextIO;

public class LendItemFunctions {

	public static String lendItemString(LendItem it, int format) {

		if (it.id < 100 || it.id > 1000) {

			do {
				TextIO.putln("The ID should be a three digit number.");
				TextIO.put("Please, type a three digit number: ");
				it.id = TextIO.getInt();
			} while (it.id < 100 || it.id > 1000);
		}
		if (it.description.length() > 15) {
			it.description = it.description.substring(0, 15);
		}
		if (it.lender.length() > 10) {
			it.lender = it.lender.substring(0, 10);
		}
		if (it.owner.length() > 10) {
			it.owner = it.owner.substring(0, 10);
		}
		
		switch (format) {
		
		case 1:
			return String.format("%-3d", it.id) 
					+ " " 
					+ String.format("%-15s", it.description) 
					+ " "
					+ String.format("%-10s", it.lender) 
					+ " " 
					+ dateString(it.lendDate) 
					+ " " 
					+ dateString(it.returnDate)
					+ " " 
					+ String.format("%-10s", it.owner);
			
		case 2:
			return String.format("%-15s ", it.description)
					+ String.format("%-10s", it.lender);
			
		case 3:
			return String.format("\"%s\",", it.description)
					+ String.format("\"%s\",", it.lender)
					+ "\"" + dateString(it.lendDate) + "\"," 
					+ "\"" + dateString(it.returnDate) + "\","
					+ String.format("\"%s\"", it.owner);
			
		default:					
			return String.format("\"%s\",", it.description)
					+ String.format("\"%s\",", it.lender)
					+ "\"" + dateString(it.lendDate) + "\"," 
					+ "\"" + dateString(it.returnDate) + "\","
					+ String.format("\"%s\"", it.owner);	
		}
		
	}// end of method

	public static String lendItemHeadings(int format) {
		
		switch (format) {
		
		case 1:
			return String.format("%-3s\t", "ID")
					+ String.format("%-15s\t", "description")
					+ String.format("%-10s\t", "lender")
					+ String.format("%-10s\t", "lend date")
					+ String.format("%-10s\t", "return date")
					+ String.format("%-10s", "owner");
			
		case 2:
			return String.format("%-15s\t", "description")
					+ String.format("%-10s", "lender");
			
		case 3:
			return String.format("%-15s\t", "description")
					+ String.format("%-10s\t", "lender")
					+ String.format("%-10s\t", "lend date")
					+ String.format("%-10s\t", "return date")
					+ String.format("%-10s", "owner");

		default:
			return String.format("%-15s\t", "description")
					+ String.format("%-10s\t", "lender")
					+ String.format("%-10s\t", "lend date")
					+ String.format("%-10s\t", "return date")
					+ String.format("%-10s", "owner");
		}
	}// end of method

	public static String lendItemSeparator(int format) {
		
		switch (format) {
		
		case 1:
			String dash1 = "";
			for (int i = 0; i <= 58; i++) {
				dash1 += "-";
			}
			return dash1;
			
		case 2:
			String dash2 = "";
			for (int i = 0; i <= 25; i++) {
				dash2 += "-";
			}
			return dash2;
			
		case 3:
			String dash3 = "";
			for (int i = 0; i <= 55; i++) {
				dash3 += "-";
			}
			return dash3;

		default:
			String dash = "";
			for (int i = 0; i <= 55; i++) {
				dash += "-";
			}
			return dash;
		}
	}// end of method

	private static String dateString(Date d) {

		if (d == null) {
			return String.format("<not set>");
		}

		return String.format("%4d", d.year) 
				+ "." 
				+ String.format("%02d", d.month) 
				+ "." 
				+ String.format("%02d", d.day);
	}// end of method
	
	public static int compare(LendItem it1, LendItem it2, int method) {

		switch (method) {

		case 1:
			return compareByLendDate(it1, it2);

		case 2:
			return compareByReturnDate(it1, it2);

		case 3:
			return compareByLender(it1, it2);

		case 4:
			return compareByOwner(it1, it2);

		default:
			return compareByDescription(it1, it2);
		}
	}//end of method
	
	public static int compareByLendDate(LendItem it1, LendItem it2) {

		if (it1.lendDate == null || it2.lendDate == null) {

			if (it1.lendDate == null && it2.lendDate == null) {
				return 0;
			} else if (it1.lendDate == null) {
				return -1;
			}
			return 1;
		}

		boolean itEqual = it1.lendDate.year == it2.lendDate.year && it1.lendDate.month == it2.lendDate.month && it1.lendDate.day == it2.lendDate.day;

		if (itEqual) {
			return 0;
		} else if (it1.lendDate.year < it2.lendDate.year) {
			return -1;
		} else if (it1.lendDate.year > it2.lendDate.year) {
			return 1;
		} else if (it1.lendDate.month < it2.lendDate.month) {
			return -1;
		} else if (it1.lendDate.month > it2.lendDate.month) {
			return 1;
		} else if (it1.lendDate.day < it2.lendDate.day) {
			return -1;
		}
		return 1;
	}// end of method
	
	public static int compareByReturnDate(LendItem it1, LendItem it2) {

		if (it1.returnDate == null || it2.returnDate == null) {

			if (it1.returnDate == null && it2.returnDate == null) {
				return 0;
			} else if (it1.returnDate == null) {
				return -1;
			}
			return 1;
		}

		boolean itEqual = it1.returnDate.year == it2.returnDate.year && it1.returnDate.month == it2.returnDate.month && it1.returnDate.day == it2.returnDate.day;

		if (itEqual) {
			return 0;
		} else if (it1.returnDate.year < it2.returnDate.year) {
			return -1;
		} else if (it1.returnDate.year > it2.returnDate.year) {
			return 1;
		} else if (it1.returnDate.month < it2.returnDate.month) {
			return -1;
		} else if (it1.returnDate.month > it2.returnDate.month) {
			return 1;
		} else if (it1.returnDate.day < it2.returnDate.day) {
			return -1;
		}
		return 1;
	}// end of method

	public static int compareByDescription(LendItem it1, LendItem it2) {

		if (it1.description == null || it2.description == null) {

			if (it1.description == null && it2.description == null) {
				return 0;
			} else if (it1.description == null) {
				return -1;
			}
			return 1;
		}

		boolean descEqual = it1.description.compareTo(it2.description) == 0;

		if (descEqual) {
			return 0;
		} else if (it1.description.compareTo(it2.description) <= -1) {
			return -1;
		}
		return 1;
	}// end of method	
	
	public static int compare(Date d1, Date d2){
		
		if (d1 == null || d2 == null) {
			
			if (d1 == null && d2 == null) {
				return 0;
			}
			else if (d1 == null) {
				return -1;
			}
			return 1;
		}
		
		boolean dateEqual = d1.year == d2.year && d1.month == d2.month && d1.day == d2.day;
		
		if (dateEqual) {
			return 0;
		}
		else if (d1.year < d2.year) {
			return -1;
		}
		else if (d1.year > d2.year) {
			return 1;
		}
		else if (d1.month < d2.month) {
			return -1;
		}
		else if (d1.month > d2.month) {
			return 1;
		}
		else if (d1.day < d1.day) {
			return -1;
		}
		return 1;
		
	}// end of method

	public static int compareByLender(LendItem it1, LendItem it2){
		
		if (it1.lender == null || it2.lender == null) {
			
			if (it1.lender == null && it2.lender == null) {
				return 0;
			}
			else if (it1.lender == null) {
				return -1;
			}
			return 1;
		}
		
		boolean lenderEqual = it1.lender.compareTo(it2.lender) == 0;
		
		if (lenderEqual) {
			return 0;
		}
		else if (it1.lender.compareTo(it2.lender) <= -1) {
			return -1;
		}
		return 1;
	}// end of method

	public static int compareByOwner(LendItem it1, LendItem it2){

		if (it1.owner == null || it2.owner == null) {

			if (it1.owner == null && it2.owner == null) {
				return 0;
			} else if (it1.owner == null) {
				return -1;
			}
			return 1;
		}

		boolean ownerEqual = it1.owner.compareTo(it2.owner) == 0;

		if (ownerEqual) {
			return 0;
		} else if (it1.owner.compareTo(it2.owner) <= -1) {
			return -1;
		}
		return 1;
	}// end of method

	public static boolean equals(LendItem it1, LendItem it2){
		
		if (it1 == null || it2 == null) {
			
			if (it1 == null && it2 == null) {
				return true;
			}
			return false;
		}
		
		if (compare(it1, it2, 1) == 0 && compare(it1, it2, 2) == 0 && compare(it1, it2, 3) == 0 
				&& compare(it1, it2, 4) == 0 && compare(it1, it2, 5) == 0) {
			return true;
		}
		return false;
	}// end of method
	
	public static boolean equals(Date d1, Date d2){
		
		if (compare(d1, d2) == 0) {
			return true;
		}
		return false;
	}// end of method

	public static LendItem scanLendItem(){
		
		LendItem userLendItem = new LendItem();
		
		do {
			TextIO.put("Please, enter a description: ");
			userLendItem.description = TextIO.getln();
			if (userLendItem.description == null) {
				TextIO.putln("description cannot be empty!");
			}
			
			TextIO.put("Please, enter a lender: ");
			userLendItem.lender = TextIO.getln();
			if (userLendItem.lender == null) {
				TextIO.putln("lender cannot be empty!");
			}

			TextIO.put("Please, enter a owner: ");
			userLendItem.owner = TextIO.getln();
			
		} while (userLendItem.description == null && userLendItem.lender == null);
		
		userLendItem.lendDate = scanDate();
		
		userLendItem.returnDate = scanDate();
		
		return userLendItem;
	}// end of method
	
	public static Date scanDate(){
		
		Date userDate = new Date();
		
		do {
			TextIO.put("Please, enter a year: ");
			userDate.year = TextIO.getInt();
			if (userDate.year < 1582) {
				TextIO.putln("Invalid input! Years must be after 1581.");
			}
			
			TextIO.put("Please, enter a month: ");
			userDate.month = TextIO.getInt();
			if (userDate.month < 1 || userDate.month > 12) {
				TextIO.putln("Invalid input! Months must be out of the range [1-12].");
			}
			
			TextIO.put("Please, enter a day: ");
			userDate.day = TextIO.getInt();
			if (userDate.day < 1 || userDate.day > 31) {
				TextIO.putln("Invalid input! Days must be out of the range [1-31].");
			}
			
		} while (userDate.year < 1582 || userDate.month < 1 || userDate.month > 12  || userDate.day < 1 || userDate.day > 31);
		
		return userDate;		
	}// end of method

	public static boolean isOut(LendItem li){
		
		if (li.returnDate == null) {
			return true;
		}
		return false;
	}// end of method

	
}// end of class
