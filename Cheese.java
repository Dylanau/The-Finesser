package Ingredients;
//import main class package money
import mainClasses.Money;

public class Cheese extends Ingredient{
	//Constructor for Cheese
	public Cheese(String des, Money mon, int cals){
		//uses parent class to initialize variable
		super(des, mon, cals);
	}
}
