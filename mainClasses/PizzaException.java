package mainClasses;
//pizza exception subclass
public class PizzaException extends RuntimeException{
	//super constructor from runtime parent class
	public PizzaException(String string){
		super(string);
	}
	//no arg constructor for subclass
	public PizzaException(){
		//super using parents constructor with this string
		super("Error in making your pizza");
	}
	
}
