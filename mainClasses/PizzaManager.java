package mainClasses;
//imports all these classes
import java.util.Calendar;
import shapes.Shape;
import java.util.Scanner;
import time.Date;
import time.Time;
//driver class
public class PizzaManager {
	public final static void main(String[] args) {
		PizzaManager manager = new MyPizzaManager(); //new MyPizzaManagerSoln();  
		manager.start();
	}
	public void start() {
		
		
		
		while(true) {
			displayAllPizzas();
			displayInstructions();


			switch( getNextChar() ) { 
			
				case	'A':	case	'a':    addRandomPizza();
												break;
				case	'H':    case	'h':	addOneHundredPizzas();
												break;					
				case	'E':    case	'e':	eatSomePizza();
												break;			
				case	'P':    case	'p': 	quickSortByPrice();
												break;	
				case	'S':   	case	's': 	quickSortBySize();
												break;
				case	'C':    case	'c':  	quickSortByCalories();
												break;
				case    'L':    case    'l':    System.out.println("What day are you looking for?");
												linearSearchByDay(getNextInt());
												break;
				case    'D':    case    'd':    removeDayOldPizzas();
												break;
				case	'B':	case	'b':	System.out.println("What calorie count are you looking for?");
												binarySearchByCalories(getNextInt());
												break;
				case    'R':    case 	'r':    reversePizzasWithStack();	
												break;
				case    'Q': 	case 	'q':	System.out.println("(Q)uitting...");
												System.exit(0);
												break;
				default:						System.out.println("Unrecognized input - try again");
			}
		}
		

	}
	//helper methods for pizza mangers
	protected static final String instructions = "-----------------------\nWelcome to PizzaManager\n-----------------------\n(A)dd a random pizza\nAdd a (H)undred random pizzas\n(E)at a fraction of a pizza\nQuickSort pizzas by (P)rice\nQuickSort pizzas by (S)ize\nQuickSort pizzas by (C)alories\n(B)inary Search pizzas by calories\n(L)inear search pizzas by day\n(R)everse order of pizzas with a stack\nRemove (D)ay-old pizzas\n(Q)uit\n";
	protected void displayInstructions() {
		System.out.println(instructions);	
	}
	
	@SuppressWarnings("deprecation")
	public static Date getCurrentDate() {
		Calendar cal = Calendar.getInstance();
		return new Date(cal.getTime().getMonth(), cal.getTime().getDay(), cal.getTime().getYear());
	}
	
	@SuppressWarnings("deprecation")
	public static Time getCurrentTime() {
		Calendar cal = Calendar.getInstance();
		return new Time(cal.getTime().getHours(), cal.getTime().getMinutes(), cal.getTime().getSeconds()); 
	}
	
	public void addOneHundredPizzas() {
		System.out.println("Adding one hundred random pizzas to the ArrayList<Pizza>.");
		for(int i = 0; i < 99; i++) {
			addRandomPizza();
		}
	}
	//protected methods for this class
	protected char getNextChar() {
		char[] options = {'A','H','E','P','S','C','B','R','Q'};
		return options[(int)(Math.random() * options.length)];  
	}
	
	protected int getNextInt() {
		return (int)(Math.random()*9+1); 
	}
	
	protected void displayAllPizzas() {
		System.out.println("Method not overridden");
	}
	
	protected void eatSomePizza() {
		System.out.println("Method not overridden");
	}
   
	protected void addRandomPizza() {
		System.out.println("Method not overridden");
	}
	
    protected void quickSortByPrice() {
		System.out.println("Method not overridden");
    }

	protected void quickSortBySize() {
		System.out.println("Method not overridden");
	}

	protected void quickSortByCalories() {
		throw new RuntimeException( "quickSortByCalories() not yet implemented in MyPizzaManager subclass!");
	}

	protected int binarySearchByCalories(int cals) {
		
		throw new RuntimeException( "binarySearchByCalories() not yet implemented in MyPizzaManager subclass!");
	}
	
	protected int linearSearchByDay(int day) {
		throw new RuntimeException( "linearSearchByDay() not yet implemented in MyPizzaManager subclass!");
	}
	
	protected void removeDayOldPizzas() {
		throw new RuntimeException( "removeDayOldPizzas() not yet implemented in MyPizzaManager subclass!");
	}
	
	protected void reversePizzasWithStack() {
		throw new RuntimeException( "reversePizzasWithStack() not yet implemented in MyPizzaManager subclass!");
	}
	
	
}
