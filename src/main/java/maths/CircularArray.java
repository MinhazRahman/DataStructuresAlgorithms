package maths;

/**
 * First of all, the memory of the computer is linear, and there is no real ring array.
 * However, we can simulate the effect of ring array.
 * Generally, we use the % operator to calculate the modulus (remainder) to get the ring effect:
 * */

public class CircularArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int n = arr.length, index = 0;

        while (true){
            int i = index % n; // The value of i will always be between 0 and less than 5.
            System.out.println(arr[i]);
            index++;
        }
    }
}
