package sorting;

// pre condition: Input arr[0..n-1] is an array of integers of length n. Array indexing is 0-based. arr[0] and arr[n-1] is the
// first and the last elements of the array, respectively.

// post condition: The program returns the same array arr[0...n-1] in sorted array, where arr[0]<=arr[1]<= ... arr[n-2]<=arr[n-1].
// If the input array is empty then the program returns an empty array.

// *** Improve the Design Idea ***

// Design Idea: Incremental approach
// We divide the input array, arr[0...n-1] logically into two sub-arrays, arr[0...j-1] and arr[j...n-1] where j is an integer, 1 <= j <= n.
// The sub-array arr[0...j-1] holds the sorted elements and the sub-array arr[j...n-1] consists of the unsorted elements.
// We insert the element arr[j] at the proper place into the sorted sub-array, resulting in the sorted sub-array arr[0...j].
// Incrementing j for the next iteration gives us the sub-array arr[0...j-1] that is already sorted.

//Consider the input array is, arr = {5, 2, 3, 1 7}

// Here, we will use two loops, the outer for loop will iterate over the array, arr[0...n-1] for j = 1 to j < arr.length.
// The inner loop will move the element arr[j-1], arr[j-2], arr[j-3]... to the right in the array arr[0...j].
// At the end of the inner loop we place the element arr[j] at proper position, resulting in the sorted sub-array arr[0..j].
// We increment j at the start of next iteration, which gives the sorted sub-array arr[0...j-1].

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
// Guess Invariant: sub-array arr[0...j-1] always contains the sorted elements.

// Tests of the Guess loop invariant.
// Weak enough? Is the gI true on start or on initialization?
// On initialization j = 1, the sorted sub-array arr[0] holds only one element. So, on start, the sub-array arr[0...j-1]
// is trivially sorted. Yes, the guess invariant is weak enough.

// Preserved? Is the gI true on each iteration?
// Having the sorted sub-array arr[0...j-1], we insert arr[j] at the proper position in the sorted sub-array, resulting
// in sorted sub-array arr[0...j]

// Incrementing j for the next iteration of for loop then preserves the guess loop invariant.

// Strong enough? Is the gI true on termination.
// The loop controlling variable j is an integer and we increment j by 1 on each iteration. The for loop terminates
// when j = n, where n is the length of the array.
// Substituting n for j in the loop invariant, we have the sub-array arr[0...n-1] holds the elements originally in
// arr[0...n-1] but in sorted order. The sub-array arr[0...n-1] is the entire array.
// We conclude that the entire array is sorted. Hence, the algorithm is correct.
