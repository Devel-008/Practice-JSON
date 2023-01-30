package com.java8;

import java.util.Arrays;
public class ParallelArraySorting {
    public static void main(String[] args) {
        // Creating an integer array
        int[] arr = {5,8,1,0,6,9};
        // Iterating array elements
        for (int i : arr) {
            System.out.print(i+" ");
        }
        // Sorting array elements parallel
        Arrays.parallelSort(arr);
        System.out.println("\nArray elements after sorting=>");
        // Iterating array elements
        for (int i : arr) {
            System.out.print(i+" ");
        }
        System.out.println();
        System.out.println("------------------------------------------------------------------------------");
        int[] arr1 = {5,8,1,0,6,9,50,-3};
        // Iterating array elements
        for (int i1 : arr1) {
            System.out.print(i1+" ");
        }
        // Sorting array elements parallel and passing start, end index
        Arrays.parallelSort(arr1,0,4);
        System.out.println("\nArray elements after sorting");
        // Iterating array elements
        for (int i1 : arr1) {
            System.out.print(i1+" ");
        }

    }
}
