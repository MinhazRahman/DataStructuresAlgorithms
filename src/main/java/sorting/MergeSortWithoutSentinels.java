package sorting;

// In the array A[p...r] the sub-arrays A[p...q] and A[q+1...r] are sorted where p <= q < r.
// Merge the sub-arrays A[p...q] and A[q+1...r] in sorted order into the array A[p...r].
// A[p...r] = {...1, 4, 6, 7, 2, 5, 8, 9...} ==> merge(A, p, q, r) ==> A[p...r] = {...1, 2, 4, 5, 6, 7, 8, 9...}
// So the merge procedure replaces the original sequence of the elements.

import java.util.Arrays;

// Things to consider:
// 1. the number of elements each sub-array contains
// 2. the total number of elements we need to sort
// 3. the merging strategy

// Merge sort: What is the Divide and conquer strategy for merge sort?
// Divide: Divide the array into equal sub-arrays of n/2 elements
// Conquer: Sort each sub-array
// Combine: Combine the sorted sub-arrays
public class MergeSortWithoutSentinels {

    public static void merge(int[] A, int p, int q, int r){
        // The number of elements in the left sub-array A[p...q]
        int nl = q - p + 1;
        // The number of elements in the right sub-array A[q+1...r]
        int nr = r - q; //r - (q+1) + 1 = r - q;

        // So, the number of elements we need to merge in the array A[p...r] is
        // n = nl + nr = q - p + 1 + r - q = r - p + 1

        // Create an array L[0...nl-1] where we will copy the elements of the left sub-array A[p...q]
        int[] L = new int[nl];

        // Create another array R[0...nr-1] where we copy the elements of the right sub-array A[q+1...r]
        int[] R = new int[nr];

        // Copy the elements of the left sub-array A[p...q] into L
        for (int i = 0; i < nl; i++){
            L[i] = A[p+i];
        }

        // Copy the elements of the right sub-array A[q+1...r] into R
        for (int j = 0; j < nr; j++){
            R[j] = A[q+1+j];
        }

        // Merge the elements of L and R into A[p...r]
        // 1. Copy all the elements of either L or R into A
        int i = 0, j = 0, k = p;
        while (i < nl && j < nr && k <= r){
            if (L[i] <= R[j]){
                A[k] = L[i];
                i++;
            }
            else { // R[j] < L[i]
                A[k] = R[j];
                j++;
            }
            k++;
        }

        // 2. Copy all the remaining elements of L into A
        while (i < nl && k <= r){
            A[k] = L[i];
            i++;
            k++;
        }

        // 3. Copy all the remaining elements of R into A
        while (j < nr && k <= r){
            A[k] = R[j];
            j++;
            k++;
        }
    }

    public static void mergeSort(int[] A, int p, int r){
        if (p < r){
            int q = (p + r)/2; // q is the mid value
            mergeSort(A, p, q);
            mergeSort(A,q+1, r);
            merge(A, p, q, r);
        }
    }
    public static void main(String[] args) {
        int[] ints = {2, 5, 8, 9, 1, 4, 6, 7};

        System.out.println("Before sorting: " + Arrays.toString(ints));

        mergeSort(ints, 0, 7);
        System.out.println("After sorting: " + Arrays.toString(ints));
    }
}
