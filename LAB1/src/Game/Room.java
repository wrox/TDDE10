/*
 * Class: Room
 * 
 * Version: 1.0
 * 
 * 25/1 -17
 */

package Game;

public class Room extends Location {

	private int size;
	
	public Room (String name, String description, String descriptionShort, int size) {
		super(name, description, descriptionShort);
		this.size = size;
	}
	
	public void setRoad() {
		this.setRoad("west");
		System.out.println("The cave starts to roar and the ground beneath you is shaking furiously. A tunnel opened to the left of you!");		
	}
	
	public void possibleActions() {
		for (String road : this.getRoads()) {
			System.out.println("There is a door leading " + road +'.');
		}
	}
	
	public void introduceYourself() {
		super.introduceYourself();
		/*if (this.size < 10) {
			System.out.println("The place is quite small..");
		} else if (this.size > 10 && this.size < 100) {
			System.out.println("The place is pretty big!");
		} else {
			System.out.println("The place is huge!!");
		}
			System.out.println("You estimate it to be around " + this.size + " square meters big.");*/
	}
}
