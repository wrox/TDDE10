package graphics;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

public class StartScreenButtons extends JPanel {

	/**
	 * A panel which holds three buttons; Choose a level, Highscores and exit.
	 * 
	 * @param frame
	 */
	public StartScreenButtons(final MainFrame frame) {

		this.setLayout(new GridLayout(1, 3));

		JButton chooseLevel = new JButton("Start");
		JButton viewHighScore = new JButton("High Score");
		JButton exit = new JButton("Exit");
		
		ArrayList<JButton> allBtns = new ArrayList<>();
		allBtns.add(chooseLevel);
		allBtns.add(viewHighScore);
		allBtns.add(exit);

		for (JButton btn : allBtns) {
			btn.setPreferredSize(new Dimension(40, 40));
		}

		for (JButton btn : allBtns) {
			this.add(btn);
		}

		chooseLevel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.levelChooser();
			}

		});
		
		viewHighScore.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.highScoresView();
			}

		});

		exit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(ABORT);
			}

		});
	}

}
