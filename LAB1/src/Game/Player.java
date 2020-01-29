/*
 * Class: Player
 * 
 * Version: 1.0
 * 
 * 25/1 -17
 */

package Game;

import java.util.ArrayList;
import java.util.Iterator;

import Game.Location;

public class Player implements Commandable {

	private String name;
	private Location position;
	private String command = "";
	private int gold = 10;
	private int health = 10;
	private WearableItem clothing;
	private int attackDamage;
	private ArrayList<Item> items = new ArrayList<Item>();
	
	public void setName (String name) {
		this.name=name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setCommand(String command) {
		this.command = command;
	}

	public void setLocation (Location location) {
		this.position = location;
	}
	
	public Location getLocation() {
		return this.position;
	}
	
	public int getHealth() {
		return this.health;
	}
	
	public int getAttackDamage() {
		return this.attackDamage;
	}
	
	public void setGold (int gold) {
		this.gold = gold;
	}
	
	public boolean exitGame() {
		return this.command.equals("exit");

	}
	
	public void addItem(String command) {
		/* If the item is not null, add item to player inventory*/
		if (this.position.takeItem(command) != null) {
			this.items.add(this.position.takeItem(command));
		} else {
			System.out.println("That item is not here..");
		}
	}
	
	public void setItem(Item item) {
		this.items.add(item);
	}
	
	public ArrayList<Item> getItems() {
		return this.items;
	}
	
	public void currentItems() {
		/* Lists the current items of the player */
		if (!this.items.isEmpty()) {
			System.out.println("You have the following items:");
			for (Item item: this.items) {
				item.printYourself();
			} 
		}else {
			System.out.println("You do not have any items yet..");
		}
	}
	
	public boolean inInventory(Item requiredItem) {
		for (Item item : this.items) {
			if (item == requiredItem) {
				return true;
			}
		}
		return false;
	}
	
	public Item inInventory(String itemName) {
		for (Item item : this.items) {
			if (item.getName().equals(itemName)) {
				return item;
			}
		}
		return null;
	}
	
	public void removeFromInventory(Item item) {
		/* removes parameter item from inventory */
		for (Iterator<Item> iter = this.items.iterator(); iter.hasNext();) {
			Item itItem = iter.next();
			if (itItem.equals(item)) {
				iter.remove();
			}
		} 
	}
	
	public void setBonusHealth(int bonus) {
		this.health += bonus;
	}
	
	public void setAttackDamage(int bonus) {
		this.attackDamage += bonus;
	}
	
	
	public Item getClothing() {
		return this.clothing;
	}
	
	public void status() {
		System.out.println("Status");
		System.out.println("Health: " + this.health);
		System.out.println("Damage: " + this.attackDamage);
		System.out.println("Gold: " + this.gold);
	}
	
	public void moveTo(String move) {
		this.position = this.position.getLocation(move);
	}

	public void surroundings() {
		this.position.introduceYourself();
		this.position.possibleActions();
	}
	
	public boolean doCommand(Player player, String command) {
		/* method which tries the command for the object in every case */
		switch (command) {
		case ("status"):
			this.status();
			return true;
		case ("items"):
			this.currentItems();
			return true;
		case ("exit"):
			this.command = command;
			return true;
		default:
			if(command.contains("take")) {
				this.addItem(command);
				return true;
			}
			return false;
		}
	}
	
}

