package Game;

public class Boss extends Monster {

	public Boss(String name, double weight) {
		super(name, weight);
	}

	@Override
	public void attack(Player player) {
		/* if player damage and health is high enough, kill dragon and finish game. */
		if ((player.getAttackDamage() >= 30) && (player.getHealth() >= 60)) {
			System.out.println("You charge at the dragon, aiming at its heart! The dragon responds with a steady stream of fire from its mouth.");
			System.out.println("You throw yourself to the side, letting the fire slip past you!");
			System.out.println("As the dragon takes a deep breath to let out another burst of fire, its chest gets exposed!");
			System.out.println("You take the opportunity and throws your spear towards the dragon.");
			System.out.println("It pierced its scaly, thick hide and let out a roar. Twisting and slamming the walls in the cave, the dragon finally stops and collapses.");
			System.out.println("...........................");
			System.out.println("You wake up full of sweat in your bed.");
			System.out.println("\"My god.. was it all a dream?\"");
			player.setCommand("exit"); // sets player command to exit which then triggers exit-check in run-loop at Game.java
			return;
	}
	System.out.println("You need something to defend yourself with if you want to attack the boar.");
}

	@Override
	public boolean doCommand(Player player, String command) {
		/* method which tries the command for the object in every case */
		if (command.contains("kill dragon")) {
			this.attack(player);
			return true;
		}
		return false;
	}
}
