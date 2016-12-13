import java.util.Scanner;

public class Prompter {
	
	private Game game;
	
	public Prompter(Game game){
		
		this.game = game;
	}//end of constructor
	
	public boolean promptForGuess() {
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter a letter: ");
		String guess = scanner.nextLine();
		char letter = guess.charAt(0);
		
		return game.applyGuesses(letter);
	}//end of method
	
	public void displayProgress() {
		System.out.printf("Try to solve: %s%n", game.getCurrentProgress());
	}//end of method
	
}//end of class
