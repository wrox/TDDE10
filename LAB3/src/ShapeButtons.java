import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ShapeButtons extends JPanel {
	
	private Graphics g;
	
	public ShapeButtons(final DrawingModel model) throws IOException {
		final ArrayList<JButton> allButtons = new ArrayList<>();
		/* 
		 * Panel layout
		 */
		this.setLayout(new GridLayout(4, 1));
		
		/*
		 * Init. buttons
		 */
		final JLabel label = new JLabel("Form:");
		final JButton circle = new JButton();
		final JButton rect = new JButton();
		final JButton tri = new JButton();
		/*
		 * Set shape aesthetics
		 */
		try {
			Image img = ImageIO.read(getClass().getResource("MyCircle.png"));
			img = img.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
			circle.setIcon(new ImageIcon(img));
		} catch (Exception IOException) {
			System.out.println("failed on circle");
		}

		try {
			Image img = ImageIO.read(getClass().getResource("MyRect.png"));
			img = img.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
			rect.setIcon(new ImageIcon(img));
		} catch (Exception IOException) {
			System.out.println("failed on rect");
		}

		try {
			Image img = ImageIO.read(getClass().getResource("MyTri.png"));
			img = img.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
			tri.setIcon(new ImageIcon(img));
		} catch (Exception IOException) {
			System.out.println("failed on tri");
		}
		/*
		 * Add buttons
		 */
		this.add(label);
		allButtons.add(circle);
		allButtons.add(rect);
		allButtons.add(tri);
		/*
		 * Button borders
		 */
		for (JButton btn : allButtons) {
			btn.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
			btn.setBorderPainted(false);
			this.add(btn);
		}
		circle.setBorderPainted(true); // Highlight the default shape
		/*
		 * Button actions
		 */	
		circle.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				for (JButton btn : allButtons) {
					btn.setBorderPainted(false);
				}
				circle.setBorderPainted(true);
				model.setNewShape(new MyCircle());
			}
		});
		rect.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				for (JButton btn : allButtons) {
					btn.setBorderPainted(false);
				}
				rect.setBorderPainted(true);
				model.setNewShape(new MyRect());
			}
		});	
		tri.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				for (JButton btn : allButtons) {
					btn.setBorderPainted(false);
				}
				tri.setBorderPainted(true);
				model.setNewShape(new MyTri());
			}
		});
	}
}
