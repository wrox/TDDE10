/*
 * Class: Location
 * 
 * Version: 1.0
 * 
 * 25/1 -17
 */

package Game;

import java.util.ArrayList;

public abstract class Location implements Commandable {
	
	private String name;
	private String description;
	private String descriptionShort;
	private boolean Viewed = false;
	private ArrayList<String> roads = new ArrayList<String>();
	private ArrayList<Location> locationsNear = new ArrayList<Location>();
	private ArrayList<Item> itemsHere = new ArrayList<Item>();
	private ArrayList<NPC> npcHere = new ArrayList<NPC>();
	
	public Location (String name, String description, String descriptionShort) {
		this.name = name;
		this.description = description;
		this.descriptionShort = descriptionShort;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setDescription(String desc) {
		this.description = desc;
	}
	
	public void setDescriptionShort(String desc) {
		this.descriptionShort = desc;
	}
	
	public void setViewed (boolean bool) {
		this.Viewed = bool;
	}
	
	public void setRoad(String road) {
		this.roads.add(road);
	}
	
	public ArrayList<String> getRoads() {
		return this.roads;
		
	}
	
	public void setNearLocations(int i, Location location) {
		this.locationsNear.add(i, location);
	}
	
	public void setItem(Item item) {
		this.itemsHere.add(item);
	}
	
	public ArrayList<Item> getItems() {
		return this.itemsHere;
	}
	
	public Item takeItem(String command) {
		for (Item item: this.itemsHere) { //A for loop which checks if the items requested is actually at the location in question.
			if (command.contains(item.getName()) && item.getVisability()) {
				item.setPickedUp(true);
				return item;
			}
		}
		return null;
	}
	
	public void addNPC(NPC npc) {
		this.npcHere.add(npc);
	}
	
	public ArrayList<NPC> getNPCs(){
		return this.npcHere;
	}
	
	public void possibleActions() {
		for (String road : this.roads) { // lists the roads for the location
			switch (road) {
			case "climb":
				System.out.println("There is a narrow passage leading upwards.");
				break;
			default:
				System.out.println("There is a road leading " + road +'.');
			}
		}
	}
	
	public Location getLocation(String path) {
		/* if statement returning a location depending on player input (string) */
		if (path.equals("north") || path.equals("climb")) {
			return this.locationsNear.get(0);
		} else if (path.equals("east")) {
			return this.locationsNear.get(1);
		} else if (path.equals("south")) {
			return this.locationsNear.get(2);
		} else
			return this.locationsNear.get(3);
	}
	
	public boolean checkMove(String input) {
		/* return boolean if input is valid for movement */
		for (String road: this.roads) {
			if (road.equals(input)) {
				return true;
			}
			
		}
		return false;
	}
	
	public void look() {
		/* prints nearby items, npcs and roads */
		System.out.println(this.descriptionShort);
		for (Item item : this.itemsHere) {
			if (item.getVisability() && !item.getPickedUp())
			System.out.println("Around you, you see a " + item.getName()+".");
		}
		for (NPC npc : this.npcHere) {
			System.out.println("You see a "+ npc.getName() +'.');
		}
		this.possibleActions();
	}
	
	public boolean viewed() {
		return this.Viewed == true;
	}
	
	public void introduceYourself() {
		if (Viewed) {
			System.out.println(this.descriptionShort);
		} else {
			System.out.println(this.description);
			this.Viewed = true;
		}
	}
	
	public boolean doCommand(Player player, String command) {
		/* method which tries the command for the object in every case */
		if (this.checkMove(command) && (this.equals(player.getLocation()))) {
			player.setLocation(this.getLocation(command));
			return true;
		} else {
			switch (command) {
			case "look":
				if (this.equals(player.getLocation())) {
					this.look();
					return true;
				}
			}
		}
		return false;
	}
}
