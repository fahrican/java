package hackerearth;

import java.util.Scanner;

public class Cipher {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		String message = scan.next();
		int numberOfCharactersToRotate = scan.nextInt();
		scan.close();

		// input: All-convoYs-9-be:Alert1.
		// output: Epp-gsrzsCw-3-fi:Epivx5.
		encryptMessage(message, numberOfCharactersToRotate);
	}

	/*
	 * @param textToEncrypt is the String variable, which we want to encrypt
	 * 
	 * @param numberOfCharactersToRotate for instance the number is 4, so 'a' will
	 * be an 'e'
	 * 
	 * @return charArrayToText, this variable has stored all modified characters
	 * from the char array
	 */
	public static void encryptMessage(String textToEncrypt, int numberOfCharactersToRotate) {

		char[] charArrayToEncrypt = textToEncrypt.toCharArray();
		String upperCaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String lowerCaseLetters = "abcdefghijklmnopqrstuvwxyz";
		String numbers = "0123456789";

		char[] test = changeChars(charArrayToEncrypt, upperCaseLetters, numberOfCharactersToRotate);
		test = changeChars(charArrayToEncrypt, lowerCaseLetters, numberOfCharactersToRotate);
		test = changeChars(charArrayToEncrypt, numbers, numberOfCharactersToRotate);
		String charArrayToText = "";
		for (char c : test) {
			charArrayToText += c;
		}
		System.out.println(charArrayToText);
	}

	/*
	 * @param charArrayToEncrypt the original text to encrypt as char array
	 * 
	 * @param textOfLettersOrNumbers this paramters is a String either the ABC as
	 * lower or uppercase letters or a just a text of numbers for instance
	 * "0123456789"
	 * 
	 * @param numberOfCharactersToRotate for instance the number is 4, so 'a' will
	 * be an 'e'
	 * 
	 * @return tempArr this is the modified char array, depends on the second
	 * parameter of the method was all upper or lowercase or just numbers as text
	 */
	public static char[] changeChars(char[] charArrayToEncrypt, String textOfLettersOrNumbers,
			int numberOfCharactersToRotate) {

		char[] tempArr = charArrayToEncrypt;

		for (int i = 0; i < charArrayToEncrypt.length; i++) {

			for (int j = 0; j < textOfLettersOrNumbers.length(); j++) {

				if (tempArr[i] == textOfLettersOrNumbers.charAt(j)) {

					if ((j + numberOfCharactersToRotate) >= textOfLettersOrNumbers.length()) {

						int index = (j + numberOfCharactersToRotate) - textOfLettersOrNumbers.length();
						tempArr[i] = textOfLettersOrNumbers.charAt(index);
						break;
					} else {
						tempArr[i] = textOfLettersOrNumbers.charAt(j + numberOfCharactersToRotate);
						break;
					}

				}
			}
		}
		return tempArr;
	}

}
