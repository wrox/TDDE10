package logics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.util.ArrayList;

/**
 * This is the head of the snake. Keeps track of direction, position and its
 * tail.
 * 
 * @author erika712
 *
 */
public class Snake {

	private int bodyCount = 0;
	private ArrayList<SnakeBody> tail = new ArrayList<>();
	private int currentX;
	private int currentY;
	private int prevX;
	private int prevY;
	private final int width = 15;
	private final int height = 15;
	private boolean alive = true;
	private int currentDirection = 4;
	private int speed = 100;
	private boolean negateCollision = false;
	private Edible lastEdible;

	private int currentScore = 0;
	private double scoreMultiplier = 1.0;

	final ArenaGrid arena;

	public Snake(ArenaGrid grid) {

		this.arena = grid;

		this.currentX = 285;
		this.currentY = 345;
	}

	public void addBody() {
		if (this.tail.isEmpty()) {
			this.tail.add(new SnakeBody(this.currentX, this.currentY));
			this.bodyCount += 1;
			this.currentScore += 100 * scoreMultiplier;
		} else {
			int x = this.tail.get(this.tail.size() - 1).getCurrentX();
			int y = this.tail.get(this.tail.size() - 1).getCurrentY();

			this.tail.add(new SnakeBody(x, y));
			this.bodyCount += 1;
			this.currentScore += 100 * scoreMultiplier;
		}
	}

	public void setCurrentDirection(int i) {
		this.currentDirection = i;
	}

	public int getCurrentDirection() {
		return this.currentDirection;
	}

	public int getCurrentX() {
		return this.currentX;
	}

	public void setCurrentX(int x) {
		this.currentX += x;
	}

	public int getCurrentY() {
		return this.currentY;
	}

	public void setCurrentY(int y) {
		this.currentY += y;
	}

	public void setPrevX(int x) {
		this.prevX = x;
	}

	public void setPrevY(int y) {
		this.prevY = y;
	}

	public int getPrevX() {
		return this.prevX;
	}

	public int getPrevY() {
		return this.prevY;
	}

	public boolean alive() {
		return this.alive;
	}

	public void setAlive(boolean bool) {
		this.alive = bool;
	}

	public int getBodyCount() {
		return this.bodyCount;
	}

	public ArrayList<SnakeBody> getTail() {
		return this.tail;
	}

	public void addToScore(int i) {
		this.currentScore += i;
	}

	public int getCurrentScore() {
		return this.currentScore;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public void setScoreMultiplier(double d) {
		this.scoreMultiplier = d;
	}

	public void setNegateCollision(boolean bool) {
		this.negateCollision = bool;
	}

	public boolean getNegateCollision() {
		return this.negateCollision;
	}
	
	public void setLastEdible(Edible edible) {
		this.lastEdible = edible;
	}
	
	public Edible getLastEdible() {
		return this.lastEdible;
	}

	public Rectangle getBounds() {
		return new Rectangle(this.currentX, this.currentY, this.width,
				this.height);
	}

	public void updateTail() {
		if (!this.tail.isEmpty()) {
			this.tail.get(0).updatePos(this.prevX, this.prevY);
			for (int i = 1; i < this.tail.size(); i++) {
				this.tail.get(i).updatePos(this.tail.get(i - 1).getPrevX(),
						this.tail.get(i - 1).getPrevY());
			}
		}
	}

	public void moveSnake() {
		switch (this.currentDirection) {

		case 1:
			this.prevX = this.currentX;
			this.prevY = this.currentY;
			this.currentY += -15;
			break;

		case 2:
			this.prevX = this.currentX;
			this.prevY = this.currentY;
			this.currentX += 15;
			break;

		case 3:
			this.prevX = this.currentX;
			this.prevY = this.currentY;
			this.currentY += 15;
			break;

		case 4:
			this.prevX = this.currentX;
			this.prevY = this.currentY;
			this.currentX += -15;
			break;
		}
	}

	public void collision() {
		if (!this.negateCollision) {
			for (SnakeBody body : this.tail) {
				if (this.getBounds().intersects(body.getBounds())) {
					this.alive = false;
				}
			}
		}

	}

	public void updateSnake() {
		this.moveSnake();
		this.updateTail();
		this.collision();
	}
	
	public void paintComponent(Graphics g) {
		int[] triXUp = { this.currentX,
				this.currentX + 15, this.currentX + 7 };
		int[] triYUp = { this.currentY, this.currentY,
				this.currentY - 15 };

		int[] triXR = { this.currentX,
				this.currentX + 15, this.currentX };
		int[] triYR = { this.currentY, this.currentY - 7,
				this.currentY - 15 };

		int[] triXD = { this.currentX,
				this.currentX + 15, this.currentX + 7 };
		int[] triYD = { this.currentY - 15,
				this.currentY - 15, this.currentY };

		int[] triXW = { this.currentX + 15,
				this.currentX + 15, this.currentX };
		int[] triYW = { this.currentY,
				this.currentY - 15, this.currentY - 7 };

		Polygon triUp = new Polygon(triXUp, triYUp, 3);
		Polygon triRight = new Polygon(triXR, triYR, 3);
		Polygon triDown = new Polygon(triXD, triYD, 3);
		Polygon triLeft = new Polygon(triXW, triYW, 3);
		
		g.setColor(Color.CYAN);
		switch (this.currentDirection) {
		case 1:
			g.fillPolygon(triUp);
			g.setColor(Color.BLACK);
			g.drawPolygon(triUp);
			break;
		case 2:
			g.fillPolygon(triRight);
			g.setColor(Color.BLACK);
			g.drawPolygon(triRight);
			break;
		case 3:
			g.fillPolygon(triDown);
			g.setColor(Color.BLACK);
			g.drawPolygon(triDown);
			break;
		case 4:
			g.fillPolygon(triLeft);
			g.setColor(Color.BLACK);
			g.drawPolygon(triLeft);
			break;
		}
		
		for (SnakeBody body : this.tail) {
			body.paintComponent(g);
		}
	}

}
