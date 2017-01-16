package bwi.prog1B.WS1617.wi16b027_Can.LabWork;

public class LendItemArrayList {
	
	public int INITIAL_SIZE = 20;
	public boolean resizeable = false;
	public LendItem[] lendItems = new LendItem[INITIAL_SIZE];
	public int next = 0;
}
