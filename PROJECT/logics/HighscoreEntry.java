package logics;

import java.io.Serializable;

/**
 * Class for holding together name and score for the highscore list.
 * @author erika712
 *
 */
public class HighscoreEntry implements Serializable {

	private String init;
	private int score;
	
	public HighscoreEntry() {}
	
	public HighscoreEntry(String init, int score) {
		this.init = init;
		this.score = score;
	}

	public String getInitials() {
		return init;
	}

	public void setInitials(String initials) {
		this.init = initials;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
}
