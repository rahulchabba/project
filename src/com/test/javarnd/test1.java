package com.test.javarnd;/*
 * Copyright (c) 2021.
 * Author : Rahul Sharma
 */

import java.util.Arrays;
import java.util.Collections;

class test1 {

	// Function to return the maximized value
	static int find_maximum_value(int[] a, int n) {
		int sum = 0;
		int minimum = Integer.MAX_VALUE;
		int pos = 0, neg = 0;

		for (int i = 0; i < n; i++) {

			minimum = Math.min(minimum, Math.abs(a[i]));

			sum += Math.abs(a[i]);

			if (a[i] >= 0)
				pos += 1;
			else
				neg += 1;
		}

		if (pos > 0 && neg > 0)
			return sum;

		return (sum - 2 * minimum);
	}

	public static int maximizeFinalElement(int[] arr, int n) {
		Arrays.sort(arr);

		if (arr[0] != 1)
			arr[0] = 1;

		for (int i = 1; i < n; i++) {
			if (arr[i] - arr[i - 1] > 1) {
				arr[i] = arr[i - 1] + 1;
			}
		}
		return arr[n - 1];
	}

	public static void main(String[] args) {

		int[] a = { 1, 3, 2, 2 };
		int n = a.length;

		System.out.println(maximizeFinalElement(a, n));
	}
}
