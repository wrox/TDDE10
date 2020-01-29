package Game;

public abstract class Person extends NPC {

	public Person(String name, double weight) {
		super(name, weight);
	}

	public abstract void interactWith(Player player, String command);
	
	public abstract boolean doCommand(Player player, String command);

}
