package com.test.javarnd;/*
 * Copyright (c) 2021.
 * Author : Rahul Sharma
 */

import java.util.stream.IntStream;

public class Test {
	/**
	 * Lis() returns the length of the longest increasing subsequence in arr[] of
	 * size n.
	 */
	static int lis(int[] arr, int n) {
		int result = 0;
		int[] lis = new int[n];

		for (int i = 0; i < n; i++) {
			lis[i] = 1;
		}

		// compute in bottom up manner
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[i] > arr[j] && lis[i] < lis[j] + 1) {
					lis[i] = lis[j] + 1;
				}
			}
		}

		for (int i = 0; i < n; i++) {
			if (result < lis[i]) {
				result = lis[i];
			}
		}

		return result;
	}

	/** Function to calculate minimum number of deletions. */
	static int minimumNumberOfDeletions(int[] arr, int n) {
		int len = lis(arr, n);
		return n - len - 1;
	}

	public static void main(String[] args) {
		// int arr[] = {30, 40, 2, 5, 1, 7, 45, 50, 8};

		//int arr[] = { 5, 1, 2, 6, 4, 3 };

		int[] arr = {3,4,2,5,1};
		int n = arr.length;
		System.out.println("Minimum number of" + " deletions = " + minimumNumberOfDeletions(arr, n));
	}
}
