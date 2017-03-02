import java.util.Scanner;


public class FormatString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan = new Scanner(System.in);
		int size = Integer.parseInt(scan.nextLine());
		String[] strArr = new String[size];
		
		
		for (int i = 0; i < strArr.length; i++) {
			strArr[i] = scan.nextLine();
		}
		
		for (int i = 0; i < strArr.length; i++) {
			
			String charLeft = "";
			String charRight = "";
			
			for (int j = 0; j < strArr[i].length(); j++) {
				
				if (j % 2 == 0) {
					charLeft += strArr[i].charAt(j);
				}
				else {
					charRight += strArr[i].charAt(j);
				}
			}

			System.out.print(String.format("%-1s", charLeft));
			System.out.print(String.format(" "));
			System.out.print(String.format("%s%n", charRight));
		}

	}//end of main-method

}//end of class
