package Game;

public abstract class Monster extends NPC {

	public Monster(String name, double weight) {
		super(name, weight);
	}
	
	
	public abstract void attack(Player player);
	
	

	@Override
	public abstract boolean doCommand(Player player, String command);

}
