package arrays;

// In the array A[p...r] the sub-arrays A[p...q] and A[q+1...r] are sorted where p <= q < r.
// Merge the sub-arrays A[p...q] and A[q+1...r] in sorted order into the array A[p...r].
// A[p...r] = {...1, 4, 6, 7, 2, 5, 8, 9...} ==> merge(A, p, q, r) ==> A[p...r] = {...1, 2, 4, 5, 6, 7, 8, 9...}
// So the merge procedure replaces the original sequence of the elements.

import java.util.Arrays;

// Things to consider:
// 1. the number of elements each sub-array contains
// 2. the total number of elements we need to sort
// 3. the merging strategy
public class Merge {

    public static int[] merge(int[] A, int p, int q, int r){
        // The number of elements in the left sub-array A[p...q]
        int nl = q - p + 1;
        // The number of elements in the right sub-array A[q+1...r]
        int nr = r - q; //r - (q+1) + 1 = r - q;

        // So, the number of elements we need to merge in the array A[p...r] is
        // n = nl + nr = q - p + 1 + r - q = r - p + 1

        // Create an array L[0...nl] where we will copy the elements of the left sub-array A[p...q]
        // L[nl] will hold the sentinel which is the Max integer.
        int[] L = new int[nl+1];

        // Create another array R[0...nr] where we copy the elements of the right sub-array A[q+1...r]
        // R[nr] will hold the sentinel which is the Max integer
        int[] R = new int[nr+1];

        // Copy the elements of the left sub-array A[p...q] into L
        for (int i = 0; i < nl; i++){
            L[i] = A[p+i];
        }

        // Copy the elements of the right sub-array A[q+1...r] into R
        for (int j = 0; j < nr; j++){
            R[j] = A[q+1+j];
        }

        // Insert the sentinels at L[nl] and R[nr]
        L[nl] = Integer.MAX_VALUE;
        R[nr] = Integer.MAX_VALUE;

        // Merge the elements of L and R into A[p...r]
        // Copy all the elements of L and R into A
        int i = 0, j = 0;
        for (int k = p; k <= r; k++){
            if (L[i] <= R[j]){
                A[k] = L[i]; // Copy the elements of L into A
                i++;
            }
            else { // R[j] < L[i]
                A[k] = R[j]; // Copy the elements of R into A
                j++;
            }
        }

        return A;
    }
    public static void main(String[] args) {
        int[] ints = {1, 4, 6, 7, 2, 5, 8, 9};

        System.out.println(Arrays.toString(merge(ints, 0, 3, 7)));
    }
}
