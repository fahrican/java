import java.util.Iterator;
import java.util.Scanner;

import org.omg.CORBA.PUBLIC_MEMBER;

public class HalloWelt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	Scanner userInp = new Scanner(System.in);
	int rows, columns;
	
	System.out.print("enter rows: ");
	rows = userInp.nextInt();
	System.out.print("enter columns: ");
	columns = userInp.nextInt();
	System.out.print("\n");
	
	// this first row shows us how many columns we have
	for (int i = 1; i <= 1; i++) {
		
		for (int j = 1; j <= columns; j++) {
			
			if (j == 1) {
				
				System.out.printf("\t%4d", j);
			}
			else {
				
				System.out.printf("%4d", j);
			}
			
		}//end of first columns loop
		
	}//end of first rows loop
	
	System.out.println();
	
	// this row inserts the "----"
	for (int q = 1; q <= 1; q++){
		
		System.out.print("----");
		
		for (int z = 0; z <= columns; z++) {
			
			System.out.print("----");
		}
		
	}
	
	System.out.println();
	
	//this sections inserts the rows
	for (int a = 1; a <= rows; a++) {
		
		System.out.printf("%2d|\t", a);
		
		// here starts the multiplication table
		for (int b = 1; b <= columns; b++) {
			
			System.out.printf("%4d", a*b);
		}
	
		System.out.println();
	}
	
	
	// end of program	
	}
}
