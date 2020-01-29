package def;

public class ChocolateChip extends Cookie {

	public ChocolateChip (int size) {
		super(size, 5, true, "Chocolate Chip");
	}
	
	public Cookie bakeNew() {
		return new ChocolateChip(1);
	}
	
}
