package bwi.prog1B.WS1617.wi16b027_Can.LabWork;

import bwi.prog.utils.TextIO;

public class LendItemFunctions {


	public static String lendItemString(LendItem it, int format){
		
		int id;
		String description, lender, owner;
		
		if (it.id >= 100 && it.id <= 999) {
			id = it.id;
		}
		else {
			String s1 = Integer.toString(it.id);
			String s2 = s1.substring(0, 3);
			id = Integer.parseInt(s2);
		}
		
		if (it.description.length() > 15) {
			description = it.description.substring(0, 15);
		}
		else {
			description = it.description;
		}
		
		if (it.lender.length() > 10) {
			lender = it.lender.substring(0, 10);
		}
		else {
			lender = it.lender;
		}
		
		if (it.owner.length() > 10) {
			owner = it.owner.substring(0, 10);
		}
		else {
			owner = it.owner;
		}
		
		switch (format) {
		
			case 1:
				// <id> <description> <lender> <lendDate> <returnDate> <owner>
				return 	String.format("%-3d", id)
						+ " "
						+ String.format("%-15s", description)
						+ " "
						+ String.format("%-10s", lender)
						+ " "
						+ dateString(it.lendDate)
						+ " "
						+ dateString(it.returnDate)
						+ " "
						+ String.format("%-10s", owner);
			case 2:
				// <description> <lender>
				return String.format("%-15s", it.description)
						+ " "
						+ String.format("%-10s", it.lender);
				
			default:
				// <id>,<description>,<lendDate,<returnDate>,<owner>
				return String.format("\"%s\",\"%s\",\"%s\",\"%s\"", 
						it.description, 
						dateString(it.lendDate), 
						dateString(it.returnDate), 
						it.owner
						);
		}
		
	}//end of method
	
	public static String lendItemHeadings(int format) {
		switch(format) {
			case 1:
				return String.format("%-3s\t%-15.15s\t%-10.10s\t%-10.10s\t%-11.11s\t%-10.10s", 
						"ID", 
						"description", 
						"lender", 
						"lend date", 
						"return date", 
						"owner");
			case 2:
				return String.format("%-15.15s %-10.10s", 
						"description", 
						"lender");
			default:
				return String.format("%-15.15s\t%-10.10s\t%-10.10s\t%-10.10s", 
						"description", 
						"lend date", 
						"return date", 
						"owner");
		}
	}//end of method
	
	public static String lendItemSeperator(int format) {
		
		switch(format) {
			case 1:
				return "--------------------------------------------------------------------------------------------";
			case 2:
				return "--------------------------------";
			default:
				return "--------------------------------------------------------";
		}
	}//end of method
	
	 private static String dateString(Date d){
		 
		 if (d == null) {
			return String.format("<not set>");
		}
		 
		 return String.format("%04d", d.year)
					+ "."
					+ String.format("%02d", d.month)
					+ "."
					+ String.format("%02d", d.day);
	 }// end of method
	 
