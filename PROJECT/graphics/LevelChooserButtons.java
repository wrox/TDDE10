package graphics;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * Buttons available when a player wants to starts a new game.
 * @author erika712
 *
 */
public class LevelChooserButtons extends JPanel {

	public LevelChooserButtons(final MainFrame frame) {

		this.setLayout(new GridLayout(3, 1));

		JButton easy = new JButton("Easy");
		JButton hard = new JButton("Hard");
		JButton back = new JButton("Back");
		
		ArrayList<JButton> allBtns = new ArrayList<>();
		allBtns.add(easy);
		allBtns.add(hard);
		allBtns.add(back);
		

		for (JButton btn : allBtns) {
			btn.setPreferredSize(new Dimension(40, 40));
		}

		for (JButton btn : allBtns) {
			this.add(btn);
		}

		easy.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setArena(true);
				frame.getStartScreen().running(false);
			}
		});

		hard.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setArena(false);
				frame.getStartScreen().running(false);
			}

		});
		
		back.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.startScreenViewFromLevelChooser();
			}
			
		});
	}

}
