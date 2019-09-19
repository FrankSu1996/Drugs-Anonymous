package components;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;

import Graph.InteractionGraph;
import search.AutoSuggestor;

@SuppressWarnings("serial")
public class UserGUI extends JPanel {
	
	private JTextArea output = new JTextArea();
	private JScrollPane scroll = new JScrollPane(output);	
	private JButton findClosest = new JButton("Start Search");
	private JTextField textfield = new JTextField(5);
	
	private JPanel filterPanel = new JPanel();
		
	/**
	 * Creates an initial layout
	 */
	public UserGUI() {
		super();
		this.layoutView();
		this.registerControllers();
	}
	 
	/**
	 * Organizes GUI components present
	 */
	@SuppressWarnings("unused")
	private void layoutView() {

		//Placing panels properly
		filterPanel.setLayout(new BoxLayout(filterPanel, BoxLayout.Y_AXIS));
		filterPanel.add(textfield);
		filterPanel.add(findClosest);
		
		textfield.setMaximumSize( 
			     new Dimension(Integer.MAX_VALUE, textfield.getPreferredSize().height) );
		
		//Panel for drug input
		JPanel textDisplay = new JPanel();
		textDisplay.setLayout(new BoxLayout(textDisplay, BoxLayout.Y_AXIS));
		textDisplay.add(scroll);

		//Panel placement
		this.setLayout(new BorderLayout());
		this.add(filterPanel, BorderLayout.WEST);
		this.add(textDisplay, BorderLayout.CENTER);
		
		//Autosuggestor text box that helps complete drug name
		AutoSuggestor autoSuggestor = new AutoSuggestor(textfield, MenuController.mainFrame, null, Color.WHITE.brighter(), Color.BLUE, Color.RED, 0.75f) {
            protected boolean wordTyped(String typedWord) {

                ArrayList<String> words = new ArrayList<>();
                InteractionGraph graph = InteractionGraph.InitInteractionGraph();
        		Iterable<String> drugs = graph.vertices();
        		for (String drug : drugs) {
        			words.add(drug);
        		}
                setDictionary(words);
                return super.wordTyped(typedWord);
            }
        };
	}
	
	/**
	 * Enables a response from GUI components
	 */
	public void registerControllers() {
		UserController controller = new UserController (this.output, this.findClosest, this.filterPanel, this.textfield);
	    this.findClosest.addActionListener(controller);
	}
}