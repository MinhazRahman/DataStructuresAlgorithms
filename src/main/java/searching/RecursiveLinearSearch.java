package searching;

// what are we inducting on?
// We are inducting on the indices of the array

public class RecursiveLinearSearch {

    // precondition: Input arr[0...n-1] is an array of integers and n is the number of elements.
    // Both startIndex and endIndex are integers where 0<= startIndex <= n-1 and 0<= endIndex <= n-1
    // Input val is an integer.

    // post-condition: Returns the index i such that val = arr[i]. Otherwise, returns -1 if val is not in arr[0...n-1].

    public static int linearSearch(int[] arr, int val, int startIndex, int endIndex){
        // base cases
        // if startIndex is greater than the endIndex, then we have searched the array or sub-array arr[startIndex...endIndex]
        // and there is no element that matches given value val. So we return -1
        if (startIndex > endIndex){
            return -1;
        }
        // if the array element matches the given value
        if (arr[startIndex] == val){
            return startIndex;
        }

        // recursive step, inductive step
       return linearSearch(arr, val, startIndex+1, endIndex);
    }
    public static void main(String[] args) {
        int[] input = {5, 2, 3, 1, 7};

        System.out.println(linearSearch(input, 2, 0, input.length-1));
        System.out.println(linearSearch(input, 10, 0, input.length-1));
    }
}
