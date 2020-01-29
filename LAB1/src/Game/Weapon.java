package Game;

public class Weapon extends WearableItem {

	private int damage;
	
	public Weapon(String name, String trigger, double weight, int damage) {
		super(name, trigger, weight);
		this.damage = damage;
	}

	@Override
	public void putOn(Player player, String command) {
		/* adds the benefits of the item to the player, removes it from inventory */
		if (player.inInventory(this)) {
			player.setAttackDamage(this.damage);
			player.removeFromInventory(this);
		}

	}

	@Override
	public boolean doCommand(Player player, String command) {
		/* adds the benefits of the item to the player, removes it from inventory */
		if (command.equals(this.getTrigger())) {
			this.putOn(player, command);
			return true;
		}
		return false;

	}

}