	 public static int compare(LendItem it1, LendItem it2, int method){
			
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
				break;
			}
			return compareByDescription(it1, it2);
		}// end of method
		
		public static int compareByLendDate(LendItem it1, LendItem it2) {
			
			if (it1.lendDate == null || it2.lendDate == null) {
				
				if (it1.lendDate == null && it2.lendDate == null) {
					return 0;
				}
				else if (it1.lendDate == null) {
					return -1;
				}
				return 1;
			}
			
			boolean equal = it1.lendDate.year == it2.lendDate.year && it1.lendDate.month == it2.lendDate.month && it1.lendDate.day == it2.lendDate.day;
			
			if (equal) {
				return 0;
			}
			else if (it1.lendDate.year < it2.lendDate.year) {
				return -1;
			}
			else if (it1.lendDate.year > it2.lendDate.year) {
				return 1;
			}
			else if (it1.lendDate.month < it2.lendDate.month) {
				return -1;
			}
			else if (it1.lendDate.month > it2.lendDate.month) {
				return 1;
			}
			else if (it1.lendDate.day < it2.lendDate.day) {
				return -1;
			}
			return 1;
			
		}// end of method
		
		public static int compareByReturnDate(LendItem it1, LendItem it2) {
			
			if (it1.returnDate == null || it2.returnDate == null) {
				
				if (it1.returnDate == null && it2.returnDate == null) {
					return 0;
				}
				else if (it1.returnDate == null) {
					return -1;
				}
				return 1;
			}
			
			boolean equal = it1.returnDate.year == it2.returnDate.year && it1.returnDate.month == it2.returnDate.month && it1.returnDate.day == it2.returnDate.day;
			
			if (equal) {
				return 0;
			}
			else if (it1.returnDate.year < it2.returnDate.year) {
				return -1;
			}
			else if (it1.returnDate.year > it2.returnDate.year) {
				return 1;
			}
			else if (it1.returnDate.month < it2.returnDate.month) {
				return -1;
			}
			else if (it1.returnDate.month > it2.returnDate.month) {
				return 1;
			}
			else if (it1.returnDate.day < it2.returnDate.day) {
				return -1;
			}
			return 1;
		}// end of method
		
		public static int compareByDescription(LendItem it1, LendItem it2){
			
			if (it1.description == null || it2.description == null) {
				
				if (it1.description == null && it2.description == null) {
					return 0;
				}
				else if (it1.description == null) {
					return -1;
				}
				return 1;
			}
			
			int solution = it1.description.compareTo(it2.description);
			
			if (solution < 0) {
				return -1;
			}
			else if(solution == 0) {
				return 0;
			}
			else {
				return 1;
			}
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
			
			boolean equal = d1.year == d2.year && d1.month == d2.month && d1.day == d2.day;
			
			if (equal) {
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
			else if (d1.day < d2.day) {
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
			
			int solution = it1.lender.compareTo(it2.lender);
			
			if (solution < 0) {
				return -1;
			}
			else if (solution == 0) {
				return 0;
			}
			return 1;
			
		}// end of method
		
		public static int compareByOwner(LendItem it1, LendItem it2){
			
			if (it1.owner == null || it2.owner == null) {
				
				if (it1.owner == null && it2.owner == null) {
					return 0;
				}
				else if (it1.owner == null) {
					return -1;
				}
				return 1;
			}
			
			int solution = it1.owner.compareTo(it2.owner);
			
			if (solution < 0) {
				return -1;
			}
			else if (solution == 0) {
				return 0;
			}
			return 1;
			
		}// end of method
		
		public static boolean equals(LendItem it1, LendItem it2){
			
			if (it1 == null || it2 == null) {
				
				if (it1 == null && it2 == null) {
					return true;
				}
				else {
					return false;
				}
			}
			else if (compare(it1, it2, 1) == 0) {
				
				if (compare(it1, it2, 2) == 0) {
					if (compare(it1, it2, 3) == 0) {
						if (compare(it1, it2, 4) == 0) {
							if (compare(it1, it2, 5) == 0) {
								return true;
							}
						}
					}
				}
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
			 
			 LendItem it3 = new LendItem();
			 
			 do {
				
				 TextIO.put("Please, enter a description: ");
				 it3.description = TextIO.getln();
				 if (it3.description == null) {
					TextIO.putln("<description> cannot be empty!");
				}
				TextIO.put("Please, enter a lender: ");
				it3.lender = TextIO.getln();
				if (it3.lender == null) {
					TextIO.putln("<lender> cannot be empty!");
				}
				TextIO.put("Please, enter a owner: ");
				it3.owner = TextIO.getln();

			}while(it3.description == null || it3.lender == null);
			 
			it3.lendDate = scanDate();
			it3.returnDate = scanDate();
			
			return it3; 
			 
		 }// end of method
		 
		 public static Date scanDate() {
				
				Date d = new Date();
				
				do {
					TextIO.put("Year: ");
					d.year = TextIO.getlnInt();
					TextIO.put("Month: ");
					d.month = TextIO.getlnInt();
					TextIO.put("Day: ");
					d.day = TextIO.getlnInt();
				} while (!(d.year > 1580 && d.month > 0 && d.month < 13 && d.day > 0 && d.day < 32));
					/*if(d.year < 1581) TextIO.putln(d.year);
					else if(d.month < 1 || d.month > 12) TextIO.putln(d.month);
					else if(d.day < 1 || d.day > 31) TextIO.putln(d.day); */

				return d;
		 }
		
		 
		 public static boolean isOut(LendItem li){
			 
			 if (li.returnDate == null) {
				return true;
			}
			return false;
		 }// end of method


}//end of class
