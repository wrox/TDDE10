package def;

public class FrostedCookie extends Cookie {
	
	public FrostedCookie (int size) {
		super(size, 1, false, "Frosted Cookie");
	}
	
	public Cookie bakeNew() {
		return new FrostedCookie(1);
	}
}
