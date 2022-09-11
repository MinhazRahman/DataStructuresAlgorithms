package arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Write a function, pairSum, that takes in an array and a target sum as arguments.
 * The function should return an array containing a pair of indices whose elements sum to the given target.
 * The indices returned must be unique.
 *
 * Be sure to return the indices, not the elements themselves.
 * There is guaranteed to be one such pair that sums to the target.
 *
 * pairSum([3, 2, 5, 4, 1], 8); // -> [0, 2]
 * pairSum([4, 7, 9, 2, 5, 1], 5); // -> [0, 5]
 * pairSum([4, 7, 9, 2, 5, 1], 3); // -> [3, 5]
 * pairSum([1, 6, 7, 2], 13); // -> [1, 2]
 * pairSum([9, 9], 18); // -> [0, 1]
 * pairSum([6, 4, 2, 8 ], 12); // -> [1, 3]
 *
 * */
public class PairSum {

    public static int[] pairSum(int[] numbs, int x){
       int[] ans = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbs.length; i++){
            int y = x - numbs[i];
            // if the map contains y, then we have found the indices
            if (map.containsKey(y)){
                ans[0] = map.get(y);
                ans[1] = i;
                break;
            }
            // add values to the map
            map.put(numbs[i], i);
        }

        return ans;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(pairSum(new int[]{3, 2, 5, 4, 1}, 8)));
        System.out.println(Arrays.toString(pairSum(new int[]{4, 7, 9, 2, 5, 1}, 5)));
        System.out.println(Arrays.toString(pairSum(new int[]{4, 7, 9, 2, 5, 1}, 3)));
        System.out.println(Arrays.toString(pairSum(new int[]{1, 6, 7, 2}, 13)));
        System.out.println(Arrays.toString(pairSum(new int[]{9, 9}, 18)));
        System.out.println(Arrays.toString(pairSum(new int[]{6, 4, 2, 8}, 12)));
    }
}
