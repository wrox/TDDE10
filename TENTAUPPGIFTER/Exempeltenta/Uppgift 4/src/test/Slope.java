package test;

import java.awt.Color;

public class Slope extends SnowyArea implements HasDifficulty<Color> {
	
	private Color difficulty;
	
	public Slope(Color color) {
		this.difficulty = color;
	}

	@Override
	public Color getDifficulty() {
		return this.difficulty;
	}

	@Override
	public void setDifficulty(Color difficulty) {
		this.difficulty = difficulty;
	}

}
