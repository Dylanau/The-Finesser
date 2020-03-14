
package mainClasses;

import java.util.Scanner;

public class MyPizzaManager extends PizzaManager {

	private ArrayList<Pizza> pizzaList = new ArrayList<Pizza>();
	// private ArrayList <Money> priceList = new ArrayList<Money>();
	private int numPizzas = 0;

	public void start() {

		Pizza one = new Pizza();
		pizzaList.insert(one, numPizzas++);
		Pizza two = new Pizza();
		pizzaList.insert(two, numPizzas++);
		Pizza three = new Pizza();
		pizzaList.insert(three, numPizzas++);

		super.start();
	}

	protected void displayAllPizzas() {
		System.out.println(pizzaList.toString());
	}

	protected char getNextChar() {
		char[] options = { 'A', 'H', 'E', 'P', 'S', 'C', 'B', 'R', 'Q', 'a', 'h', 'e', 'p', 's', 'c', 'b', 'r', 'q' };

		Scanner keyboard = new Scanner(System.in); // Used to take in users
													// input.
		String input = keyboard.next(); // Take in as string first.
		char selection = input.charAt(0); // Save first char.

		// check if the selection was a menu option
		for (int i = 0; i < options.length; i++) {
			if (options[i] == selection) {
				// return if contained
				return selection;
			}
		}
		// else case; throw exception and break
		throw new PizzaException("not a menu option");
	}

	protected int getNextInt() {
		// use scanner
		Scanner in = new Scanner(System.in);
		// catch next user input int
		int nextInt = in.nextInt();

		// return input value
		return nextInt;
	}

	protected void addRandomPizza() {
		// new random pizza
		Pizza rand = new Pizza();
		// add it to the pizzalist
		pizzaList.insert(rand, numPizzas);
		// increment numpizzas
		numPizzas++;
	}

	protected void eatSomePizza() {
		// scanner object
		Scanner in = new Scanner(System.in);

		// ask what index they want to eat
		System.out.println("What index is the pizza you want to eat, at?");
		int index = in.nextInt(); // catch next input int

		// prompt user input
		System.out.println("What fraction of pizza would you like to eat?");
		String frac = in.next(); // catch user input as string

		// user parse int to get numerator and denominator from string and make
		// fraction
		String[] splitNum = frac.split("/");
		int n = Integer.parseInt(splitNum[0]);
		int d = Integer.parseInt(splitNum[1]);

		Pizza temp = null;

		// try-catch
		try {
			// set pizza temp to the objectat index specified
			temp = (Pizza) pizzaList.objectAt(index);

			// remove fraction that was specified by user
			temp.eatPizza(new Fraction(n, d));
			System.out.println("Eat " + frac + " of the pizza.");
			// print action

			if (temp.getRemaining().getNumerator() == 0) {
				// if the remaining num is 0, remove the pizza from list
				System.out.println("Pizza is all gone!");
				pizzaList.remove(index); // remove
				numPizzas--; // decrement numpizzas
			} else {
				System.out.println("The remaining fraction of pizza is " + temp.getRemaining());
				// print the remaining fraction
				System.out.println();
			}

		} catch (PizzaException e) { // if didn't work
			throw new PizzaException();
			// throw exception error and break
		}
	}

	protected void quickSortByPrice() {
		quickSortByPrice2(0, pizzaList.size() - 1);
	}

	private void quickSortByPrice2(double start, double end) {

		double pivot = getMiddle(start, end); // pick a pivot using a
												// getMiddle()

		// check the relationship between start and pivot
		if (start < pivot - 1) {
			// quicksort
			quickSortByPrice2(start, pivot - 1);
		}

		if (end > pivot) {
			// quicksort
			quickSortByPrice2(pivot, end);
		}

	}

	public double getMiddle(double low, double high) {
		// find the middle of the array
		double middle = ((Pizza) pizzaList.objectAt((int) low)) // Pizza object
																// at index low
				.getPrice().getMoney(), // get the cost and get the Money obj
										// that is equivalent
				first = low, last = high;

		// check cases
		while (first <= last) {

			// check another case
			while (((Pizza) pizzaList.objectAt((int) first)).getPrice().getMoney() < middle) {
				first++; // increment first
			}

			// check another case
			while (((Pizza) pizzaList.objectAt((int) last)).getPrice().getMoney() > middle) {
				last--; // decrement last
			}

			// check another case
			if (first <= last) {
				pizzaList.swap((int) first, (int) last);
				// swap in the pizzalist

				first++; // increment first
				last--; // decrement last
			}
		}
		return first;
	}

	protected void quickSortBySize() {
		sizeSortRecursion(0, pizzaList.size() - 1);
	}

