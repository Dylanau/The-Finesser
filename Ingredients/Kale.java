package Ingredients;
//imports for the Kale class
import java.awt.Color;
import mainClasses.Money;
//Kale class that extends vegetable
public class Kale extends Vegetable{
	//contructor for Kale class
	public Kale(){
		//super uses parents class to initialize variables
		super("Kale", new Money(2,75), 20, Color.GREEN);
	}
}
