package Tables;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Hash Table representation of drug/rating data set.
 * 
 * @author Ritwik Jain Sahu
 *
 */
public class RatingTable {

	public static HashMap<String, ArrayList<Integer>> table2;
	public static HashMap<String, Integer> reviews;
	
	/**
	 * Reads from dataset and initializes table and fills it with the data in csv file.
	 * Contains drug names as keys and user ratings as values.
	 * 
	 */
	public static void init() {
		table2 = new HashMap<String, ArrayList<Integer>>();
		String fileName = "data/drugsComTest_raw_notitles.csv";
		File file = new File(fileName);
		try {
			Scanner sc = new Scanner(file);
			while(sc.hasNext()) {
				String data = sc.nextLine();
				String[] values = (data.split(","));
				String drug = values[1].toLowerCase();
				int rating = Integer.parseInt(values[3].trim());
				for (int i = 0; i < drug.length(); i++){
				    char c = drug.charAt(i);        
				    if (c == '/') {
				    	drug = drug.substring(0, i-1);
				    }
				}
				if (table2.get(drug) == null) {
					ArrayList<Integer> arrli = new ArrayList<Integer>(1);
					arrli.add(rating);
					table2.put(drug, arrli);
				}
				else {
					table2.get(drug).add(rating);
				}
			}
			sc.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found!");
		}
		reviews = new HashMap<String, Integer>();
		for (HashMap.Entry<String, ArrayList<Integer>> entry : table2.entrySet()) {
		    int sum = 0;
		    int average = 0;
		    for(int i = 0; i < entry.getValue().size(); i++){
		        sum = sum + entry.getValue().get(i);
		    }
		    average = sum/entry.getValue().size();
		    reviews.put(entry.getKey(), average);
		}
	}
}