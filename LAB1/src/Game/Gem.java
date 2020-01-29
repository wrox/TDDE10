/*
 * Class: Gem
 * 
 * Version: 1.0
 * 
 * Date: 25/1 -17
 */

package Game;

public class Gem extends Tool {

	public Gem(String name, String trigger, double weight, Location use) {
		super(name, trigger, weight, use);
	}
	
	public void use(Player player) {
		/* checks if the cave is lit up and sets new road to boss */
		if (this.useable(player) && ((Cave) player.getLocation()).getLit()) {
			player.getLocation().setRoad("west");
			System.out.println("The cave starts to roar and suddenly a tunnel to your left opens up and\na foul stench reaches your nose as the cave takes a deep breath from within.");
			player.getLocation().setDescriptionShort("You're back in the cave. On the pedestal, the gem shines bright in the light of your torch");
		} else {
			System.out.println("There is nowhere to place the gem..");
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
