import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class Frame extends JFrame {
	public Frame() throws IOException {
		super("Välkommen till Ritprogrammet!");
		/*
		 * Layout
		 */
		setLayout(new BorderLayout());
		this.setSize(700, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		/*
		 * DrawingArea
		 */
		final DrawingArea drawArea = new DrawingArea();
		this.add(drawArea, BorderLayout.CENTER);		
		/*
		 * Menubar
		 */
		JMenuBar menubar = new JMenuBar();
		this.setJMenuBar(menubar);
		JMenu archive = new JMenu("Arkiv");
		menubar.add(archive, BorderLayout.NORTH);
		JMenuItem save = new JMenuItem("Spara...");
		JMenuItem open = new JMenuItem("Öppna fil...");
		JMenuItem close = new JMenuItem("Avsluta");
		archive.add(save);
		archive.add(open);
		archive.add(close);
		/*
		 * Menubar Actions
		 */
		save.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
				chooser.showSaveDialog(null);
				File f = chooser.getSelectedFile();
				try {
					ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
					oos.writeObject(drawArea.getModel());
					oos.close();
				} catch (IOException exc ) {
					exc.printStackTrace();
				}
			}
		});
		open.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
				chooser.showOpenDialog(null);
				File f = chooser.getSelectedFile();
				try {
					ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
					//drawArea.setModel((DrawingModel) ois.readObject());
					drawArea.setModel(ois.readObject());
					drawArea.paintComponent();
					ois.close();
				} catch (IOException ex) {
					ex.printStackTrace();
				} catch (ClassNotFoundException ex) {
					ex.printStackTrace();
				} catch (NullPointerException ex) {
					ex.getCause();
					//ex.printStackTrace();
				}
			}
		});
		close.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		/*
		 * Buttons
		 */
		JPanel sidePanel = new JPanel();
		sidePanel.setLayout(new BorderLayout());
		
		BottomButtons bottomButtons = new BottomButtons(drawArea.getModel());
		this.add(bottomButtons, BorderLayout.SOUTH);
		
		SideButtons sideButtons = new SideButtons(drawArea.getModel());
		sideButtons.setPreferredSize(new Dimension(40, 360));
		
		ShapeButtons shapeButtons = new ShapeButtons(drawArea.getModel());
		shapeButtons.setPreferredSize(new Dimension(40, 160));

		sidePanel.add(sideButtons, BorderLayout.NORTH);
		sidePanel.add(shapeButtons, BorderLayout.SOUTH);
		this.add(sidePanel, BorderLayout.EAST);
		/*
		 * Show our frame
		 */
		this.setVisible(true);
	}

	public static void main(String[] args) throws IOException {
		new Frame();
	}
}
