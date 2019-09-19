package search;

import java.util.Map;

import Tables.DrugTable;
import Tables.RatingTable;

/**
 * @author Ritwik Jain Sahu
 * @version 1.0
 * @see Drug
 * Inspiration from Sedgewick and Wayne, almost same code.
 */

public class Merge {
	
	private static Comparable[] aux; // auxiliary array for merges
	/**
	 * top-down merge sort using Comparable
	 * @param x - the input array containing products that need to be sorted.
	 * @param n - the size of the input array
	 */
	public static void sortMergeTD ( Comparable[] x, int n ) {
		aux = new Comparable[n]; // Allocate space just once.
		sort(x, 0, n - 1);
	}
	
	/**
	 * recursively sort all sub-arrays and then merge them. 
	 * @param a - sub-array containing products that need to be sorted.
	 * @param lo - least index of sub-array
	 * @param hi - highest index of sub-array
	 * @see <a href=https://algs4.cs.princeton.edu/home/>Algorithms 4th Edition by Robert Sedgewick and Kevin Wayne</a>
	 */
	private static void sort(Comparable[] a, int lo, int hi) { // Sort a[lo..hi].
		if (hi <= lo) return;
		int mid = lo + (hi - lo)/2;
		sort(a, lo, mid); // Sort left half.
		sort(a, mid+1, hi); // Sort right half.
		merge(a, lo, mid, hi);
	}
	
	/**
	 * merging sub-arrays in order. 
	 * @param a - sub-array containing products that need to be sorted.
	 * @param lo - least index of sub-array
	 * @param mid - middle index of sub-array
	 * @param hi - highest index of sub-array
	 * @see @see <a href=https://algs4.cs.princeton.edu/home/>Algorithms 4th Edition by Robert Sedgewick and Kevin Wayne</a>
	 */
	private static void merge(Comparable[] a, int lo, int mid, int hi)
	{ // Merge a[lo..mid] with a[mid+1..hi].
		int i = lo, j = mid+1;
		for (int k = lo; k <= hi; k++) // Copy a[lo..hi] to aux[lo..hi].
			aux[k] = a[k];
		
		for (int k = lo; k <= hi; k++) // Merge back to a[lo..hi].
			if (i > mid) 
				a[k] = aux[j++];
			else if (j > hi ) 
				a[k] = aux[i++];
			else if (more(aux[j], aux[i])) 
				a[k] = aux[j++];
			else 
				a[k] = aux[i++];
	}
	
	/**
	 * checks if a Comparable is moreer than another Comparable.
	 * @param v - Comparable to be compared.
	 * @param w - Comparable to be checked against.
	 * @return true if v is more than w, false otherwise
	 */
	private static boolean more(Comparable v, Comparable w) {
		return v.compareTo(w) > 0; 
    }
	
	/**
	 * checks if an array of Comparable is sorted.
	 * @param a - Comparable to be checked.
	 * return true if a is sorted, false otherwise.
	 * @return boolean according to whether array is sorted or not
	 * @see <a href=https://algs4.cs.princeton.edu/home/>Algorithms 4th Edition by Robert Sedgewick and Kevin Wayne</a>
	 */
	public static boolean isSorted(Comparable[] a) {
        return isSorted(a, 0, a.length - 1);
    }

    private static boolean isSorted(Comparable[] a, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++)
            if (more(a[i], a[i-1])) return false;
        return true;
    }
    
    /******************************************************************************
     *  Copyright 2002-2018, Robert Sedgewick and Kevin Wayne.
     *
     *  This file is part of algs4.jar, which accompanies the textbook
     *
     *      Algorithms, 4th edition by Robert Sedgewick and Kevin Wayne,
     *      Addison-Wesley Professional, 2011, ISBN 0-321-57351-X.
     *      http://algs4.cs.princeton.edu
     *
     *
     *  algs4.jar is free software: you can redistribute it and/or modify
     *  it under the terms of the GNU General Public License as published by
     *  the Free Software Foundation, either version 3 of the License, or
     *  (at your option) any later version.
     *
     *  algs4.jar is distributed in the hope that it will be useful,
     *  but WITHOUT ANY WARRANTY; without even the implied warranty of
     *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
     *  GNU General Public License for more details.
     *
     *  You should have received a copy of the GNU General Public License
     *  along with algs4.jar.  If not, see http://www.gnu.org/licenses.
     ******************************************************************************/
}
