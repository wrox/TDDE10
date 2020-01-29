package animals;

public class Dog extends Animal {
	
	public Dog (String name, int age) {
		super(name, age);
	}
	
	public Dog (String name) {
		super(name);
	}
	
	public void introduceYourself() {
		System.out.println("Vovv! Jag jag ar en hund som heter " + this.name + ".");
		System.out.println("Jag ar " + this.age + "ar gammal.");
		System.out.println("Vovv!");
	}
}
