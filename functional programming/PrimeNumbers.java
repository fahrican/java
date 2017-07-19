package hackerrank;

import java.util.*;

public class Solution {

	   public static boolean isPrime(int n) {
		   
//		   From mathematics, we can deduce that the smallest divisor of a non-prime number
//		   must certainly be less than or equal it's square root.
	       for(int i = 2; i <= Math.sqrt(n); i++) {
	        	
	            if(n % i == 0) {
	                return false;
	            }
	        }
	        return true;
	    }//end of isPrime()-method

	    public static void main(String[] args) {
	    	
	        Scanner sc = new Scanner(System.in);
	        int numberOfTests = sc.nextInt();
	        
	        for (int i = 0; i < numberOfTests; i++) {
	            
	        		int x = sc.nextInt();
	            if (x >= 2 && isPrime(x)) {
	            	
	            		System.out.println("Prime");
	            } 
	            else {
	            	
	            		System.out.println("Not prime");
	            } 
	            
	        }
	        sc.close();
	    }//end of main()-method
	    
}// end of class
