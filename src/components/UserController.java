package components;

import java.awt.event.*;
import javax.swing.*;

import Graph.InteractionGraph;

public class UserController implements ActionListener{
	private JTextArea output;
	private JButton closest;
	JComboBox<String> sortMenu;
	private JTextField textbox;
	private String list;
	public static String drugname;
	@SuppressWarnings("unused")
	private JPanel filterPanel;

	/**
	 * Sets up a controller for certain GUI Components
	 * @param out - The output area
	 * @param close - The button to perform the search
	 * @param fp - The Panel where the textbox is
	 * @param textfield - The textbox where we enter the drug name
	 */
	public UserController(JTextArea out, JButton close, JPanel fp, JTextField textfield) {
		this.output = out;
		this.closest = close;
		this.filterPanel = fp;
		this.textbox = textfield;
	}

	/**
	 * Performs an action
	 */
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(closest)) {
			//Takes input from textbox
			drugname = textbox.getText();
			drugname = drugname.trim();
			list = "These are the interactions for " + drugname + ": \n\n";
			//Performs the search
			InteractionGraph graph = InteractionGraph.InitInteractionGraph();
	    	Iterable<String> interactions = graph.adjacentTo(drugname);
	    	for (String drug : interactions) {
	    		list += drug + "\n";
	    	}
	    	//Adds the information to output area
			output.setText(list);
		}
	}
}