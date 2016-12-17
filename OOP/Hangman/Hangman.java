
public class Hangman {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Game myGame = new Game("Monopoly");
		Prompter prompter = new Prompter(myGame);
		
		while (myGame.getRemainingTries() > 0 && !myGame.isWon()) {
			
			prompter.displayProgress();
			prompter.promptForGuess();
		}
		prompter.displayOutcome();
	}

}
