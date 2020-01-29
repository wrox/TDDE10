import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;

public class MyRect extends Shape {
	
	public MyRect() {
		
	}

	public MyRect(int x, int y, int width, int height, Color color) {
		super(x, y, width, height, color);
	}

	@Override
	public void paintComponent(Graphics g) {
		// if (isFilled) {
		g.setColor(this.getColor());
		g.fillRect(this.getX() - (this.getWidth() / 2),
				this.getY() - (this.getHeight() / 2), this.getWidth(),
				this.getHeight());
		// } else {
		g.drawRect(this.getX() - (this.getWidth() / 2),
				this.getY() - (this.getHeight() / 2), this.getWidth(),
				this.getHeight());
		// }
	}

	@Override
	public Shape addDummyShape(Shape shape) {
		Shape tmpShape = new MyRect();
		return tmpShape;
		
	}
}
