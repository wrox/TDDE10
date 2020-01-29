package animals;

import java.util.ArrayList;

public class Animal {
	
	public String name;
	public int age;
	private String[] friends = new String[20];
	
	public Animal (String name, int age) {
		this.name=name;
		this.age=age;
	}
	
	public Animal (String name) {
		this.name=name;
	}
	
	public void introduceYourself() {
		System.out.println("Morr. Jag jag ar ett djur som heter " + this.name + ".");
		System.out.println("Jag ar " + this.age + " ar gammal.");
	}

	public void setFriend(String friend) {
		for (int i = 0; i < 20; i++) {
			System.out.println("Plats" + i + ".");
			if (friends[i] == null) {
				friends[i] = friend;
				System.out.println("Vi la in en van pa" + i + ".");
				break;
			}
		}
		
	}
	
}
