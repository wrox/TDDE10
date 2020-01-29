package Game;

public class Robe extends WearableItem {

	private int bonusHealth;

	public Robe(String name, String trigger, double weight, int bonusHealth) {
		super(name, trigger, weight);
		this.bonusHealth = bonusHealth;
	}
	
	public int getBonusHealth() {
		return this.bonusHealth;
	}

	public void putOn(Player player, String command) {
		/* adds the benefits of the item to the player, removes it from inventory */
		if (player.inInventory(this)) {
			player.setBonusHealth(this.bonusHealth);
			player.removeFromInventory(this);
		}
		
	}
	
	public boolean doCommand(Player player, String command) {
		/* method which tries the command for the object in every case */
		if (command.contains(this.getTrigger())) {
			this.putOn(player, command);
			return true;
		}
		return false;
	}

}
