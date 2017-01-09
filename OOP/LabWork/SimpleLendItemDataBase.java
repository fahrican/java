package bwi.prog1B.WS1617.wi16b027_Can.LabWork;

import bwi.prog.utils.TextIO;
import static bwi.prog1B.WS1617.wi16b027_Can.LabWork.LendItemArrayListFunctions.*;

public class SimpleLendItemDataBase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		boolean condition = true;
		LendItemArrayList myList = new LendItemArrayList();
		int selection, format = 1;
		
		while (condition) {
			
			TextIO.put("1) list\n"
					+ "2) add\n"
					+ "3) remove\n"
					+ "4) sort\n"
					+ "5) filter\n"
					+ "6) set format\n"
					+ "0) quit\n"
					);
			selection = TextIO.getInt();
			
			switch (selection) {
			
			case 1:
				list(myList, format);
				TextIO.putln();
				break;
				
			case 2:
				LendItem newItem = new LendItem();
				add(myList, newItem);
				TextIO.putln();
				break;
				
			case 3:
				TextIO.put("enter ID of LendItem to be removed: ");
				int id = TextIO.getInt();
				LendItem removed = remove(myList, id);
				if (removed != null) {
					TextIO.putf("LendItem (ID %d) removed.\n", removed.id);
				}
				else {
					TextIO.put("LendItem not found (ID %d).\n", removed.id);
				}
				TextIO.putln();
				break;
				
			case 4:
				TextIO.put("available sort options:\n"
						+ "1) by lend date\n"
						+ "2) by return date\n"
						+ "3) by by lender\n"
						+ "4) by owner"
						+ "5) by description\n"
						);
				int numb = TextIO.getInt();
				sort(myList, numb);
				TextIO.putln();
				break;
				
			case 0:
				condition = false;
				break;
				
			default:
				break;
			}
		}
	}//end of method

}//end of class
