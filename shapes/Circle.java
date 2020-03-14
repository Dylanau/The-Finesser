
package shapes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.text.DecimalFormat;


public class Circle extends Shape implements Cloneable {
	
		private double radius;
		private Color myColor;
		private int x, y;
		
		
		
		public Circle(int nx, int ny, double r, Color c){
			super(nx, ny, c); //uses Shape constructor
			setRadius(r);
		}

		public Circle() {
			// TODO Auto-generated constructor stub
			super();
			double val = Math.random()*10;
			setRadius(val);
		}

		
		public Object clone() {
			try {
				return new Circle(getX(), getY(), getRadius(), getColor());
			} catch (IllegalArgumentException e){
				throw new RuntimeException("Bad parameters");
			}
		}
		
		
		public double getArea() {
			return (Math.PI*(radius*radius));
			
		}
		
		
		public void setColor (Color c){
			this.myColor = c;
		}
		
		
		
		public void draw(Graphics g) {
				
				Graphics2D g2d = (Graphics2D) g; //new Graphics2D object set to input Graphics g
				
				g2d.setColor(myColor); //sets color to first color
				
				g2d.fillOval(getX(), getY(), (int)getRadius(), (int)getRadius());
				//draws and fills the object with setcolor, starting at (x,y) and using the radius to create size of circle
				
			}
		
	
		public double getRadius(){
			return (this.radius);
		}
		
		

	
		public void setRadius(double r){
			this.radius = r;
		}

	
		public String toString(){
			DecimalFormat df = new DecimalFormat();
			df.setMaximumFractionDigits(2);
			return "circular, " + df.format(getRadius()*2) + "-inch";
		}

		
		public double getSideLength() {
			// TODO Auto-generated method stub
			return getRadius()*2;
		}
	}