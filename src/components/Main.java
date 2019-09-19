package components;

import java.awt.*;
import javax.swing.*;

/** https://stackoverflow.com/questions/14186955/create-a-autocompleting-textbox-in-java-with-a-dropdown-list
 * @author David
 */
@SuppressWarnings("serial")
public class Main extends JPanel{
	
	//Starts the program for drug interaction searching
	private JButton start = new JButton ("Enter drug for interactions");
	//Starts the program for "drugs for symptoms" searching
	private JButton start2 = new JButton ("Enter symptoms to find a cure for");
	//The Logo for the program
	private Picture companyLogo = new Picture ("Logo/Logo.jpg");
	
	/**
	 * Creates an initial screen for the program
	 */
    public Main() {    	
    	super();
	    this.initialLayout();
	    this.registerControllers();
    }
    
    /**
     * Organizes every GUI component present
     */
    public void initialLayout() {
    	
    	//Panel for the buttons
		JPanel buttons = new JPanel();
		//Panel for the logo
		JPanel logo = new JPanel();
		//Adding buttons and logo to their respective panel
	    buttons.add(start);
	    start.setVisible(true);
	    buttons.add(start2);
	    start2.setVisible(true);
	    logo.add(companyLogo);
	    	    
	    //Placinng panels properly
	    this.setLayout(new BorderLayout());
	    this.add(buttons, BorderLayout.SOUTH);
	    this.add(logo, BorderLayout.CENTER);
	    
	    //Opens a window JFrame
	    JFrame mainFrame = new JFrame("Drugs Anonymous");
		mainFrame.setSize(500,200);
		mainFrame.setLocationRelativeTo(null);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setResizable(true);
		mainFrame.setVisible(true);
        
		//Adds both panels to JFrame
     	mainFrame.add(buttons,  BorderLayout.SOUTH);
     	mainFrame.add(logo,  BorderLayout.CENTER);
	}
    
    /**
     * Enables a response from GUI components
     */
    public void registerControllers () {
	    MenuController controller = new MenuController (this.start, this.start2);
	    this.start.addActionListener(controller);
	    this.start2.addActionListener(controller);
	  }

    /**
     * Calls the main function
     * @param args - Does nothing
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Main();
            }
        });
    }
}