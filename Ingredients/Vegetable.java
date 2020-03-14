package Ingredients;
import java.awt.Color;
import mainClasses.Money;

//vegetable subclass for ingredient
public class Vegetable extends Ingredient {
private final Color myColor; //instance var to store color of each vegetable

//vegetable constructor for new instances
public Vegetable(String desc, Money m, int cal, Color c) {
	super(desc, m, cal); //use super constructor
	myColor = c; //set color instance var
}

//uses color class with this method to return a color
public Color getColor(){
	return  myColor;
}


//toString method override
public String toString() {
    return (super.toString() + getColor().toString());
}

//override equals method
public boolean equals(Object veggie) {
    Vegetable that = (Vegetable) veggie;
    if (this.myColor.equals(that.getColor())) {
        super.equals(that);
    }
    return false;
}

}