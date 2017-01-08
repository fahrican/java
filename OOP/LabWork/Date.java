package bwi.prog1B.WS1617.wi16b027_Can.LabWork;

public class Date {

	int year;
	int month;
	int day;
	
	public static String dateString(Date d){
		
		return String.format("%4d", d.year)
				+ "."
				+ String.format("%02d", d.month)
				+ "."
				+ String.format("%02d", d.day);
	}// end of method
}
