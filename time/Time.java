
package time;

public class Time implements Comparable{
	private int hour, minute, second;

	public Time(){
		hour = 0;
		minute = 0;
		second = 0;
	}
	
	public int compareTo(Object other) {
		if(other == null || !(other instanceof Time) ){
			throw new IllegalArgumentException("Bad params");
		}
		Time that = (Time) other;
		if(this.hour == that.hour && this.minute == that.minute){
			return this.second - that.second;
		}else if(this.hour == that.hour){
			return this.minute - that.minute;
		}else{
			return this.hour - that.hour;
		}
	}
	
	public Time(int h, int m, int s) {
		setHour(h);
		setMinute(m);
		setSecond(s);
	}

	public Time(Time time) {
		if (time != null & time instanceof Time == true){
			this.hour = time.hour;
			this.minute = time.minute;
			this.second = time.second;
		} else {
		throw new IllegalArgumentException("Bad params");
		}
	}

	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		if (hour >= 0 && hour < 24){
			this.hour = hour;
		} else {
			throw new IllegalArgumentException("Only 24 hours in a day! Params between 0 and 24 only.");
		}
	}

	public int getMinute() {
		return minute;
	}

	public void setMinute(int minute) {
		if (minute >= 0 && minute < 60){
			this.minute = minute;
		} else {
			throw new IllegalArgumentException("Only 60 minutes in a hr. Minutes between 0 and 60 only.");
		}
	}

	public int getSecond() {
		return second;
	}

	public void setSecond(int second) {
		if (second >= 0 && second < 60) {
			this.second = second;
		} else {
			throw new IllegalArgumentException("Only 60 seconds in a minute. Seconds between 0 and 60 only");
		}
	}

	public String toString() {
		return "Time: " + getHour() + ":" + getMinute() + ":" + getSecond();
	}

	

	public boolean equals(Object obj) {
		if(obj == null || !(obj instanceof Time) ){
			return false;
		}
		Time that = (Time) obj;
		
		return this.hour == that.hour &&
				this.minute == that.minute &&
				this.second == that.second;
	}
	
	
	

}