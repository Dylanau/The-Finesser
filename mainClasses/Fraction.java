package mainClasses;

//Dylan Usoro
//implements comparable
public class Fraction implements Comparable {
	// primitive type class variables
	private int numerator;
	private int denominator;

	// override
	public int compareTo(Object o) {

		return 0;
	}

	// default constructor
	Fraction() {
		// uses setters to initialize variaables
	}

	// construcotr to initialize data without setters
	Fraction(int num, int denom) {
		// checks if the denominator is 0
		if (denom == 0) {
			// will print out an error message if so
			System.out.println("Invalid denominator for the fraction" + num + "/" + denom);
		} else if (num == 0) {
			// if the numerator is 0 as well it will tell the user there is a
			// zero fraction
			System.out.println("Numerator is 0");
		} else {
			// uses the gcm method to reduces the numerator and denominator if
			// necessary
			int gcm = gcm(num, denom);
			// divides num by the gcm
			num = num / gcm;
			// reduces by dividing by gcm
			denom = denom / gcm;
		}
		// sets up the numerator and denominator to the class variable
		setDenominator(denom);
		setNumerator(num);
	}

	public Fraction(Fraction remainingPizza) {
		// TODO Auto-generated constructor stub
		numerator = remainingPizza.numerator;
		denominator = remainingPizza.denominator;
	}

	// gcm method to find the gcm of the num and denom
	public static int gcm(int a, int b) {
		// returns same code from Fractions V1
		return b == 0 ? a : gcm(b, a % b);
	}

	// getter method for numerator
	public int getNumerator() {
		return this.numerator;
	}

	// getter method for denominator
	public int getDenominator() {
		return this.denominator;
	}

	// sets the numerator class variable
	public void setNumerator(int num) {
		this.numerator = num;
	}

	// checks the zero denominator and sets it to the class variable
	public void setDenominator(int denom) {
		if (denom == 0) {
			this.denominator = denom;
			System.out.println("Invalid denominator for the fraction" + this.numerator + "/" + this.denominator);
		} else {
			this.denominator = denom;
		}
	}

	// compares to fraction variables and returns true or false if they are the
	// same
	public boolean equals(Fraction other) {
		return this.numerator == other.numerator && this.denominator == other.denominator;
	}

	public int compareTo(Fraction remainingPizza) {
		// TODO Auto-generated method stub
		return 0;
	}

	public double toDecimal() {
		return (double) (getNumerator() / getDenominator());
	}

	// remove method for fraction
	public Fraction remove(Fraction amount) {
		// TODO Auto-generated method stub
		int n, d = 0;

		if (getDenominator() == amount.getDenominator()) {
			n = (getNumerator() - amount.getNumerator());
			d = getDenominator();
			return new Fraction(n, d);
		} else {
			n = (getNumerator() * amount.getDenominator()) - (amount.getNumerator() * getDenominator());
			d = getDenominator() * amount.getDenominator();
			return new Fraction(n, d);
		}
	}

}
