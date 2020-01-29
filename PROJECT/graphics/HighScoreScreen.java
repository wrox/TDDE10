package graphics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import logics.HighscoreEntry;

/**
 * Prints out highscores for the different levels. Also manages the order of
 * highscores and whether its a new highscore or not when a game ends.
 * 
 * @author erika712
 *
 */
public class HighScoreScreen extends JPanel implements Serializable {
	private final static String GFX_PATH = "graphics/";
	private final static String DATA_PATH = "data/";
	private final static String HS_EASY = "highScoreEasy.bin";
	private final static String HS_HARD = "highScoreHard.bin";
	private BufferedImage backgroundImg = ImageIO.read(new File(GFX_PATH + "HighScore.png"));
	private ArrayList<HighscoreEntry> highscoreEasy = new ArrayList<>();
	private ArrayList<HighscoreEntry> highscoreHard = new ArrayList<>();

	public HighScoreScreen(MainFrame frame) throws IOException {

		this.loadHighScore(DATA_PATH + HS_EASY);
		this.loadHighScore(DATA_PATH + HS_HARD);
		
		// Populate our high scores by default with atleast one entry each.
		if (this.highscoreHard.isEmpty()) {
			for (int i = 0; i < 10; i++) {
				this.highscoreHard.add(new HighscoreEntry("DEF", 0));
			}
			this.saveHighScore(DATA_PATH + HS_HARD);
		}

		if (this.highscoreEasy.isEmpty()) {
			for (int i = 0; i < 10; i++) {
				this.highscoreEasy.add(new HighscoreEntry("DEF", 0));
			}
			this.saveHighScore(DATA_PATH + HS_EASY);
		}
	}

	public void loadHighScore(String filename) {
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(
					filename));
			if (filename.equals(DATA_PATH + HS_EASY)) {
				this.setHighScore(ois.readObject(), highscoreEasy);
			} else if (filename.equals(DATA_PATH + HS_HARD)) {
				this.setHighScore(ois.readObject(), highscoreHard);
			}
			ois.close();
		} catch (FileNotFoundException exc) {
			new File(filename);
		} catch (IOException exc) {
			exc.printStackTrace();
		} catch (NullPointerException exc) {
			exc.printStackTrace();
		} catch (ClassNotFoundException exc) {
			exc.printStackTrace();
		}
	}

	public void saveHighScore(String filename) {
		try {
			ObjectOutputStream oos = new ObjectOutputStream(
					new FileOutputStream(filename));
			if (filename.equals(DATA_PATH + HS_EASY)) {
				oos.writeObject(this.highscoreEasy);
			} else if (filename.equals(DATA_PATH + HS_HARD)) {
				oos.writeObject(this.highscoreHard);
			}
			oos.close();
		} catch (FileNotFoundException exc) {
			new File(filename);
		} catch (IOException exc) {
			exc.printStackTrace();
		} catch (NullPointerException exc) {
			exc.printStackTrace();
		}
	}

	public void setHighScore(Object input, ArrayList<HighscoreEntry> highscore) {
		if (!highscore.isEmpty()) {
			highscore.clear();
		}

		highscore.addAll((ArrayList<HighscoreEntry>) input);
	}

	public boolean isNewHighScore(int input, boolean isEasy) {
		ArrayList<HighscoreEntry> highscore = new ArrayList<>();
		if (isEasy) {
			highscore = this.highscoreEasy;
		} else {
			highscore = this.highscoreHard;
		}
		if (highscore.size() < 10) {
			return true;
		} else if (highscore.size() > 0
				&& highscore.get(highscore.size() - 1).getScore() < input) {
			return true;
		}
		return false;
	}

	public void updateHighscore(HighscoreEntry input, boolean isEasy) {
		ArrayList<HighscoreEntry> highscores;
		ArrayList<HighscoreEntry> newHighscores = new ArrayList<>();
		boolean newScoreAdded = false;

		if (isEasy) {
			highscores = this.highscoreEasy;
		} else {
			highscores = this.highscoreHard;
		}

		int counter = 0;
		int arrayCounter = 0;
		while (counter < 10) {
			if (highscores.get(arrayCounter).getScore() > input.getScore()
					&& newScoreAdded == false) {
				newHighscores.add(highscores.get(arrayCounter));
			} else if (highscores.get(counter).getScore() <= input.getScore()
					&& newScoreAdded == false) {
				newHighscores.add(input);
				newHighscores.add(highscores.get(arrayCounter));
				newScoreAdded = true;
			} else {
				newHighscores.add(highscores.get(counter));
			}
			counter++;
			arrayCounter ++;
		}

		if (isEasy) {
			this.highscoreEasy = newHighscores;
			this.saveHighScore(DATA_PATH + HS_EASY);
		} else {
			this.highscoreHard = newHighscores;
			this.saveHighScore(DATA_PATH + HS_HARD);
		}
	}

	public void paintComponent(Graphics g) {
		int push = 0;
		g.drawImage(backgroundImg, 0, 0, null);
		g.setColor(Color.WHITE);
		g.drawString("Easy Difficulty", 200, 120);
		g.drawString("Name", 180, 140);
		g.drawString("Points", 260, 140);
		if (this.highscoreEasy != null) {
			for (HighscoreEntry entry : this.highscoreEasy) {
				g.drawString(entry.getInitials(), 180, 160 + push);
				g.drawString(String.valueOf(entry.getScore()), 260, 160 + push);
				push += 15;
			}
		}
		push = 0;
		g.drawString("Hard Difficulty", 430, 120);
		g.drawString("Name", 410, 140);
		g.drawString("Points", 490, 140);
		if (this.highscoreHard != null) {
			for (HighscoreEntry entry : this.highscoreHard) {
				g.drawString(entry.getInitials(), 410, 160 + push);
				g.drawString(String.valueOf(entry.getScore()), 490, 160 + push);
				push += 15;
			}
		}
	}
}
