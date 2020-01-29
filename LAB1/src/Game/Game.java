/*
 * Class: Game
 * 
 * Version: 1.0
 * 
 * 25/1 -17
 * 
 */


package Game;

import java.util.ArrayList;
import java.util.Scanner;

import Game.Player;
import Game.Location;
import Game.OutdoorsArea;
import Game.Room;
import Game.Item;

//

public class Game {
	
	/*
	 * Variable, array declaration
	 */
	private Player player;
	private ArrayList<String> commands = new ArrayList<String>();
	private ArrayList<Location> gameLocations = new ArrayList<Location>();
	private ArrayList<Item> gameItems = new ArrayList<Item>();
	private ArrayList<NPC> gameNPCs = new ArrayList<NPC>();
	private ArrayList<Commandable> allCommandableObjects = new ArrayList<Commandable>();

	public Game() {
		Location plain = new OutdoorsArea("Plain", "You are standing in the middle of a plain. It seems to go on for miles and miles. \nYou cannot remember how you got here and you have nothing but the clothes on you. \nWay out in the distance to the north you see some mountains. Over to the east you see some trees.\nThere is a torch lying on the ground.", "You are out on the plain again..");
		Location desert= new OutdoorsArea("Desert", "You arrived at the edge of a desert. The small grains of sand creeps in\nbetween your toes. You seem to reminisce the time you went to the beach with your family.\nFeels like ages has past since you last saw your family. Where could they be..?\nThere is a shovel lying in the sand.\nThe mountains are closer now.", "You're back out in the open desert..");
		Location forest = new OutdoorsArea("Forest", "You wander into what seems to be an old forest of oak trees. Something\nunnerves you as you tip toe forward, trying not to stir whatever is\nresting here. There is an old elven_robe lying on the ground.\nSuddenly you are in a small clearing and there is a big\nboar in front of you! The boar is blocking the path.", "You're back out in the old forest..");
		Location mountains = new OutdoorsArea("Mountains", "You are at the base of the mountains you first saw back on the plain, where this strange\ntrip had its beginning. A thick fog makes everything damp.\nYou look up and spot something that looks like a hole in the mountain. Maybe you should go up?\nThere is a spear lying on the ground.", "You're back by the base of the mountains..");
		Location lake = new OutdoorsArea("Lake", "You entered a small glade and a lake is resting just at your feet. That distant\nmemory of the family trip on the beach appears a bit clearer now..\nThere seems to be some loose dirt just next to you. Like someone recently dug there..", "You're back by the lake..");
		Location hut = new Room("Hut", "You arrive at a small hut at the edge of the forest. Inside the\nhut is a small old man sitting on the floor. He appears to be begging\nas he has a bowl in front of him, with a few coins therein.", "You're back by the hut with the old man begging..", 8);
		Location cave = new Cave("Cave", "You entered a cave, but it's to dark to see anything.", "You entered a cave, but it's to dark to see anything.", 60);
		Location boss = new Room("Boss room", "You see a huge dragon, which is menacingly glaring at you. While you shiver, the dragon starts to walk towards you...", "You see a huge dragon, which is menacingly glaring at you. While you shiver, the dragon starts to walk towards you...", 150);
		Item torch = new Torch("torch", "light", 1.2 ,cave);
		Item elven_robe = new Robe("elven_robe", "wear elven_robe" , 3.3, 50);
		Item shovel = new Shovel("shovel", "dig", 4.5, lake);
		Item fishing_rod = new FishingRod("fishing_rod", "", 2.1, hut, false);
		Item dirt = new Dirt("spot of loose dirt", "", 0);
		Item gem = new Gem("enchanted_gem", "place enchanted_gem", 10, cave);
		Item spear = new Weapon("spear", "wear spear", 4.8, 30);
		NPC boar = new Boar("Boar", 45.3);
		NPC beggar = new Beggar("Beggar", 65.4);
		NPC dragon = new Boss("Dragon", 354.3);
		
		
		
		this.player = new Player(); // Init. player
		player.setLocation(plain); // Set default player location
		
		/*
		 * START: Declaration of location content
		 */
		// Zone: Plain
		plain.setRoad("north");
		plain.setRoad("east");
		plain.setNearLocations(0, desert);
		plain.setNearLocations(1, forest);
		plain.setNearLocations(2, null);
		plain.setNearLocations(3, null);
		plain.setItem(torch);
		// Zone: Desert
		desert.setRoad("north");
		desert.setRoad("south");
		desert.setRoad("west");
		desert.setNearLocations(0, mountains);
		desert.setNearLocations(1, null);
		desert.setNearLocations(2, plain);
		desert.setNearLocations(3, lake);
		desert.setItem(shovel);
		// Zone: Forest
		forest.setRoad("west");
		forest.setNearLocations(0, hut);
		forest.setNearLocations(1, null);
		forest.setNearLocations(2, null);
		forest.setNearLocations(3, plain);
		forest.setItem(elven_robe);
		forest.addNPC(boar);
		// Zone: Mountains
		mountains.setRoad("climb");
		mountains.setRoad("south");
		mountains.setNearLocations(0, cave);
		mountains.setNearLocations(1, null);
		mountains.setNearLocations(2, desert);
		mountains.setNearLocations(3, null);
		mountains.setItem(spear);
		// Zone: Lake
		lake.setRoad("east");
		lake.setNearLocations(0, null);
		lake.setNearLocations(1, desert);
		lake.setNearLocations(2, null);
		lake.setNearLocations(3, null);
		lake.setItem(fishing_rod);
		lake.setItem(dirt);
		// Zone: Hut
		hut.setRoad("south");
		hut.setNearLocations(0, null);
		hut.setNearLocations(1, null);
		hut.setNearLocations(2, forest);
		hut.setNearLocations(3, null);
		hut.addNPC(beggar);
		// Zone: Cave
		cave.setRoad("south");
		cave.setNearLocations(0, null);
		cave.setNearLocations(1, null);
		cave.setNearLocations(2, mountains);
		cave.setNearLocations(3, boss);
		// Zone: Boss
		boss.setRoad("east");
		boss.setNearLocations(0, null);
		boss.setNearLocations(1, cave);
		boss.setNearLocations(2, null);
		boss.setNearLocations(3, null);
		boss.addNPC(dragon);
		/*
		 * END: Declaration of location content
		 */
		
		/* Provide NPC items */
		beggar.addItemNPC(gem);
		
		/*
		 * START: Create collection of locations, items and NPC:s
		 */
		this.gameLocations.add(plain);
		this.gameLocations.add(desert);
		this.gameLocations.add(forest);
		this.gameLocations.add(mountains);
		this.gameLocations.add(lake); 
		this.gameLocations.add(hut);
		this.gameLocations.add(cave);
		this.gameLocations.add(boss);
		
		this.gameItems.add(elven_robe);
		this.gameItems.add(shovel);
		this.gameItems.add(fishing_rod);
		this.gameItems.add(torch);
		this.gameItems.add(dirt);
		this.gameItems.add(gem);
		this.gameItems.add(spear);
		
		this.gameNPCs.add(boar);
		this.gameNPCs.add(beggar);
		this.gameNPCs.add(dragon);
		/*
		 * END: Create collection of locations, items and NPC:s
		 */
		
		/* Provide commandable objects */
		this.allCommandableObjects.add(player);
		this.allCommandableObjects.addAll(gameLocations);
		this.allCommandableObjects.addAll(gameItems);
		this.allCommandableObjects.addAll(gameNPCs);
		
		/* Provide help command content */
		commands.add("north/east/south/west/climb - commands that will move you that direction is viable.");
		commands.add("items - check your current items.");
		commands.add("take ITEM - picks up an item near your position and puts them amongst your other items.");
		commands.add("wear ITEM - put on wearable item to improve your survivability.");
		commands.add("place ITEM - place an item at a specified place.");
		commands.add("give ITEM/gold - gives ITEM or gold to a nearby NPC.");
		commands.add("dig - dig around your wherabouts for stuff. This does require a shovel, duh.");
		commands.add("status - displays your current status.");
		commands.add("kill NPC - attacks the npc in question.");
		commands.add("exit - exits the game");
	}
	
