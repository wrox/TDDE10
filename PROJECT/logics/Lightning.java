package logics;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import timers.DurationBar;
import timers.LightningTimer;

/**
 * Makes the game update faster for 7 seconds. Serves as an edible. Edible is superclass.
 * @author erika712
 *
 */
public class Lightning extends Edible {

	private DurationBar durBar = new DurationBar(this.getArena());
	
	public Lightning(ArenaGrid arena) {
		super(arena);
		try {
			Image tmpImg;
			tmpImg = ImageIO.read(new File("graphics/Lightning.png"));
			this.setImage(tmpImg.getScaledInstance(15, 15, Image.SCALE_SMOOTH));
		} catch (IOException e) {
			System.out.println("Kunde inte ladda bilden");
			e.printStackTrace();
		}
	}

	public boolean collision() {
		if (this.getArena().getSnake().getBounds().intersects(this.getBounds())) {
			this.getArena().getSnake().setLastEdible(this);
			this.getArena().getSnake().setScoreMultiplier(1.5);
			this.getArena().getSnake().addBody();
			this.getArena().getSnake().setSpeed(40);
			this.getArena().DurationBarActive(true);
			this.durBar.start();
			new LightningTimer(7, this.getArena());
			return true;
		}
		return false;
	}

	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
	}
	
}
