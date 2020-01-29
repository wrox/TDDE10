package logics;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

/**
 * Regular food for the snake. Also serves as a superclass for Pwr-Ups.
 * @author erika712
 *
 */
public class Edible {

	private int x = 3;
	private int y = 3;
	private int width = 15;
	private int height = 15;
	private String name = "Food";
	private Image img;

	private final ArenaGrid arena;

	public Edible(ArenaGrid arena) {

		this.arena = arena;

		try {
			this.img = ImageIO.read(new File("graphics/Food.png"));
			this.img = this.img.getScaledInstance(15, 15, Image.SCALE_SMOOTH);
		} catch (IOException e) {
			System.out.println("Kunde inte ladda bilden");
			e.printStackTrace();
		}
		
		Random randInt = new Random();

		while (!(this.x % 15 == 0)) {
			this.x = randInt.nextInt(600);
		}

		while (!(this.y % 15 == 0)) {
			this.y = randInt.nextInt(600);
		}
	}

	public void setImage(Image img){
		this.img = img;
	}
	
	public Image getImage(){
		return this.img;
	}
	
	public String getName() {
		return this.name;
	}

	public int getX() {
		return x;
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

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public ArenaGrid getArena() {
		return this.arena;
	}

	public Rectangle getBounds() {
		return new Rectangle(this.x, this.y, this.width, this.height);
	}

	public boolean collision() {
		if (this.arena.getSnake().getBounds().intersects(this.getBounds())) {
			this.arena.getSnake().setLastEdible(this);
			this.arena.getSnake().addBody();
			return true;
		}
		return false;
	}

	public void paintComponent(Graphics g) {
//		g.setColor(Color.BLUE);
//		g.fillRect(this.getX(), this.getY() - 15, this.getWidth(),
//				this.getHeight());
		g.drawImage(this.img, this.x, this.y-15, null);
	}

}
