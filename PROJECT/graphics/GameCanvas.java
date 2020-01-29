package graphics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import logics.ArenaGrid;
import logics.Blob;
import logics.Edible;
import logics.HighscoreEntry;
import logics.Obstacle;

/**
 * The drawing area of the game.
 * 
 * @author erika712
 *
 */
public class GameCanvas extends JPanel {

	private final ArenaGrid arena;
	private static final int UP = 1;
	private static final int RIGHT = 2;
	private static final int DOWN = 3;
	private static final int LEFT = 4;
	private final MainFrame frame;

	public GameCanvas(boolean easyMode, MainFrame frame) {
		this.arena = new ArenaGrid(easyMode, this);
		this.frame = frame;

		this.addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent e) {
				if (arena.SnakeCanTurn() && e.getKeyCode() == KeyEvent.VK_UP
						|| e.getKeyCode() == KeyEvent.VK_W) {
					if (arena.getSnake().getCurrentDirection() != DOWN) {
						arena.getSnake().setCurrentDirection(UP);
						// arena.SnakeCanTurn(false);
						// new DirectionRateTimer(80, arena);
					}
				} else if (arena.SnakeCanTurn()
						&& e.getKeyCode() == KeyEvent.VK_RIGHT
						|| e.getKeyCode() == KeyEvent.VK_D) {
					if (arena.getSnake().getCurrentDirection() != LEFT) {
						arena.getSnake().setCurrentDirection(RIGHT);
						// new DirectionRateTimer(80, arena);
					}
				} else if (arena.SnakeCanTurn()
						&& e.getKeyCode() == KeyEvent.VK_DOWN
						|| e.getKeyCode() == KeyEvent.VK_S) {
					if (arena.getSnake().getCurrentDirection() != UP) {
						arena.getSnake().setCurrentDirection(DOWN);
						// new DirectionRateTimer(80, arena);
					}
				} else if (arena.SnakeCanTurn()
						&& e.getKeyCode() == KeyEvent.VK_LEFT
						|| e.getKeyCode() == KeyEvent.VK_A) {
					if (arena.getSnake().getCurrentDirection() != RIGHT) {
						arena.getSnake().setCurrentDirection(LEFT);
						// new DirectionRateTimer(80, arena);
					}
				} else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
					arena.getSnake().addBody();
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
			}

			@Override
			public void keyTyped(KeyEvent e) {
			}
		});
	}

	public void updateHighscores(int newScore) {
		boolean isEasy;
		boolean isToBeSaved = true;
		if (arena.isModeEasy()) {
			isEasy = true;
		} else {
			isEasy = false;
		}
		int optionChoice = 0;
		if (this.frame.getHighScoreScreen().isNewHighScore(newScore, isEasy)) {
			HighscoreEntry tmpEntry = new HighscoreEntry();
			// Set the initials to an empty string to prevent issues with NullPointerExceptions in the checks we want to do.
			tmpEntry.setInitials("");
			while (tmpEntry.getInitials().isEmpty()) {
				try {
					tmpEntry.setInitials(JOptionPane.showInputDialog(null, "Please enter your initials (3 letters):", "New High Score!", JOptionPane.QUESTION_MESSAGE));
					if (tmpEntry.getInitials().length() > 3 || tmpEntry.getInitials().matches(".*\\d+.*")) { // Check for numbers using regular expression /d and asterix. We escape the \d using doubleslash
						// Do another loop!
						tmpEntry.setInitials("");
					} else {
						tmpEntry.setInitials(tmpEntry.getInitials().toUpperCase());
					}
				} catch (NullPointerException exc) {
					// No input entered, user pressed Cancel. Proceed.
					isToBeSaved = false;
					break;
				}
			}
			// By default, we save the user's data if they pass isNewHighScore and enter an acceptable name.
			if (isToBeSaved) {
				tmpEntry.setScore(newScore);
				this.frame.getHighScoreScreen().updateHighscore(tmpEntry, isEasy);
				optionChoice = getDialogValue("Good Job!", "High Score saved. Play again?");
			// User chose not to save their high score by pressing Cancel.
			} else {
				optionChoice = getDialogValue("Good Riddance!", "High Score was not saved. Play again?");
			}
		// User was not good enough for high score.
		} else {
			optionChoice = getDialogValue("Not This Time!", "Sorry! No record this time. Play again?");
		}
		switch (optionChoice) {
		case 0:
			frame.startScreenViewFromArena();
			break;
		case 1:
			frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
		}
	}
	
	public int getDialogValue(String title, String body) {
		String[] options = new String[2];
		options[0] = "Main Menu";
		options[1] = "Exit";
		return JOptionPane.showOptionDialog(null, body, title, 0, JOptionPane.QUESTION_MESSAGE, null, options, 0);
	}

	public void paintComponent(Graphics g) {
		int x = 0;
		int y = 0;
		g.setColor(new Color(7, 4, 9));
		g.fillRect(0, 0, 600, 600);

		g.setColor(new Color(0, 2, 226));
		for (int n = 15; n <= 600; n += 15) {
			x = n;
			g.drawLine(x, y, x, 600);
		}
		x = 0;
		for (int n = 15; n <= 600; n += 15) {
			y = n;
			g.drawLine(x, y, 600, y);
		}
		x = 0;
		y = 0;
		// drawSnake
		this.arena.getSnake().paintComponent(g);

		// Draw edibles
		for (Edible edible : this.arena.getEdibles()) {
			edible.paintComponent(g);
		}

		// Draw blobs
		for (Blob blob : this.arena.getBlobs()) {
			blob.paintComponent(g);
		}

		// Draw Obstacles
		for (Obstacle obs : this.arena.getObstacles()) {
			obs.paintComponent(g);
		}

		// Draw AttributeTracker
		this.arena.getTracker().paintComponent(g);

		// Draw DurationBar
		if (this.arena.DurationBarActive()) {
			int offset = 0;
			for (int i = 0; i < this.arena.getDurationBarProgress(); i++) {
				g.setColor(Color.GREEN);
				g.fillRect(625 + offset, 435, 9, 20);
//				g.setColor(Color.BLACK);
//				g.drawRect(620 + offset, 420, 10, 30);
				offset += 9;
				
			}
		}

	}

}
