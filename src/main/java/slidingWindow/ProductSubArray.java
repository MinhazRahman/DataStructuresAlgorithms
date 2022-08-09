package slidingWindow;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array, find the product of all sub arrays of ‘K’ contiguous elements in it.
 * arr.length is an integer and 3 <= arr.length <= 100
 * arr[i] is an integer and 1 <= arr[i] <= 100
 * k is an integer and 1 <= k <= 100
 *
 */

public class ProductSubArray {
    public static List<Integer> productSubArray(int[] arr, int k){
        List<Integer> result = new ArrayList<>();
        int product = 1;

        // calculate the product of first k elements
        for (int i=0; i < k; i++){
            product *= arr[i];
        }
        // add the product of first k elements to the result
        result.add(product);

        // sliding window technique
        // let i = k;
        // now, slide the product window one element at a time to the right
        // multiply product by arr[i] and at the same time divide the product by arr[i-k] until i < arr.length
        for (int i=k; i < arr.length; i++){
            product = (product * arr[i])/arr[i-k];
            result.add(product);
        }
        return  result;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};

        // call the averageArray
        System.out.println(productSubArray(arr, 3));
    }
}
