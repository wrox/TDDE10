package Game;

import java.util.Iterator;

public class Beggar extends Person {

	public Beggar(String name, double weight) {
		super(name, weight);
	}

	@Override
	public void interactWith(Player player, String command) {
		/* If gold is given, print clue. if fishing_rod is given, player recieves gem */
		boolean isGiven = false;
		if (command.equals("give fishing_rod")) {
			for (Iterator<Item> iter = player.getItems().iterator(); iter.hasNext();) {
				Item itItem = iter.next();
				if (itItem.getName().equals("fishing_rod")) {
					iter.remove();
					isGiven = true;
				}
			}
			if (isGiven) {
				System.out.println("The man's bushy eyebrows are raised and you can see the wisdom in his\naged eyes. He tells you \""+player.getName()+", seek the altar on the mountain\nsummit, and place this gem thereupon. You will then find your true purpose!\".");
				player.setItem(this.getNPCItems().get(0)); // adds gem to player inventory, gem is in npc:s itemlist (index 0)
				System.out.println("You got enchanted_gem from beggar");
			}
		} else if (command.equals("give gold")) {
			player.setGold(0);
			System.out.println("The beggar mutters..");
			System.out.println("\"Give a man a fish and you feed him for a day.\nTeach a man to fish and you feed him for a lifetime\"");
			player.getLocation().setDescriptionShort("You're back by the hut with the old man muttering about fish and stuff..");
		}
	}

	@Override
	public boolean doCommand(Player player, String command) {
		/* method which tries the command for the object in every case */
		if (command.contains("give") && (player.getLocation().getName().equals("Hut"))) {
			this.interactWith(player, command);
			return true;
		} 
		return false;
	}

}
