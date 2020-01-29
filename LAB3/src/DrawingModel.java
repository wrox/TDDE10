import java.awt.Color;
import java.io.Serializable;
import java.util.ArrayList;

public class DrawingModel implements Serializable {
	private ArrayList<Shape> shapes = new ArrayList<>();
	private Shape newShape = new MyCircle();
	private Color currColor = Color.BLACK;
	private Color bgColor = Color.WHITE;
	
	private boolean isDebug = false;
	
	public DrawingModel() {

	}

	public ArrayList<Shape> getShapes() {
		return this.shapes;
	}
	
	public void print() {
		for (Shape shape: this.shapes) {
			shape.print();
		}
	}

	public void setNewShape (Shape shape) {
		this.newShape = shape;
	}
	
	
	public void setCurrentColor(Color color) {
		this.currColor = color;
	}
	
	
	public Color getCurrentColor(){
		return this.currColor;
	}
	
	public void addShape(int x, int y, int width, int height) {
		this.shapes.add(this.createShape(x, y, width, height));
	}
	
	public Shape createShape(int x, int y, int width, int height) {
		Shape tmpShape;
		
		this.newShape.setX(x);
		this.newShape.setY(y);
		this.newShape.setWidth(width);
		this.newShape.setHeight(height);
		this.newShape.setColor(this.currColor);
		
		if (this.isDebug) {
			System.out.println("Model color: " + this.currColor);
			System.out.println("Current color: " + this.newShape.getColor());
		}
		
		tmpShape = newShape;
		/* Shape creation, create separate object from our current */
		this.newShape = this.newShape.addDummyShape(this.newShape);
		return tmpShape;
	}

	public Color getBgColor() {
		return bgColor;
	}

	public void setBgColor(Color bgColor) {
		this.bgColor = bgColor;
	}
}
