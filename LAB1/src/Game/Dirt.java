package Game;

public class Dirt extends Item {

	public Dirt(String name, String trigger, double weight) {
		super(name, trigger, weight);
	}
	
	@Override
	public boolean doCommand(Player player, String command) {
		return false;

	}

}
