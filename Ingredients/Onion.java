package Ingredients;
//imports for the Onion class
import java.awt.Color;
import mainClasses.Money;
//onion class that extends vegetable
public class Onion extends Vegetable{
	//constructor that uses the parents class to construct the onions name, price and color
	public Onion(){
		super("Onion" ,new Money(1,0), 20, Color.WHITE);
	}
}
