package arrays;

import java.util.Arrays;

public class PrefixProduct {
    public static int[] prefixProductLeft(int[] nums){
        int[] left = new int[nums.length];

        left[0] = 1;

        for (int i=1; i<nums.length; i++){
            left[i] = left[i-1]*nums[i-1];
        }

        return left;
    }

    public static int[] prefixProductRight(int[] nums){
        int[] right = new int[nums.length];

        right[nums.length-1] = 1;

        for (int i=nums.length-2; i>=0; i--){
            right[i] = right[i+1]*nums[i+1];
        }

        return right;
    }
    public static void main(String[] args) {
        int[] ints = {1, 2, 3, 4};

        // call the prefixSum array
        System.out.println(Arrays.toString(prefixProductLeft(ints)));

        // call the prefixProduct array
        System.out.println(Arrays.toString(prefixProductRight(ints)));
    }
}
