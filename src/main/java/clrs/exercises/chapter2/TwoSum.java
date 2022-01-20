package clrs.exercises.chapter2;

import java.util.Arrays;

public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {
        // create an array that will hold the indices
        int[] indices = new int[2];
        int n = nums.length;

        // sort the array nums
        // for this particular array we are not allowed to sort
        // so binary search will not work if we want indices
        // but if we want the elements then we can sort the array
        Arrays.sort(nums);
        System.out.println("Sorted array: " + Arrays.toString(nums));

        // find the element using binary search
        for(int i = 0; i < nums.length; i++){
            int diff = target - nums[i];
            int j = search(nums, diff, i+1, n-1);

            if(j > -1){
                indices[0] = i;
                indices[1] = j;
                break;
            }
        }

        return indices;

    }

    // binary search to find the target value
    public static int search(int[] arr, int val, int low, int high){

        // base case 1
        if(low > high){
            return -1;
        }

        // calculate mid
        int mid = (low + high)/2;

        // base case 2
        if(val == arr[mid]){
            return mid;
        }

        // recursive steps
        // when val is less than arr[mid]
        if (val < arr[mid]){
            return search(arr, val, low, mid-1);
        }
        // when val is greater than arr[mid], val > arr[mid]
        else{
            return search(arr, val, mid+1, high);
        }
    }

    public static void main(String[] args) {
        int[] arr1 = {3, 2, 4};

        System.out.println(Arrays.toString(twoSum(arr1, 6)));
        System.out.println(Arrays.toString(twoSum(arr1, 7)));


    }
}
