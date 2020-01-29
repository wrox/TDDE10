package logics;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import javax.imageio.ImageIO;

/**
 * Enemy to the snake.
 * @author erika712
 *
 */
public class Blob {

	private final int width = 15;
	private final int height = 15;
	private int currentX = 3;
	private int currentY = 3;
	private int prevX;
	private int prevY;
	private int currentDirection = 4;
	private int move = 1;
	private ArrayList<Integer> allDirections = new ArrayList<>();
	private Image img;

	private final ArenaGrid arena;

	public Blob(ArenaGrid arena) {

		this.arena = arena;

		Random randInt = new Random();

		try {
			this.img = ImageIO.read(new File("graphics/Blob.png"));
			this.img = this.img.getScaledInstance(15, 15, Image.SCALE_SMOOTH);
		} catch (IOException e) {
			System.out.println("Kunde inte ladda bilden");
			e.printStackTrace();
		}
		
		// System.out.println(this.x);
		// System.out.println(this.y);

		while (!(this.currentX % 15 == 0)) {
			// System.out.println(this.x);
			this.currentX = randInt.nextInt(600);
		}

		while (!(this.currentY % 15 == 0)) {
			// System.out.println(this.y);
			this.currentY = randInt.nextInt(600);
		}

	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
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

	public int getPrevX() {
		return prevX;
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

	public int getCurrentDirection() {
		return currentDirection;
	}

	public void setCurrentDirection(int currentDirection) {
		this.currentDirection = currentDirection;
	}

	public void setRandomDirection() {
		this.currentDirection = ThreadLocalRandom.current().nextInt(1, 5);
	}

	public void moveBlob() {
		boolean noCollision = false;
		while (!noCollision) {
			this.setRandomDirection();
			this.allDirections.add(this.currentDirection);

			// System.out.println("Blob direction: " + this.currentDirection);

			switch (currentDirection) {
			case 1:
				if (!checkCollision(this.currentX, this.currentY - 15)) {
					this.prevX = this.currentX;
					this.prevY = this.currentY;
					this.currentY += -15;
					noCollision = true;
				}
				break;
			case 2:
				if (!checkCollision(this.currentX + 15, this.currentY)) {
					this.prevX = this.currentX;
					this.prevY = this.currentY;
					this.currentX += 15;
					noCollision = true;
				}
				break;
			case 3:
				if (!checkCollision(this.currentX, this.currentY + 15)) {
					this.prevX = this.currentX;
					this.prevY = this.currentY;
					this.currentY += 15;
					noCollision = true;
				}
				break;
			case 4:
				if (!checkCollision(this.currentX - 15, this.currentY)) {
					this.prevX = this.currentX;
					this.prevY = this.currentY;
					this.currentX += -15;
					noCollision = true;
				}
				break;
			}
		}
	}

	public Rectangle getBounds() {
		return new Rectangle(this.currentX, this.currentY, this.width,
				this.height);
	}

	public Rectangle getBounds(int newX, int newY) {
		return new Rectangle(newX, newY, this.width, this.height);
	}

	public void collision() {
		if (this.getBounds().intersects(arena.getSnake().getBounds())) {
			arena.getSnake().setAlive(false);
		}
	}

	public boolean checkCollision(int newX, int newY) {
		if (newX >= 600 || newX < 0 || newY > 600 || newY <= 0) {
			return true;
		}

		for (SnakeBody body : arena.getSnake().getTail()) {
			if (this.getBounds(newX, newY).intersects(body.getBounds())) {
				return true;
			}
		}
		for (Edible edible : arena.getEdibles()) {
			if (this.getBounds(newX, newY).intersects(edible.getBounds())) {
				return true;
			}
		}

		for (Blob blob : arena.getBlobs()) {
			if (this.getBounds(newX, newY).intersects(blob.getBounds())) {
				return true;
			}
		}
		
		for (Obstacle obs : arena.getObstacles()) {
			if (this.getBounds(newX, newY).intersects(obs.getBounds())) {
				return true;
			}
		}

		return false;
	}

	public void updateBlob() {
		switch (this.move) {
		case 1:
			this.move = 2;
			break;
		case 2:
			this.move = 3;
			break;
		case 3:
			this.moveBlob();
			this.move = 1;
			break;
		}
		this.collision();
	}

	public void paintComponent(Graphics g) {
//		g.setColor(Color.RED);
//		g.fillRect(this.currentX, this.currentY - 15, this.width, this.height);
		g.drawImage(this.img, this.currentX, this.currentY-15, null);
	}

	public ArrayList<Integer> getAL() {
		return this.allDirections;
	}

}
