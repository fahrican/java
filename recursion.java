
public class codeTest {

	/**
	 *In the case where the two rolls are equal, we want to
	 *return the current roll plus the return value of another
	 *call to monopolyRoll(). This is called making a
	 *recursive call. The recursive call will handle making
	 *additional rolls, and recursive calls will keep getting
	 *made until a roll is made where the two values are not
	 *equal.
	 */
	
	public int monopolyRoll(){
		
		int roll1 = theNumbers(6);
		int roll2 = theNumbers(6);
		
		if (roll1 != roll2) {
			return roll1 + roll2;
		} 
		else {	
			return roll1 + roll2 + monopolyRoll();
		}

	}
	
	/**
	 *@param user inserts how many sides the dice has
	 *@return a random number 
	 */
	
	public int theNumbers(int sides){
		
		double anyNum = Math.random() * sides + 1;
		int num1 = (int) anyNum;
		return num1;
	}
}
