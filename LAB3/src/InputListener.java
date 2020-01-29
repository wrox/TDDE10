import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class InputListener implements MouseListener {
	private DrawingModel model = new DrawingModel();
	private boolean isDrawAreaActive;
	private boolean isDebug = false;
	private int drawAreaSpeed = 10;
	
	public InputListener(final DrawingModel model) {
		this.model = model;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
	}	
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
	}
	@Override
	public void mousePressed(MouseEvent e) {
		if (!this.isDrawAreaActive()) {
			this.setDrawAreaActive(true);
		}
		model.addShape(e.getX(), e.getY(), 50, 50);
		if (this.isDebug) {
			System.out.println(e.getX() + ", " + e.getY());
			System.out.println("----------------------------------");
			model.print();
			System.out.println("----------------------------------");
		}
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		this.setDrawAreaActive(false);
	}
	/*
	 * Getters & setters
	 */
	public int getDrawAreaSpeed() {
		return drawAreaSpeed;
	}
	public void setDrawAreaSpeed(int drawAreaSpeed) {
		this.drawAreaSpeed = drawAreaSpeed;
	}
	public boolean isDrawAreaActive() {
		return isDrawAreaActive;
	}
	public void setDrawAreaActive(boolean isDrawAreaActive) {
		this.isDrawAreaActive = isDrawAreaActive;
	}
/*
	@Override
	public void keyPressed(KeyEvent arg0) {
		if (arg0.getKeyCode() == KeyEvent.VK_UP) {
			System.out.println("Pressed up.");
		} else if (arg0.getKeyCode() == KeyEvent.VK_DOWN) {
			System.out.println("Pressed down.");
		}
		// TODO Auto-generated method stub
	}
	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
	}
	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
	}
*/
}
