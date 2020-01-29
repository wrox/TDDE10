package graphics;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 * Startscreen, renders a background for the startscreen.
 * 
 * @author erika712, armeh223
 *
 */
public class StartScreen extends JPanel implements Runnable, Serializable {

	private static BufferedImage backgroundImg;
	private BufferedImage[] startImages = new BufferedImage[2];
	private Thread thread;
	private boolean running = true;
	
	final static String GFX_PATH = "graphics/";

	public StartScreen() throws IOException {

		this.setLayout(new BorderLayout());

		try {
			for (int i = 0; i < this.startImages.length; i++) {
				StartScreen.backgroundImg = ImageIO.read(new File(GFX_PATH + (i+1) + ".png"));
				this.startImages[i] = StartScreen.backgroundImg;
			}

		} catch (IOException exc) {
			System.out.println("Failed to load background image. Full error: " + exc);
		}

		if (thread == null) {
			thread = new Thread(this);
			thread.start();
		}
	}
	
	public void running(boolean bool){
		this.running = bool;
	}
	
	public Thread getThread(){
		return this.thread;
	}

	@Override
	public void run() {
		while (this.running) {
			for (int i = 0; i < this.startImages.length; i++) {
				StartScreen.backgroundImg = startImages[i];
				try {
					Thread.sleep(750);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
//				System.out.println("New image loaded.");
				repaint();
			}
		}
	}

	@Override
	public void paintComponent(Graphics g) {
		g.drawImage(backgroundImg, 0, 0, null);
	}

}
