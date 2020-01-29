package logics;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
/**
 * Draws out current score in-game, along with last edible.
 * @author erika712
 *
 */
public class AttributeTracker {

	private int currentScore;
	private final int x = 600;
	private final int y = 0;
	private final int width = 115;
	private final int height = 600;
	private int pointsXPos = 650;
	private final static String GFX_PATH = "graphics/";
	private BufferedImage backgroundImg;

	private final Snake snake;
	private CurrentEdible currEdible = new CurrentEdible(this);

	public AttributeTracker(Snake snake) {
		try {
			backgroundImg = ImageIO.read(new File(GFX_PATH + "GridMenu.png"));
		} catch (IOException exc) {
			exc.printStackTrace();
		}
		this.snake = snake;
	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}

	public Snake getSnake() {
		return this.snake;
	}

	public void updateCurrentScore() {
		this.currentScore = this.snake.getCurrentScore();
	}

	public void paintComponent(Graphics g) {
//		g.setColor(Color.WHITE);
//		g.fillRect(this.x, this.y, this.width, this.height);
		g.drawImage(backgroundImg, 600, 0, null);

//		g.setColor(Color.RED);
//		g.fillRect(620, 200, 80, 30);

		g.setColor(Color.WHITE);
		g.setFont(new Font("Ubuntu", Font.PLAIN, 24));
		
		if (this.currentScore == 0) {
			pointsXPos = 650;
		} else if (this.currentScore < 1000) {
			pointsXPos = 635;
		} else if (this.currentScore < 10000) {
			pointsXPos = 630;
		} else {
			pointsXPos = 620;
		}
		g.drawString(String.valueOf(this.currentScore), pointsXPos, 575);
		this.currEdible.paintComponent(g);
	}

	private class CurrentEdible {
		private final AttributeTracker tracker;
		private BufferedImage currentImg;
		private BufferedImage[] edibleImages = new BufferedImage[5];
		private final int x = 630;
		private final int y = 460;

		public CurrentEdible(AttributeTracker tracker) {
			this.tracker = tracker;

			try {
				this.edibleImages[0] = ImageIO.read(new File(
						"graphics/Food.png"));
				this.edibleImages[1] = ImageIO.read(new File(
						"graphics/Turtle.png"));
				this.edibleImages[2] = ImageIO.read(new File(
						"graphics/Lightning.png"));
				this.edibleImages[3] = ImageIO
						.read(new File("graphics/NK.png"));
				this.edibleImages[4] = ImageIO.read(new File(
						"graphics/Cash.png"));

			} catch (IOException e) {
				e.printStackTrace();
			}

		}
		public void paintComponent(Graphics g) {
			g.setFont(new Font("Ubuntu", Font.PLAIN, 12));
			g.setColor(Color.WHITE);
//			g.fillRect(this.x, this.y, this.width, this.height);

			if (this.tracker.getSnake().getLastEdible() != null) {
				if (this.tracker.getSnake().getLastEdible() instanceof Turtle) {
					this.currentImg = this.edibleImages[1];
				} else if (this.tracker.getSnake().getLastEdible() instanceof Lightning) {
					this.currentImg = this.edibleImages[2];
					g.drawImage(this.edibleImages[2], this.x - 5, this.y, null);
				} else if (this.tracker.getSnake().getLastEdible() instanceof NegateCollision) {
					this.currentImg = this.edibleImages[3];
					g.drawImage(this.edibleImages[3], this.x - 5, this.y, null);
				} else if (this.tracker.getSnake().getLastEdible() instanceof Cash) {
					this.currentImg = this.edibleImages[4];
					g.drawImage(this.edibleImages[4], this.x - 5, this.y, null);
				}
			}
			g.drawImage(this.currentImg, this.x - 5, this.y, null);
			g.drawString("Last Pwr-Up", this.x - 7, this.y + 75);
			

		}

	}

}
