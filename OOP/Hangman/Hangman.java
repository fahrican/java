
public class Hangman {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Game myGame = new Game("Monopoly");
		Prompter prompter = new Prompter(myGame);
		
		prompter.displayProgress();
		boolean isHit = prompter.promptForGuess();
		if (isHit) {
			System.out.println("You got a hit!");
		}
		else {
			System.out.println("Ooops, that was not correct.");
		}
		prompter.displayProgress();
	}

}
