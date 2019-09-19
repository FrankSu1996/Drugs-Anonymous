package components;

import javax.swing.*;
import java.awt.event.*;

public class MenuController implements ActionListener{
	
	//Starts the program for drug interaction searching
	private JButton startButton;
	//Starts the program for "drugs for symptoms" searching
	private JButton startButton2;
	//GUI that displays the drug interaction interface
	private UserGUI cfiDisplay;
	//GUI that displays the symptoms interface
	private UserGUI2 cfiDisplay2;
	//Window for displaying the options
	public static JFrame mainFrame = new JFrame("Drugs Anonymous");

	/**
	 * Initializes a controller
	 * @param start - the button that starts the searching for drug interactions
	 * @param start2 - the button that starts the searching for drug cures
	 */
	public MenuController (JButton start, JButton start2){
	    this.startButton = start;
	    this.startButton2 = start2;
	}

	/** Checks whether the user wants to perform an action based on an event
	 * @param e - the event
	 */
	public void actionPerformed(ActionEvent e){		
		if (e.getSource().equals(startButton)) {
			//GUI for drug interactions
			cfiDisplay = new UserGUI();
			mainFrame.setSize(1000,720);
			mainFrame.setLocationRelativeTo(null);
			mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			mainFrame.setResizable(true);
			mainFrame.setContentPane(cfiDisplay);
			mainFrame.setVisible(true);
		}
		if (e.getSource().equals(startButton2)) {
			//GUI for symptom cures
			cfiDisplay2 = new UserGUI2();
			mainFrame.setSize(1000,720);
			mainFrame.setLocationRelativeTo(null);
			mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			mainFrame.setResizable(true);
			mainFrame.setContentPane(cfiDisplay2);
			mainFrame.setVisible(true);
		}
	}	  
}