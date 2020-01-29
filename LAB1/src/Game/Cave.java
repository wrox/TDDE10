package Game;

public class Cave extends Room {
	
	
	private boolean lit=false;
	
	public Cave(String name, String description, String descriptionShort, int size) {
		super(name, description, descriptionShort, size);
	}
	
	public void setLit(boolean bool) {
		this.lit = bool;
	}
	
	public boolean getLit() {
		return this.lit;
	}

}
