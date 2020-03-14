package time;

import mainClasses.PizzaManager;
//simple time class from earlier projects which is included with Date and time stamp
public class timeStamp extends Date {    
	private Time myTime;
	private Date myDate;

	
	public timeStamp(Date currentDate, Time currentTime) {
		super(currentDate);
		setTime(currentTime);
		// TODO Auto-generated constructor stub
	}
	
	public void setTime(Time currentTime){
		myTime = new Time(currentTime);
	}

	public Time getTime() { 
		return new Time(myTime);
	}
	public Date getDate() {
		return new Date(this);
	}
	
	public String toString() {
		return "TimeStamp at: " + myTime.getHour() + ":" + myTime.getMinute()+":"+ myTime.getSecond() + " on " + super.toString();
	}
}