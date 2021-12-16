package sorting;

// pre-condition: The input arr[0...n-1] is an array of integers where n is an integer and n is the number of elements
// post-condition: The program returns the array arr[0...n-1] in sorted order where arr[0]<=arr[1]<=...<= arr[n-1].

// design idea: Consider sorting n numbers stored in array arr[0...n-1] by first finding the smallest element
// of arr and exchanging it with the element in arr[0]. Then find the second-smallest element of arr,
// and exchange it with arr[1]. Continue in this manner for the first n-1 elements of arr

import java.util.Arrays;

public class SelectionSort {

    public static int[] selectionSort(int[] arr){
        int n = arr.length;
        for (int j = 0; j < n-1; j++){
            int i = j+1;
            int smallest = arr[j];
            int indexOfSmallest = j;
            // find the smallest element in the sub-array arr[j+1...n-1]
            while (i <= n-1){
                if (arr[i] < smallest) {
                    smallest = arr[i];
                    indexOfSmallest = i;
                }
                i = i+1; // move pointer to the next element
            }

            // swap arr[j] and the smallest element
            arr[indexOfSmallest]= arr[j];
            arr[j] = smallest;

            // check what actually happens on each iteration
            System.out.println(Arrays.toString(arr));
        }

        return arr;
    }
    public static void main(String[] args) {

        int[] intArr = {7, 5, 2, 3, 1};

        // print the final output
        System.out.println(Arrays.toString(selectionSort(intArr)));

    }
}

// loop invariant: The sub-array arr[0...j] is sorted and the sub-array arr[j+1...n-1] is unsorted where 0 <= j <= n-1 and
// n is the number of elements in the array arr[0...n-1].

// Proof:
// weak enough? on start or on initialization
// preserved? on each iteration
// strong enough? on termination