	/* help() provides help command */
	public void help() {
		for (String command : this.commands) {
			System.out.println(command);
		}
		System.out.println();
	}
	
	/**
	 * Tries the command, given by the player, for each available object.
	 * @param command
	 */
	//Kommentar
	//Ni går igenom alla CommandableObjects i HELA spelet vid varje inmatat kommando. 
	//Det innebär att ni itererar igenom många "onödiga" objekt som egentligen inte är relevanta. 
	//Till exempel är spelaren i Cave ska bara items som finns där itereras över.
	public  void nextAction(String command) {
		for (Commandable com : this.allCommandableObjects) {
			if (com.doCommand(player, command)) {
				break;
			}
		}
		if (command.equals("help")) {
			this.help();
		}
	}
	
	
	public void run() {
		String command;
		Location lastPosition = null;
		
		Scanner scan = new Scanner(System.in);
		System.out.println("What is your name? ");
		player.setName(scan.nextLine());
		
		System.out.println("Hello " + player.getName() + ", welcome to this magical world of wonder!");
		System.out.println("You can move around typing north/south/west/east.");
		System.out.println("You will have to learn more commands as you play the game!");
		System.out.println("Hint! There is a command \"help\".\n");
		
		/* Provides loop until player enter "exit" */
		while (!player.exitGame()) {
			if (!(lastPosition == player.getLocation())) {
				player.surroundings();
				lastPosition = player.getLocation();
			}
			System.out.println("What do you want to do? ");
			command = scan.nextLine();
			this.nextAction(command);
		}
		scan.close();
	}
	
	public static void main(String[] args) {
		Game Game = new Game();

		Game.run();
	}



}
