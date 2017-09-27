package hackerrank;

import java.util.Scanner;
import java.math.BigInteger;
import java.util.ArrayList;

public class DeletePrimes {

	static int countWays = 0;

	public static void main(String[] args) {

		int test = 4125673;
		ArrayList<Integer> testA = new ArrayList<>();
		testA.add(4);
		testA.add(5);
		testA.add(6);
		testA.add(7);

		solveProblem(testA);
		System.out.print("Insgesamt: " + countWays);
	}

	public static boolean isItAPrime(long anyNumber) {

		for (int i = 2; i <= Math.sqrt(anyNumber); i++) {

			if (anyNumber % i == 0) {
				return false;
			}
		}
		return true;
	}

	public static long convertIntegers(ArrayList<Integer> integers) {
		// Bastle einen String und parse diesen dann zu einem Integer

		String integer = "";
		if (integers.size() == 0) {
			return -1;
		}	

		for (int i = 0; i < integers.size(); i++) {
			
			integer += String.valueOf(integers.get(i));
		}

		return Long.parseLong(integer);
	}

	public static void solveProblem(ArrayList<Integer> number) {

		// Jede Stelle von der Zahl
		for (int i = 0; i < number.size(); i++) {

			int backup = number.get(i); // Die geloeschte Zahl muss wieder zurueck eingesetzt werden um alle Faelle zu
										// untersuchen
			number.remove(i); // Loesche eine Ziffer
			long tempI = convertIntegers(number); // Wandle von ArrayList zu long um (fuer fette zahlen)

			if (tempI == -1) {
				return;
			} // Vorsichtsmassnahme, kann wsl entfernt werden

			BigInteger bla = BigInteger.valueOf(tempI); // Fuer fette Zahlen

			if (bla.isProbablePrime(1)) {
				System.out.println(tempI); // Debugzwecke

				if (number.size() == 1) {
					countWays++; // Laut Angabe wird nur dann hochgezaehlt wenn die unterste Ebene erreicht wurde
				}	

				else {
					solveProblem(number); // Beginn der Rekursion
				}

				// Aus der Rekursion raus muss wieder die geloeschte Zahl wieder
				// hinzugefuegt werden
			}

			// Setze Zahl zurueck ein, um weitere Faellen zu untersuchen
			number.add(i, backup);
		}

	}

}// end of class DeletePrimes
