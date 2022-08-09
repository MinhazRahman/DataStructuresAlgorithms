package slidingWindow;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array, find the average of all sub arrays of ‘K’ contiguous elements in it.
 * arr.length is an integer and 3 <= arr.length <= 100
 * arr[i] is an integer and 1 <= arr[i] <= 100
 * k is an integer and 1 <= k <= 100
 *
 */
public class AverageSubArray {
    public static List<Double> averageSubArray(int[] arr, int k){
        List<Double> result = new ArrayList<>();
        double sum = 0;
        // calculate the sum of first k elements in the array
        for (int i=0; i < k; i++){
            sum += arr[i];
        }

        // add the average of first k elements in the result
        result.add(sum/k);
        // now, apply the sliding window technique
        // slide the window one element at a time to the right
        // add arr[i] to the sum and subtract arr[i-k] from the sum until i<arr.length
        for (int i=k ; i<arr.length; i++){
            sum += arr[i] - arr[i-k];
            result.add(sum/k);
        }
        return result;
    }
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        // call the averageArray
        System.out.println(averageSubArray(arr, 3));
    }
}
