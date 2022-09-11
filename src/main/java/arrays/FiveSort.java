package arrays;

import java.util.Arrays;

/**
 * Write a function, fiveSort, that takes in an array of numbers as an argument.
 * The function should rearrange elements of the array such that all 5s appear at the end.
 * Your function should perform this operation in-place by mutating the original array.
 * The function should return the array.
 *
 * Elements that are not 5 can appear in any order in the output, as long as all 5s are at the end of the array.
 *
 * fiveSort([12, 5, 1, 5, 12, 7]); // -> [12, 7, 1, 12, 5, 5]
 * fiveSort([5, 2, 5, 6, 5, 1, 10, 2, 5, 5]); // -> [2, 2, 10, 6, 1, 5, 5, 5, 5, 5]
 * fiveSort([5, 5, 5, 1, 1, 1, 4]); // -> [4, 1, 1, 1, 5, 5, 5]
 * fiveSort([5, 5, 6, 5, 5, 5, 5]); // -> [6, 5, 5, 5, 5, 5, 5]
 * fiveSort([5, 1, 2, 5, 5, 3, 2, 5, 1, 5, 5, 5, 4, 5]); // -> [4, 1, 2, 1, 2, 3, 5, 5, 5, 5, 5, 5, 5, 5]
 *
 * */
public class FiveSort {
    public static int[] fiveSort(int[] nums){
        int i = 0;
        int j = nums.length - 1;
        while (i < j){
            if (nums[i] != 5) i++;
            if (nums[j] == 5) j--;
            if (nums[i] == 5 && nums[j] != 5){ // swap nums[i] and nums[j]
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
                j--;
            }
        }
        return nums;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(fiveSort(new int[]{12, 5, 1, 5, 12, 7})));
        System.out.println(Arrays.toString(fiveSort(new int[]{5, 2, 5, 6, 5, 1, 10, 2, 5, 5})));
        System.out.println(Arrays.toString(fiveSort(new int[]{5, 5, 5, 1, 1, 1, 4})));
        System.out.println(Arrays.toString(fiveSort(new int[]{5, 5, 6, 5, 5, 5, 5})));
        System.out.println(Arrays.toString(fiveSort(new int[]{5, 1, 2, 5, 5, 3, 2, 5, 1, 5, 5, 5, 4, 5})));
    }
}
