package hackerrank;

import java.util.*;

public class Solution {

	static boolean isAnagram(String a, String b) {
		
		// first check if the length is equal
		if (a.length() != b.length()) {
			return false;
		}
		
		//second step, make all characters toLowerCase or toUpperCase
		//because 'a' and 'A' are not equal!
		a = a.toLowerCase();
		b = b.toLowerCase();
		
		//third step, make both Strings to char arrays, so you can later iterate
		char[] charArrayA = a.toCharArray();
		char[] charArrayB = b.toCharArray();
		
		//forth step, sort both arrays, because otherwise you can't check, if the characters are equal
		//and does both of them have the same amount of equal characters 
		Arrays.sort(charArrayA);
		Arrays.sort(charArrayB);

		for (int i = 0; i < charArrayB.length; i++) {

			if (charArrayA[i] != charArrayB[i]) {

				return false;
			}

		}

		return true;
	}

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		String a = scan.next();
		String b = scan.next();
		scan.close();
		boolean ret = isAnagram(a, b);
		System.out.println((ret) ? "Anagrams" : "Not Anagrams");
	}

}// end of class
