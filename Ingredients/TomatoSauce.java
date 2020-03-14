package Ingredients;

import mainClasses.Money;

//this is a subclass of the Sauce Class
public class TomatoSauce extends Sauce{
	//constructor for this class
	public TomatoSauce(){
		//uses constuctor from super class
		super("Tomato sauce", new Money(0,50), 75);
	}
}
