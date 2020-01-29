package test;

public class OffPistArea extends SnowyArea implements HasDifficulty<Integer> {
	
	private int difficulty = 0;

	public OffPistArea(int difficulty) {
		this.difficulty = difficulty;
	}

	@Override
	public Integer getDifficulty() {
		return this.difficulty;
	}

	@Override
	public void setDifficulty(Integer difficulty) {
		this.difficulty = difficulty;
	}

}
