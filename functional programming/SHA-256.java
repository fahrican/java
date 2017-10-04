package hackerrank;

import java.util.*;
import javax.xml.bind.DatatypeConverter;
import java.security.*;

public class Solution {

	public static void main(String args[]) throws NoSuchAlgorithmException {
		
		Scanner scan = new Scanner(System.in);
		String userInput = scan.next();
		scan.close();
				
		try {

			MessageDigest md = MessageDigest.getInstance("SHA-256");
			md.update(userInput.getBytes());
			System.out.println(DatatypeConverter.printHexBinary(md.digest()).toLowerCase());
		} catch (NoSuchAlgorithmException noae) {
			// TODO: handle exception
		}
		
	}
	

}//end of class Solution

