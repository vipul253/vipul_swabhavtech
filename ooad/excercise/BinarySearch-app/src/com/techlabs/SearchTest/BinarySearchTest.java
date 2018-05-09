package com.techlabs.SearchTest;

import com.techlabs.BinarySearch.*;
import com.techlabs.sortingAlgo.*;

public class BinarySearchTest {

	public static void main(String[] args) {
		int[] arr = { 3, 4, 8, 9, 10, 78, 95, 34, 0, 2 };

		// BinarySearch bs=new BinarySearch(new QuickSort(arr));
		BinarySearch bs = new BinarySearch(new BubbleSort(arr));

		System.out.println(bs.find(10));

	}

}
