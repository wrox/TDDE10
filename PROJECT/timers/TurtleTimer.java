package timers;

import java.awt.Toolkit;
import java.util.Timer;
import java.util.TimerTask;

import logics.ArenaGrid;

/**
 *  A timer with a timertask private subclass determining the actions of what happens after a Turtle Pwr-Up has run out.
 * @author erika712
 *
 */
public class TurtleTimer {

	Toolkit toolkit;
	Timer timer;

	public TurtleTimer (int seconds, ArenaGrid arena) {
		toolkit = Toolkit.getDefaultToolkit();
		timer = new Timer();
		timer.schedule(new TurtleTask(arena), seconds * 1000);
	}
	
	class TurtleTask extends TimerTask {
		
		ArenaGrid arena;
		
		public TurtleTask (ArenaGrid arena) {
			this.arena = arena;
		}

		@Override
		public void run() {
			this.arena.getSnake().setSpeed(100);
			this.arena.DurationBarActive(false);
		}
		
	}
	
	
}
