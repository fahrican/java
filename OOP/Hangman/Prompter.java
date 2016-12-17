import java.util.Scanner;

public class Prompter {
	
	private Game game;
	
	public Prompter(Game game){
		
		this.game = game;
	}//end of constructor
	
	/*
	 * checks if a letter fits the game name
	 * @return true/false if the letter is correct
	 */
	public boolean promptForGuess() {
		
		Scanner scanner = new Scanner(System.in);
		boolean isHit = false;
		boolean isAcceptable = false;
		
		do {
			System.out.print("Enter a letter: ");
			String guess = scanner.nextLine();
			
			try {
				isHit = game.applyGuess(guess);
			} catch (IllegalArgumentException iae) {
				// TODO: handle exception
				System.out.printf("%s. Please try again. %n", iae.getMessage());
			}
			
		} while (isAcceptable);
		
		return isHit;
	}//end of method
	

	// shows how many tries a player has left
	public void displayProgress() {
		System.out.printf("You have %d trie(s) left to solve: %s%n",
							game.getRemainingTries(), game.getCurrentProgress());
	}//end of method
	
	/*
	 * end of the game it shows how many tries the player had left
	 * otherwise it shows the name of the game
	 */
	public void displayOutcome() {
		
		if (game.isWon()) {
			System.out.printf("Congratulation, you won with %d tries remaining.%n",
								game.getRemainingTries());
		}
		else {
			System.out.printf("Sorry, but you lost the game, the word was \"%s\"", 
								game.getAnswer());
		}
		
	}
	
}//end of class
