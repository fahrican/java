package bwi.prog1B.WS1617.wi16b027_Can.ExerciseSheet04;

import bwi.prog.utils.TextIO;

public class ReadArrayPartial {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] myArr = new int[0];
		int userInput;
		
		do {
			TextIO.put(myArr.length + 1 + ". number: ");
			userInput = TextIO.getInt();
			if (userInput < 0) {
				TextIO.putln("invalid input!");
			}
			else if (userInput == 0) {
				break;
			}
			else {
				myArr = push(userInput, myArr);
			}
			
		} while (myArr.length < 10);

		TextIO.putf("%d number(s) entered.\n", myArr.length);
		
		if (myArr.length > 0) {	
			for (int a = 0; a <= myArr.length - 1; a++){
				TextIO.putf("[%d]: %d\n", a, myArr[a]);
			}
			TextIO.put("Output finished.");
		}
		
		
	//end of program
	}
	
	public static int[] push(int input, int[] array) {
		int[] newArray = new int[array.length + 1];
		
		for(int i = 0; i < array.length; i++) {
			newArray[i] = array[i];
		}
		newArray[newArray.length - 1] = input;
		return newArray;
	}
	
//end of class
}
