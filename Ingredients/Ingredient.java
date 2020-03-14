package Ingredients;
//imports class from the packages of Money and Exception
import mainClasses.Money;
import mainClasses.PizzaException;
//Parent class for all the categories of ingredients
public abstract class Ingredient implements Comparable {
	//instance variables
	//Money object tracks the cost of the ingredients
	private final Money cost; 
	private final int cals; //keeps tracks of calories of the ingredients
	private final String description; //String variable for the explanation of each ingredient
	
	//
	public Ingredient(String des, Money mon, int calories){
		//set all instance variables
		description = des;
		cost = mon;
		cals = calories;
	}
	
	//getter for the string describer
	public String getDesc(){
		return description;
	}
	
	//getter method for the price of the food
	public Money getPrice(){
		return cost;
	}
	
	//getter for the cost variable
	public int getCalories(){
		return cals;
	}
	
	//override method for the implementation of comparable
	public int compareTo(Object food){
		if (food == null || !(food instanceof Ingredient)){ //null check and instanceof check
			throw new RuntimeException("invalid parameter"); //throw exception and break if invalid parameters are given
		}
		//makes if sections return the same as any compare method
		Ingredient that = (Ingredient)food; //cast parameter object as Ingredient
		if (this.getPrice().equals(that.getPrice())){ //compare the prices; if the same return 0
			return 0;
		} else if (this.getPrice().compareTo(that.getPrice()) ==1){ //return 1 if param is greater than this.getPrice()
			return 1;
		} else {
		return -1; //return -1 if this.getPrice() is bigger than price of parameter obj
		}
	}
	//overriding the to String method to print out the cost, cals and description
	public String toString(){
		String retVal = "";
		retVal += getDesc() + "(" + getCalories() + " calories; " + getPrice() + ")";
		return retVal;
	}
	
}
