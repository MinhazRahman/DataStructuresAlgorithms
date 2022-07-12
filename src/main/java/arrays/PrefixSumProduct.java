package arrays;

import java.util.Arrays;

public class PrefixSumProduct {
    public static int[] prefixSum(int[] nums){
        int[] sums = new int[nums.length];

        sums[0] = nums[0];

        for (int i=1; i<nums.length; i++){
            sums[i] = sums[i-1] + nums[i];
        }

        return sums;
    }

    public static int[] prefixProduct(int[] nums){
        int[] products = new int[nums.length];

        products[0] = nums[0];

        for (int i=1; i<nums.length; i++){
            products[i] = products[i-1] * nums[i];
        }

        return products;
    }
    public static void main(String[] args) {
        int[] ints = {1, 2, 3, 4, 5};

        // call the prefixSum array
        System.out.println(Arrays.toString(prefixSum(ints)));

        // call the prefixProduct array
        System.out.println(Arrays.toString(prefixProduct(ints)));
    }
}
