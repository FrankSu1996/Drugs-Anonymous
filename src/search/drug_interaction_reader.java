package search;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class drug_interaction_reader {
	public static void main(String[] args) {
		File file = new File("data/drug_interactions.txt");
		Scanner sc;
		BufferedWriter writer;
		try {
			writer = new BufferedWriter(new FileWriter("data/drug_interactions.txt"));
			sc = new Scanner(file);
			while (sc.hasNextLine()) {
				String line = sc.nextLine();
				if (!line.contains("/") && !line.contains(",")) {
					writer.write(line);
					writer.write("\n");
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
