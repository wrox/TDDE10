package timers;

import java.awt.Toolkit;
import java.util.Timer;
import java.util.TimerTask;

import logics.ArenaGrid;

/**
 * A timer with a timertask private subclass determining the actions of what happens after a lightning Pwr-Up has run out.
 * @author erika712
 *
 */
public class LightningTimer {

	Toolkit toolkit;
	Timer timer;

	public LightningTimer (int seconds, ArenaGrid arena) {
		toolkit = Toolkit.getDefaultToolkit();
		timer = new Timer();
		timer.schedule(new LightningTask(arena), seconds * 1000);
	}
	
	class LightningTask extends TimerTask {
		
		ArenaGrid arena;
		
		public LightningTask (ArenaGrid arena) {
			this.arena = arena;
		}

		@Override
		public void run() {
			this.arena.getSnake().setSpeed(100);
			this.arena.getSnake().setScoreMultiplier(1.0);
			this.arena.DurationBarActive(false);
		}
		
	}
	
	
}
