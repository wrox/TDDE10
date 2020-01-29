package test;

import java.awt.Color;

public class AnchorLift implements HasDifficulty<Color> {
	
	private Color difficulty;

	public AnchorLift() {
		this.difficulty = Color.RED;
	}

	public AnchorLift(Color color) {
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
