import java.awt.Color;
import java.awt.Graphics;
import java.io.Serializable;

import javax.swing.JButton;
import javax.swing.JComponent;

public abstract class Shape extends JComponent implements Serializable {
	
	private int x;
	private int y;
	private int width;
	private int height;
	private Color color;
	
	public Shape() {
		
	}
	
	public Shape(int x, int y, int width, int height, Color color) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.color = color;
	}	
	
	public abstract void paintComponent(Graphics g);
	
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

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color newColor) {
		color = newColor;
	}
	
	public void print() {
		System.out.println(this.x);
		System.out.println(this.y);
		System.out.println(this.width);
		System.out.println(this.height);
		System.out.println(this.color);
	}
	
	public abstract Shape addDummyShape(Shape shape);
}
