package shapes;

import java.awt.Color;

import java.awt.Graphics;
import java.text.DecimalFormat;
import java.util.Random;


public class Square extends Shape implements Cloneable {
	//instance variables
	private int x;
	private int y;
	private double sideLength;
	private String shape = "[]";
	private Color myColor;
	
	
	
	public Object clone() {
		try {
			return new Square(getX(), getY(), (int)getSideLength(), getColor());
		} catch (IllegalArgumentException e){
			throw new RuntimeException("Bad parameters");
		}
	}

	public double getArea() {
		return (getSideLength()*getSideLength());
	}
	

		public Square(int x, int y, int sl, Color c){
			super(x, y, c);
			setSideLength(sl);
		}
		
		
		
		public Square() {
			// TODO Auto-generated constructor stub
			super();
			double val = Math.random()*20;
			setSideLength(val);
		}

		
		public void draw(Graphics g) {
			g.draw3DRect(getX(), getY(), (int)getSideLength(), (int)getSideLength(), true);
		}
		
		public void setColor(Color c){
			this.myColor = c;
		}
		
		
		public Color getColor(){
			return myColor;
		}
		
		
		public int getX(){
			return x;
		}
		
		
		public int getY(){
			return y;
		}
		
		
		public double getSideLength(){
			return this.sideLength;
		}
		
		
		
		public void setX(int nx){
			this.x = nx;
		}
		
		
		public void setY(int ny){
			this.y = ny;
		}
		
		
		public void setSideLength(double sl){
			this.sideLength = sl;
		}
		
		
		public String toString() {
			DecimalFormat df = new DecimalFormat();
			df.setMaximumFractionDigits(2);
			return "square, " + df.format(getSideLength()) + "-inch";
		}
		
		
		public boolean equals(Square that){
			if (this.x == that.x && 
				this.y == that.y &&
				this.sideLength == that.sideLength) {
		return true;
			} else {
		return false;
			}
		}

		@Override
		public double getRadius() {
			// TODO Auto-generated method stub
			return getSideLength();
		}
	}