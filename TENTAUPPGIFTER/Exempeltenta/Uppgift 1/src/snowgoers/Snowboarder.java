package snowgoers;

public class Snowboarder extends SnowGoer {

	public Snowboarder(String name, int age) {
		super(name, age);
	}
	
	public void printYourself() {
		super.printYourself();
		System.out.println("Snowboarder");
	}
	
	@Override
	public void slowDown() {
		System.out.println("Swoops in and sprays lots of snow");
	}

}
