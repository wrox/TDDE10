package snowgoers;

public abstract class SnowGoer {
	
	private String name;
	private int age;
	
	public SnowGoer() {
		
	}

	public SnowGoer(String name, int age) {
		this.setName(name);
		this.setAge(age);
	}
	
	public SnowGoer(String name, int age, int poles) {
		this.setName(name);
		this.setAge(age);
	}
	
	public void printYourself() {
		System.out.println(name + ", " + age + " years old");
	}
	
	public abstract void slowDown();

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
