import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;

import javax.swing.JPanel;

public class DrawingArea extends JPanel {

	private Graphics g;
	private DrawingModel model = new DrawingModel();
	private InputListener input = new InputListener(this.model);
	
	private boolean isDebug = true;

	public DrawingArea() {
		this.setLayout(new BorderLayout());
		this.setBackground(Color.WHITE);
		// this.setBorder(BorderFactory.createLineBorder(Color.RED));
		this.addMouseListener(input);
	}

	public void paintComponent() {
		this.paintComponent(g);
	}

	public void paintComponent(Graphics g) {
		//super.paintComponent(g);
		if (this.input.isDrawAreaActive()) {
			for (Shape shape : this.model.getShapes()) {
				shape.paintComponent(g);
			}
			if (this.isDebug) {
				System.out.println(this.model.getShapes().size());
			}
			if (this.model.getShapes().size() == 0) {
				this.input.setDrawAreaActive(false);
			}
		}
		Toolkit.getDefaultToolkit().sync();
		this.repaint();
	}

	public void setModel(DrawingModel readModel) {
		this.model.getShapes().clear();
		this.model.getShapes().addAll(readModel.getShapes());
		this.input.setDrawAreaActive(true);
	}

	public DrawingModel getModel() {
		return this.model;
	}

	public void setModel(Object readObject) {
		this.setModel((DrawingModel) readObject);
	}
}
