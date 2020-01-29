package graphics;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.swing.JFrame;


/**
 * MainFrame extends frame. Main window of the game.
 * 
 * @author erika712, armeh223
 *
 */
public class MainFrame extends JFrame {

	private StartScreen startScreen;
	private StartScreenButtons startButtons;
	private LevelChooserButtons lvlButtons;
	private HighScoreButtons highScoreButtons;
	private HighScoreScreen highScoreScreen;
	private GameCanvas game;

	public MainFrame() throws IOException {
		super("Achtung die Schlange!");
		this.setLayout(new BorderLayout());
		this.setPreferredSize(new Dimension(720, 628));
		this.setSize(this.getPreferredSize());
		this.setResizable(false);

		startScreen = new StartScreen();
		startButtons = new StartScreenButtons(this);
		lvlButtons = new LevelChooserButtons(this);
		highScoreScreen = new HighScoreScreen(this);
		highScoreButtons = new HighScoreButtons(this);

		// Add StartScreen, JPanel.
		this.add(startScreen, BorderLayout.CENTER);
		this.add(startButtons, BorderLayout.SOUTH);

		this.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("X-value: " + (e.getX() - 4) + "\nY-Value: "
						+ (e.getY() - 28));
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
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// this.setUndecorated(true);
		this.setLocation(600, 200);
		this.setVisible(true);
	}

	public StartScreen getStartScreen() {
		return this.startScreen;
	}
	
	public HighScoreScreen getHighScoreScreen(){
		return this.highScoreScreen;
	}
	
	public int getWidth() {
		return 720;
	}
	public int getHeight() {
		return 628;
	}

	public void startScreenViewFromHighscores() {
		this.remove(highScoreScreen);
		this.remove(highScoreButtons);
		repaint();
		this.add(startScreen, BorderLayout.CENTER);
		this.add(startButtons, BorderLayout.SOUTH);
		invalidate();
		validate();
		repaint();
	}
	
	public void startScreenViewFromArena() {
		this.remove(game);
		repaint();
		this.add(startScreen, BorderLayout.CENTER);
		this.add(startButtons, BorderLayout.SOUTH);
		invalidate();
		validate();
		repaint();
	}
	
	public void startScreenViewFromLevelChooser() {
		this.remove(lvlButtons);
		repaint();
		this.add(startButtons, BorderLayout.SOUTH);
		invalidate();
		validate();
		repaint();
	}
	

	public void levelChooser() {
		this.remove(startButtons);
		repaint();
		this.add(lvlButtons, BorderLayout.SOUTH);
		invalidate();
		validate();
		repaint();
	}

	public void highScoresView() {
		this.remove(startScreen);
		this.remove(startButtons);
		repaint();
		this.add(highScoreScreen, BorderLayout.CENTER);
		this.add(highScoreButtons, BorderLayout.SOUTH);
		invalidate();
		validate();
		repaint();
	}

	public void setArena(boolean modeEasy) {
		this.remove(this.startScreen);
		this.remove(this.lvlButtons);
		repaint();
		this.game = new GameCanvas(modeEasy, this);
		this.add(game, BorderLayout.CENTER);
		game.requestFocusInWindow();
//		System.out.println("Added arena");
		invalidate();
		validate();
	}

	public static void main(String[] args) throws IOException {
		new MainFrame();
	}

}
