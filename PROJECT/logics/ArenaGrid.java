package logics;

import graphics.GameCanvas;

import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import javax.swing.JPanel;

/**
 * GameArea, draws the game and runs the game loop.
 * 
 * @author erika712
 *
 */
public class ArenaGrid extends JPanel implements Runnable {

	private Thread thread;

	private final GameCanvas canvas;

	private boolean modeEasy = true;
	private int noBlobs = 2;
	
	private boolean durBarActive = false;
	private int durBarProgress = 0;
	
	private boolean canTurn = true;

	private final Snake snake = new Snake(this);
	private ArrayList<Edible> edibles = new ArrayList<>();
	private ArrayList<Blob> blobs = new ArrayList<>();
	private ArrayList<Obstacle> obstacles = new ArrayList<>();
	private AttributeTracker tracker = new AttributeTracker(this.snake);

	public ArenaGrid(boolean modeEasy, GameCanvas gameCanvas) {
		this.setFocusable(true);
		this.canvas = gameCanvas;
		this.setModeEasy(modeEasy);
		/**
		 * Amount of enemy blobs to spawn
		 */
		if (!modeEasy) {
			this.noBlobs = 5;
			this.obstacles.add(new Obstacle(60, 60, this.snake));
			this.obstacles.add(new Obstacle(60, 540, this.snake));
			this.obstacles.add(new Obstacle(540, 60, this.snake));
			this.obstacles.add(new Obstacle(540, 540, this.snake));
			this.obstacles.add(new Obstacle(300, 300, this.snake));
		}

		for (int i = 0; i < 4; i++) {
			this.edibles.add(new Edible(this));
		}

		this.edibles.add(this.randomEdible());

		// this.blobs.add(new Blob());
		for (int i = 0; i < this.noBlobs; i++) {
			this.blobs.add(new Blob(this));
		}

		if (thread == null) {
			thread = new Thread(this);
			thread.start();
		}
	}

	public void run() {
		while (this.snake.alive()) {
			try {
				Thread.sleep(this.snake.getSpeed());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			// System.out.println(this.currentDirection);

			this.snake.updateSnake();

			for (Obstacle obs : this.obstacles) {
				obs.collision();
			}

			for (Blob blob : this.blobs) {
				blob.updateBlob();
				// new BlobTimer(500, blob);
			}

			for (Iterator<Edible> iter = this.edibles.iterator(); iter
					.hasNext();) {
				Edible itEdible = iter.next();
				if (itEdible.collision()) {
					// this.snake.addBody();
					iter.remove();
				}
			}

			while (!this.isEdibleSpawned()) {
				// Wait until edibles are updated.
			}

			if (this.snake.getCurrentX() >= 600 || this.snake.getCurrentX() < 0
					|| this.snake.getCurrentY() > 600
					|| this.snake.getCurrentY() <= 0) {
				this.snake.setAlive(false);
				System.out.println("DEAD!");
			}

			this.tracker.updateCurrentScore();
			this.canvas.repaint();
			Toolkit.getDefaultToolkit().sync();
			// System.out.println("Current score: " +
			// this.snake.getCurrentScore());
		}
		
		this.canvas.updateHighscores(this.snake.getCurrentScore());
	}

	public boolean isEdibleSpawned() {
		Edible tmpEdible;
		while (this.edibles.size() < 5) {
			int numberOfNonEdibles = 0;
			for (Edible edible : this.edibles) {
				// Is the edible a turtle/cash/negatecollision/lightning pwr-up?
				if (edible instanceof Turtle || edible instanceof Cash || edible instanceof NegateCollision || edible instanceof Lightning) {
					numberOfNonEdibles += 1;
				}
			}
			if (numberOfNonEdibles == 1) {
				tmpEdible = new Edible(this);
			} else {
				tmpEdible = this.randomEdible();
			}
			// Is the edible overlapping another edible?
			for (Edible edible : this.edibles) {
				if (!((edible.getX() - tmpEdible.getX() < -15 || edible.getX()
						- tmpEdible.getX() > 15) && (edible.getY()
						- tmpEdible.getY() < -15 || edible.getY()
						- tmpEdible.getY() > 15))) {
					return false; // Abort mission
				}
			}
			// Is the edible overlapping the snake's head?
			if (!((this.snake.getCurrentX() - tmpEdible.getX() < -15 || this.snake
					.getCurrentX() - tmpEdible.getX() > 15) && (this.snake
					.getCurrentY() - tmpEdible.getY() < -15 || this.snake
					.getCurrentY() - tmpEdible.getY() > 15))) {
				return false; // Abort mission
			}
			// Is the edible overlapping the snake's tail?
			for (SnakeBody body : this.snake.getTail()) {
				if (!((body.getCurrentX() - tmpEdible.getX() < -15 || body
						.getCurrentX() - tmpEdible.getX() > 15) && (body
						.getCurrentY() - tmpEdible.getY() < -15 || body
						.getCurrentY() - tmpEdible.getY() > 15))) {
					return false; // Abort mission
				}
			}
			// Is the edible overlapping an obstacle?
			for (Obstacle obs : this.obstacles) {
				if (!((obs.getX() - tmpEdible.getX() < -15 || obs.getX()
						- tmpEdible.getX() > 15) && (obs.getY()
						- tmpEdible.getY() < -15 || obs.getY()
						- tmpEdible.getY() > 15))) {
					return false; // Abort mission
				}
			}

			this.edibles.add(tmpEdible);
		}
		return true;
	}

	public Edible randomEdible() {
		Random randomInt = new Random();
		int tmpInt;

		tmpInt = randomInt.nextInt(4);
		switch (tmpInt) {

		case 1:
			return new Cash(this);
		case 2:
			return new Lightning(this);
		case 3:
			return new Turtle(this);
		default:
			return new NegateCollision(this);
		}
	}

	public Snake getSnake() {
		return this.snake;
	}

	public ArrayList<Edible> getEdibles() {
		return this.edibles;
	}

	public ArrayList<Blob> getBlobs() {
		return this.blobs;
	}

	public ArrayList<Obstacle> getObstacles() {
		return this.obstacles;
	}

	public AttributeTracker getTracker() {
		return this.tracker;
	}
	
	public GameCanvas getCanvas(){
		return this.canvas;
	}
	
	public void DurationBarActive(boolean bool) {
		this.durBarActive = bool;
	}
	
	public boolean DurationBarActive() {
		return this.durBarActive;
	}
	
	public void setDurationBarProgress(int i) {
		this.durBarProgress = i;
	}
	
	public int getDurationBarProgress(){
		return this.durBarProgress;
	}
	
	public void SnakeCanTurn(boolean bool) {
		this.canTurn = bool;
	}
	
	public boolean SnakeCanTurn(){
		return this.canTurn;
	}

	public boolean isModeEasy() {
		return modeEasy;
	}

	public void setModeEasy(boolean modeEasy) {
		this.modeEasy = modeEasy;
	}
	
}
