package Game;

public class Boar extends Monster {

	public Boar(String name, double weight) {
		super(name, weight);
		// TODO Auto-generated constructor stub
	}
	
	public void attack(Player player) {
		/* if player damage is high enough, kill boar */
		if (player.getAttackDamage() >= 30) {
			player.getLocation().getNPCs().clear();
			player.getLocation().getRoads().add(0, "north");
			System.out.println("The boar charges straight at you! Luckily you have your spear, you\nwould not have survived the attack without it. Now that the boar is\ngone you see another path in front of you headed north.");
			return;
			}
		System.out.println("You need something to defend yourself with if you want to attack the boar.");
}

	public boolean doCommand(Player player, String command) {
		/* method which tries the command for the object in every case */
	if (command.contains("kill boar")) {
		this.attack(player);
		return true;
	}
	return false;
	}
}
