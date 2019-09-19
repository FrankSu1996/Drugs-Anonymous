package search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import Tables.DrugTable;
import Tables.RatingTable;

public class Main {

	public static void main(String[] args) {
		DrugTable.init();
		RatingTable.init();
		/*String condition = "acne";
		ArrayList<String> drugs = DrugTable.table.get(condition);
		HashMap<String, Integer> drugSort= new HashMap<String, Integer>();
		for (String key: drugs) {
			drugSort.put(key, RatingTable.reviews.get(key));
		}
		ArrayList<String> sortedDrugs = new ArrayList<String>();

        Map<String,Integer> sortedMap = Sort.sortByValueDesc(drugSort);
        for (Map.Entry<String, Integer> entry : sortedMap.entrySet()) {
        	sortedDrugs.add(entry.getKey());
        	System.out.println(entry.getKey() + " - " + entry.getValue());
            
        }
        */
		ArrayList<String> words = new ArrayList<>();
        for (Map.Entry<String, ArrayList<String>> entry : DrugTable.table.entrySet()) {
        	words.add(entry.getKey());
		}               
        
        System.out.println(words);
        words.remove(0);
        System.out.println(words);
	}
}
