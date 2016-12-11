package bwi.prog1B.WS1617.wi16b027_Can.ExerciseSheet04;
import bwi.prog.utils.TextIO;

public class ArrayMeanStatistics {

	public static void main(String[] args) {
		int[] numArray = new int[0];
		boolean getInput = true;
		int input;

		// Input
		TextIO.putln("Input");
		do {
			TextIO.put(": ");
			input = TextIO.getlnInt();
			
			if(input == 0) {
				TextIO.put("re-enter 0 to store as value.\nany other value ends input: ");
				input = TextIO.getlnInt();
				if(input == 0) {
					numArray = push(input, numArray);
					TextIO.putln("value 0 stored.");
				} else {
					getInput = false;
				}
			} else {
				numArray = push(input, numArray);
			}
		} while(getInput && numArray.length < 1024);
		
		// Output
		if(numArray.length > 0) {
			int sum = sumArray(numArray);
			float totalMean = (float)sum / numArray.length;
			int[] larger = findLargerInArray(numArray, totalMean);
			int count = larger.length;
			
			TextIO.putln("Input finished.");
			TextIO.putf("total mean: %.2f\n", totalMean);
			TextIO.putln("----------");
			TextIO.putln("          count: " + count);
			if(count > 0) {
				int[] indexes = findLargerInArrayIndexes(numArray, totalMean);
				int sumLarger = sumArray(larger);
				float mean = (float)sumLarger / count;
				int min = findMin(larger);
				int[] minIndexes = findInArray(numArray, min);
				
				TextIO.putln("index positions: " + arrToString(indexes));
				TextIO.putln("            sum: " + sumLarger);
				TextIO.putf("           mean: %.2f\n", mean);
				TextIO.putln("            min: " + min + " " + arrToString(minIndexes));
			}
		} else {
			TextIO.putln("no values entered.");
		}
	}
	
	
	public static int[] push(int input, int[] array) {
		int[] newArray = new int[array.length + 1];
		
		for(int i = 0; i < array.length; i++) {
			newArray[i] = array[i];
		}
		newArray[newArray.length - 1] = input;
		return newArray;
	}
	
	
	public static int sumArray(int[] array) {
		int sum = 0;
		for(int i = 0; i < array.length; i++) {
			sum += array[i];
		}
		return sum;
	}
		

	public static int[] findLargerInArrayIndexes(int[] array, float mean) {
		int[] indexes = new int[0];
		
		for(int i = 0; i < array.length; i++) {
			if(array[i] > mean) {
				indexes = push(i, indexes);
			}
		}
		return indexes;		
	}
	
	
	public static int[] findLargerInArray(int[] array, float mean) {
		int[] indexes = new int[0];
		
		for(int i = 0; i < array.length; i++) {
			if(array[i] > mean) {
				indexes = push(array[i], indexes);
			}
		}
		return indexes;		
	}
	

	public static int findMin(int[] array) {
		int min = array[0];
		
		for(int i = 0; i < array.length; i++) {
			if(array[i] < min) {
				min = array[i];
			}
		}
		return min;
	}
	
	
	public static int[] findInArray(int[] array, int val) {
		int[] indexes = new int[0];
		
		for(int i = 0; i < array.length; i++) {
			if(array[i] == val) {
				indexes = push(i, indexes);
			}
		}
		return indexes;
	}
	
	
	public static String arrToString(int[] array) {
		String strArr = "[";
		
		for(int i = 0; i < array.length; i++) {
			strArr += " " + array[i];
		}
		strArr += "]";
		return strArr;		
	}

}
