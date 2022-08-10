package slidingWindow;

import java.util.Arrays;

/**
 Problem Statement#
 Given an array of positive integers and a number ‘S,’
 find the length of the smallest contiguous subarray whose sum is greater than or equal to ‘S’.
 Return 0 if no such subarray exists.

 Example 1:

 Input: [2, 1, 5, 2, 3, 2], S=7
 Output: 2
 Explanation: The smallest subarray with a sum greater than or equal to ‘7’ is [5, 2].

 Example 2:

 Input: [2, 1, 5, 2, 8], S=7
 Output: 1
 Explanation: The smallest subarray with a sum greater than or equal to ‘7’ is [8].

 Example 3:

 Input: [3, 4, 1, 1, 6], S=8
 Output: 3
 Explanation: Smallest subarrays with a sum greater than or equal to ‘8’ are [3, 4, 1] or [1, 1, 6].
 * */

public class SmallestSubArraySum {
    // brute force way
    public static int findSmallestSubArraySum(int[] arr, int k){
        int smallestLength = Integer.MAX_VALUE;

        for (int i=0; i<arr.length; i++){
            for (int j=i+1; j<=arr.length; j++){
                int[] subArr = Arrays.copyOfRange(arr, i, j);
                if (sum(subArr) >= k ) {
                    smallestLength = Math.min(smallestLength, subArr.length);
                }
            }
        }
        return smallestLength;
    }

    public static int sum(int[] nums){
       int sum = 0;
       for (int num: nums){
           sum += num;
       }
       return  sum;
    }

    public static int shortestSubArray(int[] nums, int k) {
        int n = nums.length;
        int smallestLength = Integer.MAX_VALUE;
        int start = 0;
        int sum = 0;
        int oldSum = 0;
        for(int end=0; end<n; end++){
            // Add the next element to the window
            sum += nums[end];
            // Shrink the window as small as possible until the 'windowSum' is smaller than 'K'
            while(sum >= k){
                smallestLength = Math.min(smallestLength, end-start+1);
                // Discard the element at 'windowStart' since it is going out of the window
                sum -= nums[start];
                // Shrink the window
                start++;
            }
        }

        return smallestLength == Integer.MAX_VALUE? -0: smallestLength;
    }

    public static void main(String[] args) {
        int[] input = new int[]{2, 1, 5, 2, 3, 2};

        System.out.println(shortestSubArray(input, 7));


        input = new int[] {3, 4, 1, 1, 6};
        System.out.println(shortestSubArray(input, 8));
    }
}
