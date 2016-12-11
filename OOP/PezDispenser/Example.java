
public class Example {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("We are making a new PezDispenser");
		System.out.printf("Fun fact every dispenser has %d Pez stored. %n", PezDispenser.MAX_PEZ);
		PezDispenser dispenser = new PezDispenser("Darth Vader");
		System.out.printf("The dispenser character is %s %n",
				dispenser.getCharacterName());
		System.out.println("The dispenser gets filled....");
		dispenser.fill();
		if (!dispenser.isEmpty()) {
			System.out.println("Dispenser is full");
		}
		while (dispenser.dispense()) {
			System.out.println("Chomp!");
		}
		if (dispenser.isEmpty()) {
			System.out.println("Ate all the PEZ!");
		}
		try {
			
			dispenser.fill(45);
			System.out.println("Will never happen!");
		} catch (IllegalArgumentException iae) {
			// TODO: handle exception
			System.out.println("Whoaa there!");
			System.out.printf("The error message: %s", iae.getMessage());
		}
		
	}//end of method
	
}//end of class
