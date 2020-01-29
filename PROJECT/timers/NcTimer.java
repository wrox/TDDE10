package timers;

import java.awt.Toolkit;
import java.util.Timer;
import java.util.TimerTask;

import logics.ArenaGrid;

/**
 *  A timer with a timertask private subclass determining the actions of what happens after a NegateCollision Pwr-Up has run out.
 * @author erika712
 *
 */
public class NcTimer {

	Toolkit toolkit;
	Timer timer;

	public NcTimer (int seconds, ArenaGrid arena) {
		toolkit = Toolkit.getDefaultToolkit();
		timer = new Timer();
		timer.schedule(new NcTimerTask(arena), seconds * 1000);
	}
	
	class NcTimerTask extends TimerTask {
		
		ArenaGrid arena;
		
		public NcTimerTask (ArenaGrid arena) {
			this.arena = arena;
		}

		@Override
		public void run() {
			this.arena.getSnake().setNegateCollision(false);
			this.arena.DurationBarActive(false);
		}
		
	}
	
	
}
