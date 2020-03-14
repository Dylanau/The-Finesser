package time;

public class Date {

	private int day;
	private int month;
	private int year;
	

	public Date(int inputM, int inputD, int inputY){
		setDate(inputM, inputD, inputY);
	}
	

	public Date(Date date){

		this(date.getMonth(), date.getDay(), date.getYear());
	}


	public void setDate(int nMonth, int nDay, int nYear){
		setMonth(nMonth);
		setDay(nDay);
		setYear(nYear); //reusing code helps prevent privacy leaks
		//calls the setDate method and sets it to input month, day, and year
	}
	

	public void setMonth(int m){
		if (m >= 1 && m <= 12) {
			//if nMonth is between 1 and 12 inclusive,
			this.month = m;
			//set the instance var month to nMonth
		} else {
			//if not, print error message
			System.err.println("Invalid month value. Must be between 1 and 12, inclusive.");
		}
	}
	
	
	
	public void setDay (int nDay){
		if (nDay >= 1 && nDay <= 31) {
			//if the day is between 1 and 31 then set the instance var to this
			this.day = nDay;
		}
	}
	
	

	public void setYear(int y){
		if (y >= 2014 && y <= 2016){
			//invariant
			this.year = y; 
			
		}
	}
	

	public int getMonth(){
	return month;
	}
	

	public int getYear(){
	return year;
	}


	
	public int getDay(){
		return day;
	}

	
	public boolean equals(Object other){
		if (other == null) { 
			return false;
		}
		if (other instanceof Date == false) {
			return false;
		}
		Date that = (Date) other;

		return this.getDay() == that.getDay() && this.getMonth() == that.getMonth() && this.getYear() == that.getYear();
		}

	public String toString() {
		return getMonth() + "/" + getDay() + "/" + getYear();
	}
	
}