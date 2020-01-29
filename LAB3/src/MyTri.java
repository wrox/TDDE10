import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;

public class MyTri extends Shape {

	public MyTri() {

	}

	public MyTri(int x, int y, int width, int height, Color color) {
		super(x, y, width, height, color);
	}

	@Override
	public void paintComponent(Graphics g) {
		// x1 x2 x3
		int[] xPoints = { this.getX() - (this.getHeight() / 2), this.getX() + (this.getHeight() / 2), this.getX() };
		int[] yPoints = { this.getY() + (this.getHeight() / 2), this.getY() + (this.getHeight() / 2), this.getY() - (this.getHeight() / 2) };
		// y1 y2 y3

		g.setColor(this.getColor());
		g.fillPolygon(xPoints, yPoints, 3);
	}

	@Override
	public Shape addDummyShape(Shape shape) {
		Shape tmpShape = new MyTri();
		return tmpShape;
	}

}
