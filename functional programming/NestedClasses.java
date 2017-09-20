package hackerrank;

import java.util.*;


public class NestedClasses {
	
	private final int a = 20;
	private double g = 33.33;
	private static final int problems = 99;
	String name = "Hellooo";
	static String butler = "Alfo";
	
	private static String testStatic() {
		return "Alfred";
	}
	
	
	class InnerTest {
		
		String stat = testStatic();
		private static final String haha = "Hahaha";
		
		double product() {
			return a * g;
		}
		
		String printName() {
			return name;
		}
		
		double secondProduct() {
			return g * problems;
		}
		
		String butlerName() {
			return butler;
		}
		
	}//end of InnerTest class
	
	static class InnerStatictest {
		
		int a = 33;
		final int b = 11;
		static final int c = 22;
		String alfred = testStatic();
		
		double product2() {
			return a;
		}
		
		String printName2() {
			return butler;
		}
		
		double secondProduct2() {
			return problems;
		}
		
		public static void main(String[] args) {
			
			System.out.println("Hailo");
		}
		
	}//end of InnerStaticTest class
	
	interface Plant {
		
		public abstract void isGrowing();
		
	}//end of Plant interface
	
	public static void main(String[] args) {
		
		NestedClasses myObj = new NestedClasses();
		myObj.display();
		
		Plant myPlant = new Plant() {

			@Override
			public void isGrowing() {
				// TODO Auto-generated method stub
				System.out.println("The plant is growing....");
			}
			
			
		};
		myPlant.isGrowing();
	}
	
	public void display() {
		
		class LokaleInnereKlasse {
			
			public void message() {
				System.out.println(a * 2);
			}
			
		}//end of LokaleKlasse class
		
		LokaleInnereKlasse obj = new LokaleInnereKlasse();
		obj.message();
	}

}// end of class NestedClasses
