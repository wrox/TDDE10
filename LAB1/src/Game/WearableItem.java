/*
 * Class: WearableItem
 * 
 * Version: 1.0
 * 
 * 25/1 -17
 */

package Game;

public abstract class WearableItem extends Item {
	
	public WearableItem(String name, String trigger, double weight) {
		super(name, trigger, weight);
	}

	public abstract void putOn(Player player, String command);

	public abstract boolean doCommand(Player player, String command);
	
}
