package at.fhj.swd;

public class DatStAlg_InsSort {

/*
 * SWD WS 2015
 * Datenstrukturen und Algorithmen
 * Insertion Sort
 * 
 * Baar Alexander
 * Dietler Andreas
 * Reimer Bogdan
 * Spreco Mirza
 */
	
	public static void main(String[] args) {

		int[] unsortiert = { 4, -7, -2, 1, 9, -1, 8, 10, -10, -4, 2, -3, 3, 0, -5, -6, -8, 5, 7, 6, -9 };
		int[] sortiert = insertionSort(unsortiert);

		for (int i = 0; i < sortiert.length; i++) {
			System.out.print(sortiert[i] + ", ");
		}
	}

	public static int[] insertionSort(int[] sortieren) {
		int temp;
		for (int i = 1; i < sortieren.length; i++) {
			temp = sortieren[i];
			int j = i;
			while (j > 0 && sortieren[j - 1] > temp) {
				sortieren[j] = sortieren[j - 1];
				j--;
			}
			sortieren[j] = temp;
		}
		return sortieren;
	}

}