	public void sizeSortRecursion(double low, double high) {
		// choose middle pivot
		double middle = getMiddleSize(low, high);

		// check relationship
		if (low < middle - 1) {
			// recursive call
			sizeSortRecursion(low, middle - 1);
		}
		if (high > middle) { // check relationship
			// recursive call
			sizeSortRecursion(middle, high);
		}
	}

	public double getMiddleSize(double low, double high) {
		double middle = ((Pizza) pizzaList.objectAt((int) low)).getRemainingPizza(), first = low, last = high;
		// pick pivot

		// check case
		while (first <= last) {

			while (((Pizza) pizzaList.objectAt((int) first)).getRemainingPizza() < middle) {
				first++;
				// increment first
			}

			// check case
			while (((Pizza) pizzaList.objectAt((int) last)).getRemainingPizza() > middle) {
				last--;
				// decrement last
			}
			if (first <= last) {
				// check case
				pizzaList.swap((int) first, (int) last);

				// swap objects in pizzalist
				first++;
				last--;
			}
		}
		return first;

	}

	protected void quickSortByCalories() {
		calorieSortRecursion(0, pizzaList.size() - 1);
		// call other method
	}

	public void calorieSortRecursion(double low, double high) {
		// pick pivot using the other method
		double middle = getMiddleCalorie(low, high);

		// check case
		if (low < middle - 1) {
			// recursive call
			calorieSortRecursion(low, middle - 1);
		}

		// check case
		if (high > middle) {
			// recursive call
			calorieSortRecursion(middle, high);
		}
	}

	public double getMiddleCalorie(double low, double high) {
		// pivot
		double middle = ((Pizza) pizzaList.objectAt((int) low)).getCalories(), start = low, end = high;
		// initialize start and end

		// check relationships
		while (start <= end) {
			while (((Pizza) pizzaList.objectAt((int) start)).getCalories() < middle - 1) {
				start++;
				// incrememnt start
			}

			// check relationships
			while (((Pizza) pizzaList.objectAt((int) end)).getCalories() > middle) {
				end--;
				// decrememnt end
			}
			// check relationship
			if (start <= end) {
				pizzaList.swap((int) start, (int) end);

				// swap pizzalist objects
				start++;
				end--;
			}
		}
		return start; // return the starting point
	}

	protected int binarySearchByCalories(int cals) {
		quickSortByCalories(); // call quicksort to sort array first

		int low = 0;
		int hi = pizzaList.size() - 1;

		// pick start and end

		int middle;

		// check relationship
		while (low <= hi) {

			middle = (low + hi) / 2;
			// set middle

			// check relationships
			if (cals < (((Pizza) pizzaList.objectAt(middle)).getCalories())) {
				hi = (middle - 1); // reset hi
			}

			// check relatiolnships
			else if (cals == (((Pizza) pizzaList.objectAt(middle)).getCalories())) {
				return middle;
				// return the middle if equal
			}

			// check relationsihps
			else if (cals > (((Pizza) pizzaList.objectAt(middle)).getCalories())) {
				// reset low
				low = (middle + 1);
			}
		}
		// else case
		// exit and return error
		throw new PizzaException("Sorry, we don't have a pizza with " + cals + " many calories!");

	}

	protected int linearSearchByDay(int day) {

		// iterate over array
		for (int i = 0; i < numPizzas; i++) {
			// if input day and day made is the same then return pizza obj
			if (((Pizza) pizzaList.objectAt(i)).getMadeDate().getDay() == day) {
				System.out.println(pizzaList.objectAt(i) + " was made on the " + day + "day.");
				return i;
			}
		}
		// else return no pizzas
		System.out.println("There are no pizzas made on that day.");
		return -1;

	}

	protected void removeDayOldPizzas() {

		// iterate over array
		for (int i = 0; i < numPizzas; i++) {

			if (super.getCurrentDate().getDay() - ((Pizza) pizzaList.objectAt(i)).getMadeDate().getDay() >= 1) {
				// if the pizza is a day old or older remove it
				System.out.println(pizzaList.objectAt(i) + " is a day-old pizza, so it will be removed.");
				pizzaList.remove(i); // remove
				numPizzas--; // decrement numPizzas
			}
		}
		System.out.println("There are no old pizzas to remove."); // else case
		// no pizzas to remove
	}

	protected void reversePizzasWithStack() {
		ArrayList<Pizza> temp = new ArrayList<Pizza>();
		// new temp pizzalist (arraylist)

		for (int i = 0; i < pizzaList.size(); i++) {
			// iterate over array

			// insert the temp
			temp.insert((Pizza) pizzaList.objectAt(pizzaList.size() - (1 + i)), i);
		}
		// reset the pizzalist
		pizzaList = temp;
	}

}