package logics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * Basic obstacle, prints out in a static way on the arenagrid.
 * @author erika712
 *
 */
public class Obstacle {

	private int x;
	private int y;
	private final int width = 30;
	private final int height = 30;
	
	private final Snake snake;
	private Image img;
	
	public Obstacle(int x, int y, Snake snake) {
		this.x = x;
		this.y = y;
		this.snake = snake;
		try {
			Image tmpImg;
			tmpImg = ImageIO.read(new File("graphics/Dynamite.png"));
			this.setImage(tmpImg.getScaledInstance(30, 30, Image.SCALE_FAST));
		} catch (IOException e) {
			System.out.println("Kunde inte ladda bilden");
			e.printStackTrace();
		}
	}
	
	public void setImage(Image img){
		this.img = img;
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

	public void collision() {
		if (this.getBounds().intersects(snake.getBounds())) {
			snake.setAlive(false);
		}
	}
	
	public Rectangle getBounds() {
		return new Rectangle(this.x, this.y, this.width, this.height);
	}
		
	public void paintComponent(Graphics g) {
//		g.setColor(Color.YELLOW);
		g.drawImage(this.img, this.x, this.y-15, null);
//		g.fillRect(this.x, this.y-15, this.width, this.height);
	}
	
	
}
