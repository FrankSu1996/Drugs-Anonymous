package search;


public class Drug implements Comparable<Drug>{

	private String drug;
	private int rating;
	
	/**
	 * initialize product object
	 * @param drug - Drug name string.
	 * @param amount - User rating of drug.
	 */
	public Drug(String drug, int rating) {
		this.drug = drug;
		this.rating = rating;
	}
	
	/**
	 * get user rating of drug.
	 * @return rating - string value that represent user rating of drug.
	 */
	public int get_rating() {
		return this.rating;
	}
	
	/**
	 * get drug name.
	 * @return drug - String representing drug name.
	 */
	public String get_drug() {
		return this.drug;
	}
	
	/**
	 * gives the string representation of the drug.
	 * @return drug - String representation of the drug with the rating.
	 */
	public String toString() {
		return "Drug: " + this.drug + ", Rating: " + this.rating;
 	}
	
	/**
	 * decides the basis for ordering a list of drugs on user ratings.
	 * @param j - Another drug to compare current Drug with.
	 * @return drug - returns 1 if current rating is greater than comparison rating, -1 for lower and 0 for same.
	 */
	@Override
	public int compareTo(Drug j){
		if (this.rating > j.rating){
			return 1;
		}
		else if(this.rating < j.rating)
			return -1;
		else {
			return 0;
		}
	}
}
