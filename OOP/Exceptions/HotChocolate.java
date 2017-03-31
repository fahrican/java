import java.util.concurrent.TimeUnit;

public class HotChocolate {
	
	public static final double tooHot = 185;
	public static final double tooCold = 160;
	
	public static void drinkChocolate(double chocoTemp) throws TooHotException, TooColdException {
		
		if (chocoTemp >= tooHot) {
			throw new TooHotException();
		}
		else if (chocoTemp <= tooCold) {
			throw new TooColdException();
		}
	}
	
	public static void main(String[] args) throws InterruptedException, TooColdException, TooHotException {
		// TODO Auto-generated method stub
		
		double currentChocoTemper = 190;
		boolean wrongTemper = true;
		
		while (wrongTemper) {
			
			try {
				drinkChocolate(currentChocoTemper);
				System.out.println("The choco is fine!");
				wrongTemper = false;
			} 
			catch (TooHotException eh) {
				// TODO: handle exception
				System.out.println("It is too hot!");
				currentChocoTemper -= 5;
			} 
			catch (TooColdException ec) {
				// TODO: handle exception
				System.out.println("It is too cold!");
				currentChocoTemper += 5;
			}
			TimeUnit.SECONDS.sleep(2);
			
		}
		System.out.println("Now we are finished.");
		
	}//end of main method

}//end of class
