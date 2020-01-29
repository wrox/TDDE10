package timers;

import java.awt.Toolkit;
import java.util.Timer;
import java.util.TimerTask;

import logics.ArenaGrid;

/**
 * This class is used to delay input from the user, preventing it to change direction more than once during one lap of the game-loop (100 ms)
 * @author erika712
 *
 */
public class DirectionRateTimer {

	Toolkit toolkit;
	Timer timer;

	public DirectionRateTimer (int ms, ArenaGrid arena) {
		toolkit = Toolkit.getDefaultToolkit();
		timer = new Timer();
		timer.schedule(new DirectionRateTask(arena), ms);
	}
	
	class DirectionRateTask extends TimerTask {
		
		ArenaGrid arena;
		
		public DirectionRateTask (ArenaGrid arena) {
			this.arena = arena;
		}

		@Override
		public void run() {
			this.arena.SnakeCanTurn(true);
		}
		
	}
	
	
}
