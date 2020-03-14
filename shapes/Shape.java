package shapes;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Shape implements Cloneable {
	private int x = 0, y = 0;
	private Color myColor;

	@Override
	public abstract Object clone();

	public Shape() {
	}

	public Shape(int nx, int ny, Color c) {
		setX(nx);
		setY(ny);
		setColor(c);
	}

	public abstract double getSideLength();

	public abstract double getRadius();

	public Shape(Shape other) {
		setX(other.x);
		setY(other.y);
		setColor(other.myColor);
	}

	public void setColor(Color c) {
		this.myColor = c;
	}

	public Color getColor() {
		return myColor;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public abstract void draw(Graphics g);

	public abstract double getArea();
}