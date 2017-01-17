package bwi.prog1B.WS1617.wi16b027_Can.LabWork;

import bwi.prog.utils.TextIO;
import static bwi.prog1B.WS1617.wi16b027_Can.LabWork.LendItemFunctions.*;

public class LendItemArrayListFunctions {
	
	public static boolean add(LendItemArrayList list, LendItem p) {
		
		if(list.next < list.lendItems.length) {
			// list still has empty room
			list.lendItems[list.next] = p;
			list.next++;
			return true;
		}
		else {
			// list is full
			if(list.resizeable) {
				LendItem[] newLendItems = new LendItem[list.lendItems.length * 2];
				for(int i = 0; i < list.lendItems.length; i++) {
					newLendItems[i] = list.lendItems[i];
				}
				newLendItems[list.lendItems.length] = p;
				list.lendItems = newLendItems;
				list.next++;
				return true;
			} 
			return false;
		}
	}//end of method
	
	public static LendItem remove(LendItemArrayList list, int n){
		
		if(n < list.next || n < 0) {
			
			LendItem[] newLendItems = new LendItem[list.lendItems.length];
			LendItem deleted = new LendItem();
			
			for (int i = 0; i < list.next; i++) {
				
				if(i == n) {
					deleted = list.lendItems[i];
				}
				else if(i > n) {
					newLendItems[i-1] = list.lendItems[i];
				}
				else {
					newLendItems[i] = list.lendItems[i];
				}
			}
			list.lendItems = newLendItems;
			list.next--;
			
			return deleted;
			}
		return null;
				
	}// end of method
	
	public static int list(LendItemArrayList list, int format){
		
		int items = 0;
		
		if (list.next == 0) {
			TextIO.putln("List empty");
			return 0;
		}
		
		TextIO.putln(lendItemHeadings(format)); 
		TextIO.putln(lendItemSeparator(format)); 
		
		for (int i = 0; i < list.next; i++) {
			
			if (list.lendItems[i] == null) {
				break;
			}
			TextIO.put(lendItemString(list.lendItems[i], format) + "(" + i + ")\n");
			items++;
		}
		TextIO.putln(lendItemSeparator(format));
		TextIO.putf("%d LendItem(s) in list, %d free\n", items, list.lendItems.length - items);
		
		return items;
		
	}// end of method
	
	// BubbleSort algorithm
	public static void sort(LendItemArrayList list, int order){
		
		LendItem tempItem = new LendItem();
		
		for (int i = 0; i < list.next - 1; i++) {
			
			for (int j = 0; j < list.next - 1; j++) {
				
				if (compare(list.lendItems[j], list.lendItems[j+1], order) == 1) {
					
					tempItem = list.lendItems[j];
					list.lendItems[j] = list.lendItems[j+1];
					list.lendItems[j+1] = tempItem;
				}
			}
		}
		
	}// end of method
	
	public static LendItemArrayList filterByDescription(LendItemArrayList list,String desc){
		
		LendItemArrayList descArr = new LendItemArrayList();
		descArr.resizeable = true;
		
		for (int i = 0; i < list.next; i++) {
			
			if (list.lendItems[i].description.contains(desc)) {
				
				add(descArr, list.lendItems[i]);
			}
		}
		return descArr;
		
	}// end of method
	
	public static int findByID(LendItemArrayList list, int id){
		
		for (int i = 0; i < list.next; i++) {
			
			if (list.lendItems[i].id == id) {
				return i;
			}
		}
		
		return -1;
	}// end of method
	
}//end of class
