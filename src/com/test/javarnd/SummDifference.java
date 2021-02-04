package com.test.javarnd;

import java.util.Arrays;
import java.util.List;

public class SummDifference {

    public static int minDiff(List<Integer> arr) {
        Integer[] a = new Integer[arr.size()];
        a = arr.toArray(a);
        int n = arr.size();
        Arrays.sort(a);
        System.out.println(a.length);
        int min = 0;
        for (int i = 0; i < n - 1; i++) {
            int currentMin = Math.abs(a[i] - a[i + 1]);
            min += currentMin;
        }

        return (min);
    }

    public static void main(String[] args) {

    }
}