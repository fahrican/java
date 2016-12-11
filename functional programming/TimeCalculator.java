import java.util.Scanner;

public class HalloWelt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	long userNumber;
	Scanner millis = new Scanner(System.in);
	long days, hours, minutes, seconds, ms; 
	
	System.out.printf("Welcome to the TimeCalculator!");
	System.out.print("\nplease enter a duration in milliseconds:");
  //here we save the user input
	userNumber = millis.nextLong();
	System.out.println(userNumber + " ms are exactly:");
	
  //here starts the calculation process
	days = userNumber / (1000*60*60*24);
	hours = ((userNumber / (1000*60*60)) % 24);
	minutes = ((userNumber / (1000*60)) % 60);
	seconds = ((userNumber / (1000)) % 60);
	ms = ((userNumber % (1000)));
	
	System.out.println("days " + days);
	System.out.println("hours " + hours);
	System.out.println("minutes " + minutes);
	System.out.println("seconds " + seconds);
	System.out.println("ms " + ms);
	
		
	// end of program	
	}
}
