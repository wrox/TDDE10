package timers;

import logics.ArenaGrid;

/**
 * Provides values for printing out a duration bar for Pwr-ups. Lasts seven seconds. 
 * @author erika712
 *
 */
public class DurationBar extends Thread {
	
	private final ArenaGrid arena;
	
	public DurationBar (ArenaGrid arena) {
		this.arena = arena;
	}
	
	@Override
	public void run() {
	for (int i = 7; i > 0; i--) {
		this.arena.setDurationBarProgress(i);
		try {
			DurationBar.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	}
}
