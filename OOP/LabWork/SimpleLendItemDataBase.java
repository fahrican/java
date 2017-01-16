package bwi.prog1B.WS1617.wi16b027_Can.LabWork;

import bwi.prog.utils.TextIO;
import static bwi.prog1B.WS1617.wi16b027_Can.LabWork.LendItemFunctions.*;
import static bwi.prog1B.WS1617.wi16b027_Can.LabWork.LendItemArrayListFunctions.*;

public class SimpleLendItemDataBase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int userInput, format = 1;
		LendItemArrayList list = new LendItemArrayList();
		
		do {
			
			TextIO.put("1) list\n"
					+ "2) add\n"
					+ "3) remove\n"
					+ "4) sort\n"
					+ "5) filter\n"
					+ "6) set format\n"
					+ "0) quit\n"
					);
			
			userInput = TextIO.getInt();
			
			switch (userInput) {
			
			case 1:
				TextIO.put("1) for full format\n"
						+ "2) for short format\n"
						+ "3) for default format\n"
						);
				format = TextIO.getInt();
				list(list, format);
				TextIO.putln();
				break;
				
			case 2:
				TextIO.putf("your choice: %d\n", userInput);
				LendItem newItem = scanLendItem();
				if(add(list, newItem)){
					TextIO.putln("1 item added.");
				}
				else {
					TextIO.putln("Something went wrong!");
				}
				break;
				
			case 3:
				TextIO.put("enter ID of LendItem to be removed: ");
				format = TextIO.getInt();
				LendItem removedItem = remove(list, format);
				if (removedItem != null) {
					TextIO.putf("1 LendItem %d removed.\n", removedItem.id);
				}
				else {
					TextIO.putf("1 LendItem (ID = %d) removed.\n", removedItem.id);
				}
				break;
				
			case 4:
				TextIO.put("available sort options:\n"
						+ "1) by lend date\n"
						+ "2) by return date\n"
						+ "3) by by lender\n"
						+ "4) by owner\n"
						+ "0) by description\n"
						);
				format = TextIO.getInt();
				list(list, format);
				TextIO.putln();
				break;
				
			case 5:
				TextIO.put("enter description: ");
				String desc = TextIO.getln();
				LendItemArrayList filteredItem = filterByDescription(list, desc);
				TextIO.putln();
				list(filteredItem, format);
				TextIO.putln();
				break;
				
			case 6:
				TextIO.put("available options:\n"
						+ "1) full format\n"
						+ "2) short format\n"
						+ "3) csv format\n"
						+ "Choose format:"
						);
				format = TextIO.getInt();
				lendItemString(list.lendItems[format], format);
				break;

			default:
				break;
			}
			
		} while (userInput != 0);
	}//end of method

}//end of class
