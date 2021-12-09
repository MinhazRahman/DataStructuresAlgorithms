package sorting;

// pre condition: Input arr[0..n-1] is an array of integers of length n. Array indexing is 0-based. arr[0] and arr[n-1] is the
// first and the last elements of the array, respectively.

// post condition: The program returns the same array arr[0...n-1] in sorted array, where arr[0]<=arr[1]<= ... arr[n-2]<=arr[n-1].
// If the input array is empty then the program returns an empty array.

// Design Idea: Incremental approach
// Having the sorted sub-array arr[0...j-1] and the unsorted sub-array arr[j...n-1] where j is an integer, 1 <= j <= n.
// We insert the element arr[j] at the proper place into the sorted sub-array, resulting in the sorted sub-array arr[0...j].
// Incrementing j for the next iteration gives us the the sorted sub-array arr[0...j-1].

import java.util.Arrays;

public class InsertionSort {

    public static int[] insertionSort(int[] arr){
       for (int j = 1; j < arr.length; j++){
           int key = arr[j];
           int i = j - 1;

           // move arr[j-1], arr[j-2], arr[j-3]... on the right
           while (i >= 0 && arr[i] >= key){
               arr[i+1] = arr[i];
               i = i - 1;
           }

           // insert the key = arr[j] at the proper place in the sorted array arr[0...j-1]
           arr[i+1] = key;
       }

        return arr;
    }

    public static void main(String[] args) {

        int[] input = {5, 2, 3, 1, 7};
        int[] emptyArray = {};

        System.out.println(Arrays.toString(insertionSort(emptyArray)));
        System.out.println(Arrays.toString(insertionSort(input)));

    }
}

// correctness proof of the Insertion sort algorithm.
// Invariant: sub-array arr[0...j-1] always contains the sorted elements.