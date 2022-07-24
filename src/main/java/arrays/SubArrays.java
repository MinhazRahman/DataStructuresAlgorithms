package arrays;

import java.util.Arrays;

public class SubArrays {

    public static void subArrays(int[] arr){
        for (int i=0; i<arr.length; i++){
            for (int j=i+1; j<=arr.length; j++){
                System.out.println(Arrays.toString(Arrays.copyOfRange(arr, i, j)));
            }
        }
    }
    public static void main(String[] args) {
        int[] arr = new int[]{1, 4, 2, 5, 3};

        // call the subArrays method
        subArrays(arr);
    }
}
