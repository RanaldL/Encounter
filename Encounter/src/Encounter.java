import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Encounter implements ActionListener {
	
	JFrame frame = new JFrame("Encounter - Enemy generator");
	JPanel centrePanel = new JPanel();
	JPanel westPanel = new JPanel();
	JMenuItem close;
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Encounter encounter = new Encounter();
		encounter.startUp();
	}

	private void startUp() {
		// Construct the gui
		makeGui();
	}
	
	private void makeGui() {
		
		// Construct the menubar, menu and menuitems
		JMenuBar menubar = new JMenuBar();
		frame.setJMenuBar(menubar);
		
		JMenu menu = new JMenu("Menu");
		menubar.add(menu);		
		
		// Menu items
		close = new JMenuItem("Close"); // We don't really need this because the red x does the same thing, but users expect it...
		close.addActionListener(this);
		
		// Other menu items go here
		menu.addSeparator();
		menu.add(close);
		
		// Add the choices for the user
		creatureAdder();
		
		// Construct the frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(BorderLayout.CENTER, centrePanel);
		frame.getContentPane().add(BorderLayout.WEST, westPanel);
		
		frame.setSize(500, 150);
		frame.setVisible(true);
	}


	private void creatureAdder() {
		
		Integer[] quantity = {1,2,3,4,5,6,7,8,9,10};
		JComboBox quantityChooser = new JComboBox(quantity);
		quantityChooser.setEditable(false);
		quantityChooser.setMaximumRowCount(10);
		
		westPanel.add(quantityChooser);
		
		String[] choiceString = {"Goblin", "Skeleton", "Warg", "Werewolf", "Lich"};
		JComboBox enemyChooser = new JComboBox(choiceString);
		enemyChooser.setEditable(true);
		
		westPanel.add(enemyChooser);		
	}

	public void actionPerformed(ActionEvent event) {
		
		if (event.getSource() instanceof JMenuItem) {
			if (event.getSource() == close) {
				// We're out of here
				System.exit(0);
			} else {
				// TODO Some other menu related stuff
			}
		}
		// Make sure that any updates are refreshed on screen
		frame.validate();
	}

}
