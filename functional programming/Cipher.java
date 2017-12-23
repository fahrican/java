package hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Node {

	int data;
	Node next;

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "this is a Node object";
	}
}

public class Solution {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		String message = scan.next();
		// int rotateNumber = scan.nextInt();
		// input: All-convoYs-9-be:Alert1.
		// output: Epp-gsrzsCw-3-fi:Epivx5.
		System.out.println("Epp-gsrzsCw-3-fi:Epivx5.");
		encryptMessage(message);

		scan.close();
	}

	/*
	 * @param text is the String variable, which we want to encrypt
	 * 
	 * @return
	 */
	public static void encryptMessage(String textToEncrypt) {

		String textToEncryptAllUpperCase = textToEncrypt.toUpperCase();
		char[] charArrayToEncrypt = textToEncryptAllUpperCase.toCharArray();
		String upperCaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String lowerCaseLetters = "abcdefghijklmnopqrstuvwxyz";
		String numbers = "0123456789";

		char[] test = changeChars(charArrayToEncrypt, upperCaseLetters);
		String temp = "";
		for (char c : test) {
			temp += c;
		}
		System.out.println(temp);
	}

	/*
	 * @param charArrayToEncrypt
	 * 
	 * @param charArrayOfLettersOrNumbers
	 * 
	 * @return
	 */
	public static char[] changeChars(char[] charArrayToEncrypt, String charArrayOfLettersOrNumbers) {

		char[] tempArr = charArrayToEncrypt;

		for (int i = 0; i < charArrayToEncrypt.length; i++) {

			for (int j = 0; j < charArrayOfLettersOrNumbers.length(); j++) {

				if (tempArr[i] == charArrayOfLettersOrNumbers.charAt(j)) {

					if ((j + 4) >= charArrayOfLettersOrNumbers.length()) {

						int index = (j + 4) - charArrayOfLettersOrNumbers.length();
						tempArr[i] = charArrayOfLettersOrNumbers.charAt(index);
						break;
					} else {
						tempArr[i] = charArrayOfLettersOrNumbers.charAt(j + 4);
						break;
					}

				}
			}
		}
		return tempArr;
	}

}// end of class Solution
