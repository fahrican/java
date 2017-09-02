package hackerrank;

import java.util.Scanner;
import java.util.Set;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;

public class DequeTest {

	public static void main(String[] args) {
		
		Scanner consoleInput = new Scanner(System.in);
        Deque<Integer> arrayDequeToStoreAllIntegers = new ArrayDeque<Integer>();
        Set<Integer> hashSetToStoreUniqueIntegers = new HashSet<Integer>();
        int quantityOfUniqueIntegersInSubarray = Integer.MIN_VALUE;
        
        int totalAmountOfIntegers = consoleInput.nextInt();
        int sizeOfEachArrayDequeAsSubArray = consoleInput.nextInt();

		for (int i = 0; i < totalAmountOfIntegers; i++) {

			int anyIntegerNumber = consoleInput.nextInt();
			arrayDequeToStoreAllIntegers.addLast(anyIntegerNumber);
			hashSetToStoreUniqueIntegers.add(anyIntegerNumber);
			
			if (arrayDequeToStoreAllIntegers.size() == sizeOfEachArrayDequeAsSubArray) {
				
				if (hashSetToStoreUniqueIntegers.size() > quantityOfUniqueIntegersInSubarray) {
					quantityOfUniqueIntegersInSubarray = hashSetToStoreUniqueIntegers.size();
				}
				
				int firstNumberInDeque = arrayDequeToStoreAllIntegers.remove();
				if (!arrayDequeToStoreAllIntegers.contains(firstNumberInDeque)) {
					hashSetToStoreUniqueIntegers.remove(firstNumberInDeque);
				}
				
				
			}

		}
		consoleInput.close();
		
		System.out.println(quantityOfUniqueIntegersInSubarray);

	}// end of main method

}// end of class Solution
