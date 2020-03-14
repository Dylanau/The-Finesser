package mainClasses;

import java.awt.Color;
import java.util.Calendar;
import java.util.Random;

import Ingredients.BBQSauce;
import Ingredients.Chicken;
import Ingredients.FetaCheese;
import Ingredients.CheddarCheese;
import Ingredients.Ingredient;
import Ingredients.Kale;
import Ingredients.Onion;
import Ingredients.Pepperoni;
import Ingredients.TomatoSauce;
import shapes.Circle;
import shapes.Shape;
import shapes.Square;
import time.Date;
import time.timeStamp;

public class Pizza implements PizzaComparable{
	private Date made;
	private int calories = 0;
	private Fraction remainingPizza = new Fraction(1, 1);
	private Money price = new Money(5,0);
	private Shape shape;
	private ArrayList<Ingredient> ingredientList = new ArrayList<Ingredient>();
	private int numIngredients;	
	/*
	 * TODO: Data definitions here, like the ArrayList of ingredients 
	 */
	
	public Pizza() { 
		//  this one makes a random pizza as far as ingredients and shape & size go
		Random rand = new Random();
		//new random
		
		//choose between shape by random
		if (rand.nextInt(2) ==1){
			shape = new Square();
		} else {
			shape = new Circle();
		}
		//set shape
		setShape(shape);
		
		//choose between sauce by random
		Ingredient sauce;
		if (rand.nextInt(2) ==1){
			sauce = new TomatoSauce();
		} else {
			sauce = new BBQSauce();
		}
		addIngredient(sauce);//add the sauce
		
		//choose between cheese by random
		Ingredient cheese;
		if (rand.nextInt(2)==1){
			cheese = new CheddarCheese();
		} else {
			cheese = new FetaCheese();
		}
		addIngredient(cheese); //add the cheese
		
		//choose between meat by random
		Ingredient meat;
        if (rand.nextInt(2) == 1) {
	        meat = new Chicken();
        } else {
        	meat = new Pepperoni();
        }
        addIngredient(meat);
        Ingredient veggies;

		//choose between veggies by random
        if (rand.nextInt(2) == 1) {
        	veggies = new Kale();
        } else {
        	veggies = new Onion();
        }
        addIngredient(veggies);
        
        
		Calendar cal = Calendar.getInstance();
		//get a random number and set it to day
		Random rando = new Random();
		int randomDay = (int) Math.random()*32;
		//between 0 and 32
		while (randomDay == 0) {
		//if 0, chose another one
			randomDay = rando.nextInt(32);
		}
		//made date is a new timestamp
		 made = new timeStamp(new Date(cal.getTime().getMonth(), randomDay, cal.getTime().getYear()), PizzaManager.getCurrentTime());
	}
	
	
	 public void addIngredient(Ingredient ing){
		 if (ing == null){ //null check, if null throw excp
			 throw new PizzaException("Ingredient doesn't exist");
		 } 
		 
		 calories += ing.getCalories(); //add calls
		 price.add(ing.getPrice()); //add cost
		 ingredientList.insert(ing, numIngredients); //insert ingredient
		 numIngredients++; //increment numingredients
	 }
	 
	
	 public void setShape(Shape s){
		 shape = s;
	 }
	
	
	 public String toString(){
		 return "This " + shape.toString() + " pizza's TOPPINGS are: \n" + ingredientList.toString() + "totaling " + getCalories() + 
				 " calories and costing " + getPrice() + ". \nThe fraction of pizza remaining is " +
				 getRemaining() + "\n" + made.toString() + ". \n" ;
	 }
	 
	 
	 public void eatPizza(Fraction amount){
		 Fraction rem = new Fraction(remainingPizza.remove(amount));
		 remainingPizza = rem;
	 }
	 
	 
	
	public Date getMadeDate() { 
		return new Date(made); 
		
		}

	
	public int getCalories(){
		return this.calories;
	}

	
	public int compareTo(Object o) {
		if (o != null && o instanceof Pizza == true){
		return getPrice().compareTo(((Pizza) o).getPrice());
		} else {
		throw new IllegalArgumentException("bad params");
		}
	}
	

	
	public int compareToBySize(Object o) {
		// TODO Auto-generated method stub
		if (o != null && o instanceof Pizza == true){
			Pizza that = (Pizza) o;
			return remainingPizza.compareTo(that.remainingPizza);
			} else {
			throw new IllegalArgumentException("bad params");
			}
	}

	
	public int compareToByCalories(Object o) {
		if (o == null && !(o instanceof Pizza == true)){
			throw new IllegalArgumentException("bad params");
		}
		Pizza that = (Pizza) o;

		if (getCalories() == that.getCalories()){
			return 0;
		} else if (getCalories() < that.getCalories()){
			return -1;
		} else {
			return 1;
		}
	}
	
	
	public Money getPrice(){
		return new Money(this.price.getMoney() * getRemaining().toDecimal());
	}
	
	
	public Fraction getRemaining() {
		// TODO Auto-generated method stub
		return new Fraction(remainingPizza);

	}
	
	
	public double getRemainingPizza(){
		return (getRemaining().toDecimal());

	}
	
	
}
