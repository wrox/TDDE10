package graphics;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * Buttons available when highscore view is enabled in the frame.
 * @author erika712
 *
 */
public class HighScoreButtons extends JPanel {

	public HighScoreButtons(final MainFrame frame) {

		this.setLayout(new GridLayout(1, 1));

		JButton back = new JButton("Back");

		ArrayList<JButton> allBtns = new ArrayList<>();
		allBtns.add(back);

		for (JButton btn : allBtns) {
			btn.setPreferredSize(new Dimension(40, 40));
		}

		for (JButton btn : allBtns) {
			this.add(btn);
		}

		back.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.startScreenViewFromHighscores();
			}
		});

	}

}
