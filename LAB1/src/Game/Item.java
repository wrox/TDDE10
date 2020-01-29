/*
 * Class: Item
 * 
 * Version: 1.0
 * 
 * 25/1 -17
 */

package Game;

public abstract class Item implements Commandable{

	private String name;
	private double weight;
	private boolean revealed = true;
	private String trigger;
	private boolean pickedUp = false;
	
	public Item(String name, String trigger, double weight) {
		this.name = name;
		this.trigger = trigger;
		this.weight = weight;
	}
	
	public Item (String name, String trigger, double weight, boolean revealed) {
		this.name = name;
		this.trigger = trigger;
		this.weight = weight;
		this.revealed = revealed;
	}
	
	public void setPickedUp(boolean bool) {
		this.pickedUp = bool;
	}
	
	public boolean getPickedUp() {
		return this.pickedUp;
	}
	
	public String getTrigger() {
		return this.trigger;
	}
	
	public void printYourself() {
		System.out.println(this.name + " (" + this.weight + " kg)");
	}
	
	public String getName() {
		return this.name;
	}
	
	
	public void setVisability(boolean status) {
		this.revealed = status;
	}
	
	public boolean getVisability() {
		return this.revealed;
	}
	
	public abstract boolean doCommand(Player player, String command);

}
