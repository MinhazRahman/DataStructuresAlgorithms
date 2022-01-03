package arrays;

import java.util.Arrays;

// Calculate the sum of two n-bit binary integers where the bits
// are stored in the arrays A and B.

// precondition: Each of the arrays A and B contains n-bits.
// post-condition: Return the sum of two n-bit binary integers

// edge cases: both arrays A and B can be null. One of the arrays can be null
// Both arrays must be of the same length.

public class BinarySum {

    public static int[] binarySum(int[] A, int[] B){
        // Length of A or B
        int n = A.length; // n = B.length
        // Create an array C of length n+1
        int[] C = new int[n+1];

        int i = n-1, j = C.length-1;
        int sum = 0;
        while (i>=0){
            sum = A[i] + B[i] + C[j];
            C[j] = sum % 2;
            C[j-1] = sum / 2;

            i = i - 1;
            j = j - 1;
        }

        return C;
    }

    public static void main(String[] args) {
        int[] A = {1, 0, 1, 1, 1, 1, 1};
        int[] B = {1, 1, 1, 1, 1, 1, 1};

        System.out.println(Arrays.toString(binarySum(A, B)));
    }
}
