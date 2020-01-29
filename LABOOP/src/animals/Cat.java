package animals;

public class Cat extends Animal {
	
	public Cat (String name, int age) {
		super(name, age);
	}
	
	public Cat (String name) {
		super(name);
	}
	
	public void introduceYourself() {
		System.out.println("Mjau! Jag jag ar en katt som heter " + this.name + ".");
		System.out.println("Jag ar " + this.age + " ar gammal.");
	}
}
