package Ingredients;

import mainClasses.Money;
//subclass for meat
public class Pepperoni extends Meat{
	//constructor for the pepperoni class
	public Pepperoni(){
		//uses constructor from parents class
		super("Pepperoni", new Money(2,00),200);
	}
}
