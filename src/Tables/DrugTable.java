package Tables;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Hash Table representation of condition/drug data set.
 * 
 * @author Ritwik Jain Sahu
 *
 */
public class DrugTable {
	
	public static HashMap<String, ArrayList<String>> table;
	
	/**
	 * Reads from dataset and initializes table and fills it with the data in csv file.
	 * Contains conditions as keys and drug names as values.
	 * 
	 */
	public static void init() {
		table = new HashMap<String, ArrayList<String>>();
		String fileName = "data/drugsComTest_raw_noreviews.csv";
		File file = new File(fileName);
		try {
			Scanner sc = new Scanner(file);
			while(sc.hasNext()) {
				String data = sc.nextLine();
				String[] values = (data.split(","));
				String condition = values[2].toLowerCase();
				String drug = values[1].toLowerCase();
				for (int i = 0; i < drug.length(); i++){
				    char c = drug.charAt(i);        
				    if (c == '/') {
				    	drug = drug.substring(0, i-1);
				    }
				}

				if (table.get(condition) == null) {
					ArrayList<String> arrli = new ArrayList<String>(1);
					arrli.add(drug);
					table.put(condition, arrli);
				}
				else {
					if (table.get(condition).contains(drug)){
						continue;
					}
					else
						table.get(condition).add(drug);
				}
			}
			sc.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found!");
		}
	}
}
