package com.techlabs.BinarySearch;

import com.techlabs.sortingAlgo.*;

public class BinarySearch {
	int[] sortedarr;

	public BinarySearch(SortingAlgorithm s) {
		this.sortedarr = s.sort();
		System.out.print("Sorted Array: ");
		for (int i : sortedarr)
			System.out.print(i + " ");
		System.out.println();
	}

	public String find(int search) {
		int left = 0, right = sortedarr.length - 1;
		while (left <= right) {
			int mid = left + (right - left) / 2;

			if (sortedarr[mid] == search)
				return "Element found at " + (mid + 1)
						+ "th position";

			if (sortedarr[mid] < search)
				left = mid + 1;
			else
				right = mid - 1;
		}
		return "Element not found";
	}

}
