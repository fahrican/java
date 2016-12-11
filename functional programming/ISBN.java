package bwi.prog1B.WS1617.wi16b027_Can.ExerciseSheet03;

import bwi.prog.utils.TextIO;

public class ISBN {

	public static void main(String[] args) {
		
		String isbn;
		boolean validPattern;
		
		TextIO.put("enter ISBN: ");
		isbn = TextIO.getln();
		 
		TextIO.putf("valid pattern: %b\n", validPattern = validatePattern(isbn));
		TextIO.put("valid checkDigit: ");
		if(validPattern) {
			TextIO.putf("%b\n", validateCheckDigit(isbn));
		}
		else {
			TextIO.put("false\n");
		}
	}
	
	static boolean validatePattern(String s) {
		return s.matches("\\d{13}");
	}
	
	static boolean validateCheckDigit(String s) {
		int last = Integer.parseInt(s.substring(s.length() - 1));
		int h = 0;
		
		for(int i = 0; i < s.length() - 1; i++) {
			if(i != 0 && (i+1) % 2 == 0) {
				h += Integer.parseInt(s.substring(i, i+1)) * 3;
			}
			else {
				h += Integer.parseInt(s.substring(i, i+1));
			}
		}
		
		h = ((10 - (h) % 10) % 10);
		
		if(h == last) {
			return true;
		}
		else {
			
			return false;
		}
		
	}

}
