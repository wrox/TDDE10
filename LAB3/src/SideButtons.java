import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SideButtons extends JPanel {

	public SideButtons(final DrawingModel drawingModel) {
		final ArrayList<JButton> allbtns = new ArrayList<>();
		/*
		 * Panel layout
		 */
		this.setLayout((new GridLayout(9, 1)));
		JPanel panelPadder = new JPanel();
		panelPadder.setLayout(new FlowLayout(FlowLayout.LEADING, 20, 5));
		/*
		 * Init. buttons
		 */
		final JLabel label = new JLabel("Färg:");
		final JButton black = new JButton();
		final JButton white = new JButton();
		final JButton blue = new JButton();
		final JButton red = new JButton();
		final JButton yellow = new JButton();
		final JButton green = new JButton();
		final JButton magenta = new JButton();
		final JButton cyan = new JButton();
		/*
		 * Set shape aesthetics
		 */
		black.setBackground(Color.BLACK);
		white.setBackground(Color.WHITE);
		blue.setBackground(Color.BLUE);
		red.setBackground(Color.RED);
		yellow.setBackground(Color.YELLOW);
		green.setBackground(Color.GREEN);
		magenta.setBackground(Color.MAGENTA);
		cyan.setBackground(Color.CYAN);
		/*
		 * Add buttons
		 */
		this.add(label);
		allbtns.add(black);
		allbtns.add(white);
		allbtns.add(blue);
		allbtns.add(red);
		allbtns.add(yellow);
		allbtns.add(green);
		allbtns.add(magenta);
		allbtns.add(cyan);	
		/*
		 * Button borders
		 */
		for (JButton btn : allbtns) {
			btn.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
			btn.setBorderPainted(false);
			this.add(btn);

			black.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
			black.setBorderPainted(true);
		}
		/*
		 * Button actions
		 */
		black.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				for (JButton btn : allbtns) {
					btn.setBorderPainted(false);
				}
				black.setBorderPainted(true);
				drawingModel.setCurrentColor(black.getBackground());
			}
		});
		white.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				for (JButton btn : allbtns) {
					btn.setBorderPainted(false);
				}
				white.setBorderPainted(true);
				drawingModel.setCurrentColor(white.getBackground());
			}
		});
		blue.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				for (JButton btn : allbtns) {
					btn.setBorderPainted(false);
				}
				blue.setBorderPainted(true);
				drawingModel.setCurrentColor(blue.getBackground());
			}
		});
		red.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				for (JButton btn : allbtns) {
					btn.setBorderPainted(false);
				}
				red.setBorderPainted(true);
				drawingModel.setCurrentColor(red.getBackground());
			}
		});
		yellow.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				for (JButton btn : allbtns) {
					btn.setBorderPainted(false);
				}
				yellow.setBorderPainted(true);
				drawingModel.setCurrentColor(yellow.getBackground());
			}
		});
		green.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				for (JButton btn : allbtns) {
					btn.setBorderPainted(false);
				}
				green.setBorderPainted(true);
				drawingModel.setCurrentColor(green.getBackground());
			}
		});
		magenta.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				for (JButton btn : allbtns) {
					btn.setBorderPainted(false);
				}
				magenta.setBorderPainted(true);
				drawingModel.setCurrentColor(magenta.getBackground());
			}
		});
		cyan.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				for (JButton btn : allbtns) {
					btn.setBorderPainted(false);
				}
				cyan.setBorderPainted(true);
				drawingModel.setCurrentColor(cyan.getBackground());
			}
		});
	}
}