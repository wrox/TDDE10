package snowgoers;

public class Skier extends SnowGoer {
	private int poles;
	
	public Skier(String name, int age, int poles) {
		super(name, age);
		this.poles = poles;
	}
	
	public void printYourself() {
		super.printYourself();
		System.out.println("Skier with " + this.poles + " poles");
	}

	@Override
	public void slowDown() {
		System.out.println("Poitns ski tips towards each other");
	}
}
