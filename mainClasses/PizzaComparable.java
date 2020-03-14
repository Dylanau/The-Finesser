  
package mainClasses;

public interface PizzaComparable extends Comparable {  //Example of interface inheritance
	
	//overrides
	public int compareTo(Object o); 	 		
	public int compareToBySize(Object o); 		
	public int compareToByCalories(Object o);	
	
}