/*
 * Class: Tool
 * 
 * Version: 1.0
 * 
 * 25/1 -17
 */

package Game;

public abstract class Tool extends Item {

	private Location useable;
	//private boolean
	
	public Tool (String name, String trigger, double weight, Location use, boolean revealed) {
		super(name, trigger, weight, revealed);
		this.useable = use;
	}
	
	public Tool (String name, String trigger, double weight, Location use) {
		super(name, trigger, weight);
		this.useable = use;
	}
	
	public boolean useable(Player player) {
		/* returns true/false if player is on the correct position for the item */
		return this.useable.equals(player.getLocation());
	}
	
	public abstract boolean doCommand(Player player, String command);
}
