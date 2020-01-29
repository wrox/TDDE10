package Game;

import java.util.ArrayList;

public abstract class NPC implements Commandable {
	
	private String name;
	private double weight;
	private int price;
	private ArrayList<Item> npcItems = new ArrayList<Item>();
	
	public NPC(String name, double weight) {
		this.name = name;
		this.weight = weight;
	}
	
	public void addItemNPC(Item item) {
		this.npcItems.add(item);
	}
	
	public ArrayList<Item> getNPCItems() {
		return this.npcItems;
	}
		
	public String getName() {
		return this.name;
	}
		
		//public void printYourself()
		
	public abstract boolean doCommand(Player player, String command);

}
