package arrays;

import java.util.Arrays;

// sum of all the left elements of an element in an array
// sum of all the right elements of an element in an array
public class PrefixSum {
    public static int[] prefixSumLeft(int[] nums){
        int[] left = new int[nums.length];

        left[0] = 0;

        for (int i=1; i<nums.length; i++){
            left[i] = left[i-1] + nums[i-1];
        }

        return left;
    }

    public static int[] prefixSumRight(int[] nums){
        int[] right = new int[nums.length];

        right[nums.length-1] = 0;

        for (int i=nums.length-2; i>=0; i--){
            right[i] = right[i+1] +  nums[i+1];
        }

        return right;
    }

    public static int[] sumOfArrayExceptSelf(int[] nums){
        int[] sum = new int[nums.length];

        int[] left = new int[nums.length];
        int[] right = new int[nums.length];

        left[0] = 0;

        for (int i=1; i<nums.length; i++){
            left[i] = left[i-1] + nums[i-1];
        }

        right[nums.length-1] = 0;

        for (int i=nums.length-2; i>=0; i--){
            right[i] = right[i+1] +  nums[i+1];
        }

        for (int i=0; i<sum.length; i++){
            sum[i] = left[i] + right[i];
        }

        return sum;
    }
    public static void main(String[] args) {
        int[] ints = {1, 2, 3, 4, 5};

        // call the prefixSum array
        System.out.println(Arrays.toString(prefixSumLeft(ints)));

        // call the prefixProduct array
        System.out.println(Arrays.toString(prefixSumRight(ints)));

        // sum of array except self
        System.out.println(Arrays.toString(sumOfArrayExceptSelf(ints)));
    }
}
