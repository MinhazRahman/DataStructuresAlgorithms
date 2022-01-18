package arrays;

import java.util.Arrays;

// Merge two sorted arrays into a third array in sorted order
// Time complexity: O(n)

public class MergeTwoSortedArrays {

    public static int[] merge(int[] A, int[] B){
        // Array C stores the merged elements in sorted order
        int[] C = new int[A.length + B.length];
        int i = 0, j = 0;

        for (int k = 0; k < C.length; k++){
            // Copy the elements of A or B into C
            if (i < A.length && j < B.length){
                if (A[i] < B[j]){
                    C[k] = A[i];
                    i++;
                }else {
                    C[k] = B[j];
                    j++;
                }
            }
            else {
                // Copy the elements of A into C
                if (i < A.length){
                    C[k] = A[i];
                    i++;
                }
                else { // j < B.length, Copy the elements of B into C
                    C[k] = B[j];
                    j++;
                }
            }
        }
        return C;
    }

    public static void main(String[] args) {
        int[] A = {6, 7, 8, 9};
        int[] B = {1, 2, 3, 4, 5};
        int[] C = {0, 1, 1, 1, 1};

        System.out.println(Arrays.toString(merge(A, B)));
        System.out.println(Arrays.toString(merge(A, C)));
        System.out.println(Arrays.toString(merge(B, C)));

    }
}
