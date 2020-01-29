/*
 * Class: FishingRod
 * 
 * Version: 1.0
 * 
 * Date: 25/1 -17
 */

package Game;

public class FishingRod extends Tool {

	public FishingRod (String name, String trigger, double weight, Location use, boolean revealed) {
		super(name, trigger, weight, use, revealed);
	}
	
	
	@Override
	public boolean doCommand(Player player, String command) {
		return false;

	}

}
