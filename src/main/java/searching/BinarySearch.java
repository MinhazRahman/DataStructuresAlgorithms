package searching;

/**
 * Binary search is an algorithm, its input is a sorted list of elements. If an element we're looking for is in that
 * list, binary search returns the position where it's located. Otherwise, binary search returns null.
 * */

// precondition: input arr is a non-empty sorted array of integers and val is an integer.
// Post-condition: binary search returns the position of val where it's located. Otherwise, binary search returns null.
// For our case if no element is found then it returns -1;

public class BinarySearch {

    public static int binarySearch(int[] arr, int target){
        // declare two pointers
        int left = 0, right = arr.length - 1;

        while (left <= right){
            // Calculate the mid
            int mid = (left + right)/2;
            if (target == arr[mid]){
                return mid;
            }
            else if (target < arr[mid]){
                right = mid - 1;
            }
            else { // val > arr[mid]
                left = mid + 1;
            }
        }
        // not found
        return -1;
    }

    public static int search(int[] arr, int target){
        // declare two pointers
        int left = 0, right = arr.length - 1;

        while (left <= right){
            // Calculate the mid
            int mid = (left + right)/2;

            if (arr[mid] > target){ // look into the left half of the array
                right = mid - 1;
            }
            else if(arr[mid] < target){ // look into the right half of the array
                left = mid + 1;
            }else{ // we have found the target value
                return mid;
            }
        }
        // not found
        return -1;
    }
    /** Complexity analysis
     * n = number of elements in the array
     * time complexity: O(log n)
     * space complexity: O(1), we are not using any extra space to store the processed data
     * */

    public static void main(String[] args) {
        int[] ints = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        System.out.println(binarySearch(ints, 5));
        System.out.println(binarySearch(ints, 15));
        System.out.println(binarySearch(ints, 10));
        System.out.println(binarySearch(ints, 7));

        System.out.println();
        System.out.println(search(ints, 5));
        System.out.println(search(ints, 15));
        System.out.println(search(ints, 10));
        System.out.println(search(ints, 7));

    }
}
