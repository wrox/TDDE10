package def;

public abstract class Cookie {
	
	private int cookiesBaked;
	private int size;
	private boolean gluten;
	private String name;
	
	public Cookie () {
	}
	
	public Cookie (int size) {
		this.size = size;
	}
	
	public Cookie (int size, int cookiesBaked, boolean gluten, String name) {
		this.size = size;
		this.cookiesBaked = cookiesBaked;
		this.gluten = gluten;
		this.name = name;
	}
	
	public abstract Cookie bakeNew();	
	
	public void describeYourself() {
		System.out.println("Kaka ------------");
		System.out.println("Storlek: " + size);
		System.out.println("Namn: " + name);
		System.out.println("Gluten: " + gluten);

	}

	public static int getCookiesBaked() {
		return 0;
	}

}
