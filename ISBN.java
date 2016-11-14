package bwi.prog1B.WS1617.wi16b027_Can.ExerciseSheet03;

import bwi.prog.utils.TextIO;

public class ISBN {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TextIO.put("enter ISBN: ");
		String isbn = TextIO.getln();
		TextIO.putf("valid pattern: %s\n", validatePattern(isbn));
		TextIO.putf("valid checkDigit: %s\n", validateCheckDigit(isbn));
	}
	
	//validates "s" as a 13-digit number. 
	// Returns true if "s" is a 13-digit number, false otherwise
	static boolean validatePattern(String s){
		
		if(s.matches("[0-9]{13}")){
			
			return true;
		}
		else {
			
			return false;
		}
	}
	
	//validates "s" as an ISBN. Returns true if "s" is a 13-digit ISBN 
	//(with correct check number), false otherwise.
	static boolean validateCheckDigit(String s){
		
		int lastDigit, sum = 0;
		
		lastDigit = Integer.parseInt(s.substring(12));
		
		
		for(int i = 0; i < 12; i++) {
			
			if(i != 0 && (i+1) % 2 == 0) {
				sum += Integer.parseInt(s.substring(i, i+1)) * 3;
			}
			else {
				
				sum += Integer.parseInt(s.substring(i, i+1));
			}
		}
		
		sum = ((10 - (sum) % 10) % 10);
		
		if(sum == lastDigit) {
			return true;
		}
		else {
			
			return false;
		}
		
		
	}
}
