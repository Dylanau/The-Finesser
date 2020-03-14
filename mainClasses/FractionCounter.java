package mainClasses;
//class Fraction counter
public class FractionCounter {
	// private class variable for fraction counter
	private Fraction fraction;
	private int counter;

	// FractionCounter constructor to set the class variable
	public FractionCounter(Fraction theFraction) {
		this.fraction = theFraction;
	}
	//compare two fractions and increases the counter if they are equal
	public boolean compareAndIncrement(Fraction compareTo) {
		//uses the fraction equal method to compare the two given fractions
		if (fraction.equals(compareTo) == true) {
			//increments counter variable
			counter++;
			return true;
		} else {
			return false;
		}
	}
	//to string method prints out the count of the fraction and the fraction with the correct format
	public String toString() {
		return "The Fraction " + fraction.getNumerator() + "/" + fraction.getDenominator() + " has a count of "
				+ counter;
	}

}
