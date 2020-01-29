package logics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 * SnakeBody is one part of the tail of the Snake. 
 * @author erika712
 *
 */
public class SnakeBody {

	private int currentX;
	private int currentY;
	private int prevX;
	private int prevY;
	private final int width = 15;
	private final int height = 15;

	public SnakeBody(int x, int y) {
		this.currentX = x;
		this.currentY = y;

	}

	public int getPrevX() {
		return this.prevX;
	}

	public void setPrevX(int prevX) {
		this.prevX = prevX;
	}

	public int getPrevY() {
		return prevY;
	}

	public void setPrevY(int prevY) {
		this.prevY = prevY;
	}

	public int getCurrentX() {
		return currentX;
	}

	public void setCurrentX(int currentX) {
		this.currentX = currentX;
	}

	public int getCurrentY() {
		return currentY;
	}

	public void setCurrentY(int currentY) {
		this.currentY = currentY;
	}

	public Rectangle getBounds() {
		return new Rectangle(this.currentX, this.currentY, this.width,
				this.height);
	}

	public void updatePos(int x, int y) {
		this.prevX = this.currentX;
		this.prevY = this.currentY;
		this.currentX = x;
		this.currentY = y;
	}

	public void paintComponent(Graphics g) {
		g.setColor(Color.CYAN);
		g.fillRect(this.currentX, (this.currentY - 15), 15, 15);
		g.setColor(Color.BLACK);
		g.drawRect(this.currentX, (this.currentY-15), 15, 15);
	}

}
