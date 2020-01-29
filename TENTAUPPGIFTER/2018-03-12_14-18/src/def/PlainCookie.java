package def;

public class PlainCookie extends Cookie {
	
	public PlainCookie () {
		super(1, 1, false, "Plain Cookie");
	}

	public Cookie bakeNew() {
		return new PlainCookie();
	}
	
	/*
	public PlainCookie (int size, int cookiesBaked, boolean gluten, String name) {
		super(size, cookiesBaked, false, name);
	}
	*/
}
