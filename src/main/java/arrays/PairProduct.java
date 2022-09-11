package arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Write a function, pairProduct, that takes in an array and a target product as arguments.
 * The function should return an array containing a pair of indices whose elements multiply to the given target.
 * The indices returned must be unique.
 *
 * Be sure to return the indices, not the elements themselves.
 * There is guaranteed to be one such pair whose product is the target.
 *
 * pairProduct([3, 2, 5, 4, 1], 8); // -> [1, 3]
 * pairProduct([3, 2, 5, 4, 1], 10); // -> [1, 2]
 * pairProduct([4, 7, 9, 2, 5, 1], 5); // -> [4, 5]
 * pairProduct([4, 7, 9, 2, 5, 1], 35); // -> [1, 4]
 * pairProduct([3, 2, 5, 4, 1], 10); // -> [1, 2]
 * pairProduct([4, 6, 8, 2], 16); // -> [2, 3]
 *
 * */
public class PairProduct {

    public static int[] pairProduct(int[] numbs, int x){
        int[] ans = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbs.length; i++){
            int y = x / numbs[i];
            if (map.containsKey(y)){
                ans[0] = map.get(y);
                ans[1] = i;
                break;
            }
            map.put(numbs[i], i);
        }

        return ans;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(pairProduct(new int[]{3, 2, 5, 4, 1}, 8)));
        System.out.println(Arrays.toString(pairProduct(new int[]{3, 2, 5, 4, 1}, 10)));
        System.out.println(Arrays.toString(pairProduct(new int[]{4, 7, 9, 2, 5, 1}, 5)));
        System.out.println(Arrays.toString(pairProduct(new int[]{4, 7, 9, 2, 5, 1}, 35)));
        System.out.println(Arrays.toString(pairProduct(new int[]{3, 2, 5, 4, 1}, 10)));
        System.out.println(Arrays.toString(pairProduct(new int[]{4, 6, 8, 2}, 16)));
    }
}
