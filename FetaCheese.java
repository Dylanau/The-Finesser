package Ingredients;

import mainClasses.Money;
//this subclass extends cheese and uses its constructors
public class FetaCheese extends Cheese {
	//constuctor for FetaCheese
	public FetaCheese() {
		//intializes variables
		super("Feta Cheese", new Money(1, 00), 350);
	}
}
