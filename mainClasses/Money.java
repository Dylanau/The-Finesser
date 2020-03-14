package mainClasses;



//money class that implements Comparable 
public class Money implements Comparable{
	
	//started by initializing the vars to 0 to keep compiler happy and because we can't have negative values
	private int dollars = 0;
	private int cents = 0;
//compareable imported method compareTo
	@Override
	public int compareTo(Object money){
		// TODO Auto-generated method stub
		//makes sure that this object is an instance of money
		if (money==null || !(money instanceof Money)){
			throw new RuntimeException("invalid params");
		}
		
		Money that = (Money) money;
		if (this.dollars == that.dollars &&
			 this.cents == that.cents) {
			 return 0;
		} else if (that.getMoney() < this.getMoney()){
			return 1;
		} else {
			return -1;
		}
	}
	
	//get money method returns the money from this instance
	public double getMoney(){
		double money = getDollars() + (getCents()*0.01);
		return money;
		
	}
	
	//Money class constructor initializes only dollars
	public Money(int dol){
		this.dollars = dol;
		this.cents = 0;
	}

	//Money class constructor which initializes both dollars and cents
	public Money(int dol, int cent){
		this.dollars = dol;
		this.cents = cent;
	}

	//constructor uses a money object and initializes it
	public Money(Money other){
		if (other == null || other instanceof Money == false){
			System.err.println("Invalid!");
		} else {
		dollars = other.dollars;
		cents = other.cents;
		}
	}	
	
//huge money amount to be initialized
	public Money(double d) {
		// TODO Auto-generated constructor stub
		setDollars((int)d);
		setCents((int)(d-dollars) * 100);
	}

	//setters money object
	public void setMoney(int d, int cent) {
		setDollars(d);
		setCents(cent);
	}

	//to String method prints dollars then cents
	public String toString(){
		return "$" + dollars + "." + cents;
	}
	
	

	public boolean equals(Object other){
		if (other == null || other instanceof Money == false) {
			return false; //if input Obj is null or not an instance of Money class, return false
		}
		
		//if it's NOT null and IS an instance of Money class then:
		Money that = (Money)other;
		//create a new Money object (instance of Money class) called that and store input Obj in it
		
		
		//return true if cents and dollar amounts are equivalent between Money objects
		return this.cents == that.cents && this.dollars == that.dollars;
		
	}

	//override add method for just dollars
	public void add (int dol){
		setDollars((getDollars() + dol));
		//adds the current dollar amount to the input dollar amount, and sets the instance var to new value
		
	}

	//override add method for cents and dollars
	public void add (int dol, int cent){
		
		//make new temp var to store the current dollars plus the input dollars
		int newDollars = (getDollars() + dol);
		
		//make new temp var to store the current cents plus the input cents
		int newCents = (getCents() + cent);
		
		
		//if the new cent value is over 99 then:
		if (newCents > 99) {
			//divide the value by 100, giving you the integer value and no remainder (dollars)
			int tempDollars = (newCents / 100);
			//take modulus 100 of the value, giving you the remainder value (cents)
			int tempCents = (newCents % 100);
			
			setDollars(newDollars + tempDollars);
			//add the new amount of dollars (made up of cents over 99 and the dollar input to this method)
			
			setCents(tempCents);
			//add the new amount of cents (remainder from the modulus)
			
		} else {
			setDollars(newDollars);
			//if cents is still less than 99, then just add the new dollar value to dollars
			
			setCents(newCents);
			//if cents is still less than 99, then just add the new cents value to cents
		}
	}

	//add method
	public void add(Money other){
		
		//make new temp var to store the current dollars plus the other obj's dollars
			int newDollars = (other.getDollars() + getDollars());
			
			//make new temp var to store the current cents plus the other obj's cents
			int newCents = (other.getCents() + getCents());
			
			
			//if the new cent value is over 99 then:
			if (newCents > 99) {
				//divide the value by 100, giving you the integer value and no remainder (dollars)
				int tempDollars = (newCents / 100);
				//take modulus 100 of the value, giving you the remainder value (cents)
				int tempCents = (newCents % 100);
				
				setDollars(newDollars + tempDollars);
				//add the new amount of dollars (made up of cents over 99 and the dollar input to this method)
				
				setCents(tempCents);
				//add the new amount of cents (remainder from the modulus)
				
			} else {
				setDollars(newDollars);
				//if cents is still less than 99, then just add the new dollar value to dollars
				
				setCents(newCents);
				//if cents is still less than 99, then just add the new cents value to cents
			}
		
	}

	//getter for dollars method
	public int getDollars() {
		return dollars;
	}

	//set dollars 
	public void setDollars(int dollars) {
		this.dollars = dollars;
	}

	//getter for Cents method
	public int getCents() {
		return cents;
	}


	public void setCents(int cents) {
		if (cents > 99 || cents < 0) {
			System.err.println("Invalid cent value! Must be between 0 and 99, inclusive.");
			//if cents input value is NOT between 0 and 99, then print error message and exit
			System.exit(-1);
		} else {
		this.cents = cents;
		//if it is a valid input, then set the instance var to the cents input int
		}
	}

}