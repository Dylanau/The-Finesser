package Ingredients;

import mainClasses.Money;
//class sauce is a subclass of ingredient
public class Sauce extends Ingredient{
	//sauce class constructor
	public Sauce(String des, Money mon, int calories) {
		//super initializes variables from the parent class ingredient
		super(des, mon, calories);
		
	}
	
}
