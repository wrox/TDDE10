package logics;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
/**
 * Serves as a regular Edible, but with a bonus to current score. Edible is superclass.
 * @author erika712
 *
 */
public class Cash extends Edible {

	
	public Cash(ArenaGrid arena) {
		super(arena);
		try {
			Image tmpImg;
			tmpImg = ImageIO.read(new File("graphics/Cash.png"));
			this.setImage(tmpImg.getScaledInstance(15, 15, Image.SCALE_SMOOTH));
		} catch (IOException e) {
			System.out.println("Kunde inte ladda bilden");
			e.printStackTrace();
		}
	}

	public boolean collision() {
		if (this.getArena().getSnake().getBounds().intersects(this.getBounds())) {
			this.getArena().getSnake().setLastEdible(this);
			this.getArena().getSnake().addToScore(400);
			this.getArena().getSnake().addBody();
			return true;
		}
		return false;
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
	}
	
}
