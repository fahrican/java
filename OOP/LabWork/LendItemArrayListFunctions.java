package bwi.prog1B.WS1617.wi16b027_Can.LabWork;

import bwi.prog.utils.TextIO;
import static bwi.prog1B.WS1617.wi16b027_Can.LabWork.LendItemFunctions.*;

public class LendItemArrayListFunctions {

	public static boolean add(LendItemArrayList list, LendItem p){
		
		if (list.next < list.lendItems.length) {
			
			list.lendItems[list.next] = p;
			list.next++;
			return true;
		}
		else {
			
			if (list.resizeable) {
				
			
				LendItem[] tempArr = new LendItem[list.lendItems.length * 2];

				for (int i = 0; i <= list.lendItems.length; i++) {

					tempArr[i] = list.lendItems[i];
				}

				tempArr[list.lendItems.length] = p;
				list.lendItems = tempArr;
				list.next++;
				return true;
			}
		}
		
		return false;
	}//end of method
	
	public static LendItem remove(LendItemArrayList list, int n){
		
		if (n < list.next || n < 0) {
			
			LendItem[] tempArr = new LendItem[list.lendItems.length];
			LendItem deletedItem = null;
			
			for (int i = 0; i < list.next; i++) {
				
				if (i == n) {
					deletedItem = list.lendItems[i];
				}
				else if (n < i) {
					tempArr[i-1] = list.lendItems[i];
				}
				else {
					tempArr[i] = list.lendItems[i];
				}
			}
			list.lendItems = tempArr;
			list.next--;
			return deletedItem;
		}
		return null;
		
	}//end of method

	public static int list(LendItemArrayList list, int format){
		
		if (list.next == 0) {
			TextIO.putln("List empty.");
			return 0;
		}
		
		TextIO.putln(lendItemHeadings(format));
		TextIO.putln(lendItemSeperator(format));
		for (int i = 0; i < list.next; i++) {
			TextIO.put(lendItemString(list.lendItems[i], format));
			TextIO.putf("\t(%02d)\n", i);
		}
		TextIO.putln();
		TextIO.putf("%d LendItem(s) in list, %d free", list.next, list.lendItems.length - list.next);
		TextIO.putln();
		return list.lendItems.length;
	}//end of method
	
	public static void sort(LendItemArrayList list, int order){
		
	}

	
}//end of class
