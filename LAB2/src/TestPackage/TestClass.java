package TestPackage;

public class TestClass {

	private int i;
	private char c = 'x';
	private String[] s = { "This", "is", "an", "array" };

	public TestClass(int i) {
		this.i = i;
	}

	public void printMe() {
		System.out.println("integer: " + this.i);
		System.out.println("character: " + this.c);
		for (String s : this.s) {
			System.out.print(s);
		}
		System.out.println("");
	}
}
