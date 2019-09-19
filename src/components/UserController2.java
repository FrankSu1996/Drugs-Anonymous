package components;

import java.awt.event.*;

import javax.swing.*;

import Tables.DrugTable;
import Tables.RatingTable;
import search.Drug;
import search.Merge;

public class UserController2 implements ActionListener{

	private JTextArea output;
	private JButton closest;
	JComboBox<String> sortMenu;
	private JTextField textbox;
	private String list;
	public static String symptom;
	@SuppressWarnings("unused")
	private JPanel filterPanel;

	/**
	 * Sets up a controller for certain GUI components
	 * @param out - The output area
	 * @param close - The button to perform the search
	 * @param fp - The Panel where the textbox is
	 * @param textfield - The textbox where we enter the symptom name
	 */
	public UserController2(JTextArea out, JButton close, JPanel fp, JTextField textfield) {
		this.output = out;
		this.closest = close;
		this.textbox = textfield;
	}

	/**
	 * Performs an action
	 */
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(closest)) {
			//Initializes the drug and rating table
			DrugTable.init();
			RatingTable.init();
			//Takes input from textbox
			symptom = textbox.getText();
			symptom = symptom.trim();
			list = "The drugs for the symptom \"" + symptom + "\" are: \n\n"; 
			//Performs the search
			Drug arr[] = new Drug[DrugTable.table.get(symptom).size()];
			int i =0;
			for (String drug : DrugTable.table.get(symptom)) {
				Drug temp = new Drug(drug, RatingTable.reviews.get(drug));
				arr[i] = temp;
				i++;
	        }
			//Sorts by rating using Mergesort
			Merge.sortMergeTD(arr, arr.length);
			for(Drug drug: arr)
				list += drug + "\n";
			//Adds the information to output area
			output.setText(list);
		}
	}
}