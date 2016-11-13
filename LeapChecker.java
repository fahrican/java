import bwi.prog.utils.TextIO;

public class LeapChecker {

	public static void main(String[] args) {
		int year;
		
		TextIO.putln("enter year:");
		year = TextIO.getlnInt();
		
		// Catch negative input
		while(year < 0) {
			TextIO.putln("Year must be > 0.");
			TextIO.putln("enter year:");
			year = TextIO.getlnInt();
		}
		
		// Check if year is/was leap year
		if(year % 4 == 0) {
			if(year % 100 == 0) {
				if(year % 400 == 0) {
					TextIO.putf("%d is/was a leap year\n", year);
				} else {
					TextIO.putf("%d is/was not a leap year\n", year);
				}
			} else {
				TextIO.putf("%d is/was a leap year\n", year);
			}
		} else {
			TextIO.putf("%d is/was not a leap year\n", year);
		}		
	}

}
