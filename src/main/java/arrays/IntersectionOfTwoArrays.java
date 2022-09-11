package arrays;

import java.util.*;

/**
 * Write a function, intersection, that takes in two arrays, a,b, as arguments.
 * The function should return a new array containing elements that are in both of the two arrays.
 *
 * You may assume that each input array does not contain duplicate elements.
 * intersection([4,2,1,6], [3,6,9,2,10]) // -> [2,6]
 * intersection([2,4,6], [4,2]) // -> [2,4]
 * intersection([4,2,1], [1,2,4,6]) // -> [1,2,4]
 * intersection([0,1,2], [10,11]) // -> []
 *
 * */
public class IntersectionOfTwoArrays {

    public static int[] intersection(int[] a, int[] b){
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> commonElements = new ArrayList<>();

        // create the hash map for array a
        for (int i = 0; i < a.length; i++){
            map.put(a[i], i);
        }

        // iterate over the array b and check if the map contains the element
        for (int n: b){
            if (map.containsKey(n)){
                commonElements.add(n);
            }
        }

        int[] ans = new int[commonElements.size()];
        for (int i = 0; i < commonElements.size(); i++){
            ans[i] = commonElements.get(i);
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(intersection(new int[]{4, 2, 1, 6}, new int[]{3, 6, 9, 2, 10})));
        System.out.println(Arrays.toString(intersection(new int[]{2,4,6}, new int[]{2,4})));
        System.out.println(Arrays.toString(intersection(new int[]{4, 2, 1}, new int[]{1,2,4,6})));
        System.out.println(Arrays.toString(intersection(new int[]{0,1,2}, new int[]{10,11})));
    }
}
