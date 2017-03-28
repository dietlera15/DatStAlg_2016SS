package at.fhj.swd;

public class Mergesort2 {
	
	public static int[] sortArray = { 54, 26, 93, 17, 77, 31, 44, 55, 20 };

	public int[] sort(int l, int r) {
		if (l < r) {
			int q = (l + r) / 2;
			sort(l, q);
			sort(q + 1, r);
			merge(l, q, r);
		}
		return sortArray;
	}

	private void merge(int l, int q, int r) {
		int[] arr = new int[sortArray.length];
		int i, j;
		for (i = l; i <= q; i++) {
			arr[i] = sortArray[i];
		}
		for (j = q + 1; j <= r; j++) {
			arr[r + q + 1 - j] = sortArray[j];
		}
		i = l;
		j = r;
		for (int k = l; k <= r; k++) {
			if (arr[i] <= arr[j]) {
				sortArray[k] = arr[i];
				i++;
			} else {
				sortArray[k] = arr[j];
				j--;
			}
		}
	}

	public static void main(String[] args) {
		Mergesort2 ms = new Mergesort2();
		int[] arr = ms.sort(0, sortArray.length - 1);
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
}
/*
import java.util.ArrayList;

public class MergeSortExample {
	public static void main(String[] args) {
		ArrayList<Integer> startlist = new ArrayList<Integer>();
		ArrayList<Integer> resultlist = new ArrayList<Integer>();
		for (int i = 0; i < 8; i++) {
			startlist.add(i, (int) (Math.random() * 50 + 1));
		}
		System.out.println("Startinglist: " + startlist.toString());
		resultlist = mergesort(startlist);
		System.out.println("Result: " + resultlist.toString());
	}

	public static ArrayList<Integer> mergesort(ArrayList<Integer> upperlist) {
		ArrayList<Integer> returnlist = new ArrayList<Integer>();
		int upperlistlength = upperlist.size();
		if (upperlistlength <= 1) {
			returnlist = upperlist;
			System.out.println("reached single item" + returnlist.toString());
			System.out.println();
		} else {
			System.out.println("Splitting: " + upperlist.toString());
			int middle = upperlistlength / 2;
			ArrayList<Integer> leftlist = new ArrayList<Integer>();
			ArrayList<Integer> rightlist = new ArrayList<Integer>();
			for (int i = 0; i < middle; i++) {
				leftlist.add(upperlist.remove(0));
			}
			rightlist = upperlist;
			System.out.println("Splited: left list: " + leftlist.toString() + " right list: " + rightlist.toString());
			System.out.println();
			leftlist = mergesort(leftlist);
			rightlist = mergesort(rightlist);
			returnlist = merge(leftlist, rightlist);
		}
		return returnlist;
	}

	public static ArrayList<Integer> merge(ArrayList<Integer> mergeleft, ArrayList<Integer> mergeright) {
		System.out
				.println("Merging now: leftlist " + mergeleft.toString() + " " + "rightlist " + mergeright.toString());
		ArrayList<Integer> sortedlist = new ArrayList<Integer>();
		while ((mergeleft.size() > 0) && (mergeright.size() > 0)) {
			if (mergeleft.get(0) <= mergeright.get(0)) {
				sortedlist.add(mergeleft.remove(0));
			} else {
				sortedlist.add(mergeright.remove(0));
			}
		}
		while (mergeleft.size() > 0) {
			sortedlist.add(mergeleft.remove(0));
		}
		while (mergeright.size() > 0) {
			sortedlist.add(mergeright.remove(0));
		}
		System.out.println("Merged: " + sortedlist.toString());
		System.out.println();
		return sortedlist;
	}
}
*/