package components;

import java.awt.*;
import java.util.ArrayList;
import java.util.Map;

import javax.swing.*;

import Tables.DrugTable;
import search.AutoSuggestor;

@SuppressWarnings("serial")
public class UserGUI2 extends JPanel {
	
	private JTextArea output = new JTextArea();
	private JScrollPane scroll = new JScrollPane(output);	
	private JButton findClosest = new JButton("Start Search");
	private JTextField textfield = new JTextField(5);
	
	private JPanel filterPanel = new JPanel();
		
	/**
	 * Creates an initial layout
	 */
	public UserGUI2() {
		super();
		this.layoutView();
		this.registerControllers();
	}
	
	/**
	 * Organizes GUI components present
	 */
	private void layoutView() {

		//Places panels properly
		filterPanel.setLayout(new BoxLayout(filterPanel, BoxLayout.Y_AXIS));
		filterPanel.add(textfield);
		filterPanel.add(findClosest);
		
		textfield.setMaximumSize( 
			     new Dimension(Integer.MAX_VALUE, textfield.getPreferredSize().height) );
		
		//Panel for symptom input
		JPanel textDisplay = new JPanel();
		textDisplay.setLayout(new BoxLayout(textDisplay, BoxLayout.Y_AXIS));
		textDisplay.add(scroll);

		//Panel placement
		this.setLayout(new BorderLayout());
		this.add(filterPanel, BorderLayout.WEST);
		this.add(textDisplay, BorderLayout.CENTER);
		
		//Autosugestor text box that helps complete symptom name
		@SuppressWarnings("unused")
		AutoSuggestor autoSuggestor = new AutoSuggestor(textfield, MenuController.mainFrame, null, Color.WHITE.brighter(), Color.BLUE, Color.RED, 0.75f) {
            protected boolean wordTyped(String typedWord) {

                ArrayList<String> words = new ArrayList<>();
                for (Map.Entry<String, ArrayList<String>> entry : DrugTable.table.entrySet()) {
                	words.add(entry.getKey());
        		}               
                words.remove(0);
                setDictionary(words);
                return super.wordTyped(typedWord);
            }
        };
	}
	
	/**
	 * Enables a response from GUI components 
	 */
	public void registerControllers() {
		UserController2 controller = new UserController2 (this.output, this.findClosest, this.filterPanel, this.textfield);
	    this.findClosest.addActionListener(controller);
	}
}