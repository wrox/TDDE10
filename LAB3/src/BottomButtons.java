import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;


public class BottomButtons extends JPanel {
	
	public BottomButtons(final DrawingModel model) {
		/*
		 * Panel layout
		 */
		this.setLayout(new BorderLayout());
		/*
		 * Init. buttons
		 */
		final JButton erase = new JButton("Rensa");
		/*
		 * Add buttons
		 */
		this.add(erase, BorderLayout.WEST);
		/*
		 * Button actions
		 */	
		erase.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				model.getShapes().clear();
			} 
			
		});
	}
}