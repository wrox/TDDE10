/*
 * Class: Shovel
 * 
 * Version: 1.0
 * 
 * Date: 25/1 -17
 */


package Game;

public class Shovel extends Tool {

	public Shovel(String name, String trigger, double weight, Location use) {
		super(name, trigger, weight, use);
	}
	
	
	public void use(Player player) {
		/* if player location is correct, reveals item fishing_rod*/
		if (this.useable(player)) {
			player.getLocation().getItems().get(0).setVisability(true);
			System.out.println("You found a fishing_rod in the ground where you dug!");
			player.getLocation().getItems().remove(1);
		} else {
			System.out.println("You dug hole but you found nothing there..");
		}
	}
	
	public boolean doCommand(Player player, String command) {
		/* method which tries the command for the object in every case */
		if (command.equals(this.getTrigger()) && (player.inInventory(this))) {
			this.use(player);
			return true;
		}
		return false;
	}
}
