package Game;

public class Torch extends Tool {

	
	public Torch(String name, String trigger, double weight, Location use) {
		super(name, trigger, weight, use);
	}

	
	public void use(Player player) {
		/* if location is correct, light up cave. */
		if (this.useable(player)) {
			player.getLocation().setDescription("Your torch shines red light on\nthe stone walls. You immediately notice the large pedestal in the middle of the cave.\nThere seems to be something missing on its platform..");
			player.getLocation().setDescriptionShort("You're in the cave again with the pedestal, missing a piece of itself..");
			player.getLocation().setViewed(false);
			player.getLocation().introduceYourself();
			((Cave)player.getLocation()).setLit(true);
		} else {
			System.out.println("You don't need a torch here..");
		}
	}
	
	@Override
	public boolean doCommand(Player player, String command) {
		/* method which tries the command for the object in every case */
		if (command.equals(this.getTrigger()) && (player.inInventory(this))) {
			this.use(player);
			return true;
		}
		return false;
	}
}
