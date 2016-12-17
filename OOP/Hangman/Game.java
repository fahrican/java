
public class Game {

	private String answer;
	private String hits;
	private String misses;
	public static final int MAX_MISSES = 7;	
	
	public Game(String answer){
		
		this.answer = answer.toLowerCase();
		hits = "";
		misses = "";
	}//end of constructor
	
	/*
	 * @param checks if a letter was entered
	 * than it checks if the same letter was entered before
	 * @return if not it returns the letter
	 */
	private char normalizeGuess(char letter) {
		
		if (!Character.isLetter(letter)) {
			throw new IllegalArgumentException("You have to type a letter.");
		}
		letter = Character.toLowerCase(letter);
		if (hits.indexOf(letter) != -1 || misses.indexOf(letter) != -1){
			throw new IllegalArgumentException(letter + " has already been guessed.");
		}
		return letter;
	}//end of method
	
	/*
	 *@param takes a String and than checks if it is really a String
	 *@return the first letter of the String 
	 */
	public boolean applyGuess(String letters) {
		
		if (letters.length() == 0) {
			throw new IllegalArgumentException("You haven't entered any letters.");
		}
		return applyGuess(letters.charAt(0));
	}//end of method
	
	/*
	 *@param takes a letter to check, if it is entered before or not
	 *than it checks, if the letter is a letter from the answer
	 *if yes, it gets stored in hits, if not it gets stored in misses
	 *@return true or false
	 */
	public boolean applyGuess(char letter) {
		
		letter = normalizeGuess(letter);
		boolean isHit = answer.indexOf(letter) != -1;
		if (isHit) {
			hits += letter;
		}
		else {
			misses += letter;
		}
		
		return isHit;
	}//end of method
	
	/*
	 * shows the progress of the game
	 * if the letter matches the game solution, letter will be shown
	 * otherwise a dash will appear
	 * @return current progress of the game
	 */
	public String getCurrentProgress() {
		
		String progress = "";	
		for (char letter : answer.toCharArray()) {
			
			char display = '-';
			if (hits.indexOf(letter) != -1) {
				display = letter;
			}
			progress += display;
		}
		return progress;
	}//end of method
	
	/*
	 * maximum 7 misses are allowed 
	 * @return 7 allowed tries minus current misses 
	 */
	public int getRemainingTries() {

		return MAX_MISSES - misses.length();
	}

	// @return name of the game
	public String getAnswer() {
		return answer;
	}
	
	/*
	 * checks if all dashes are guessed
	 * @return name of the game or (letters with) dashes
	 */
	public boolean isWon() {
		return getCurrentProgress().indexOf("-") == -1;
	}//end of method
	
}//end of class
