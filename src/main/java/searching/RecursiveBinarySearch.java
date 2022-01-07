package searching;

public class RecursiveBinarySearch {

    public static int binarySearch(int[] arr, int val, int low, int high){

        // base case 1
        if (low > high){
            return -1;
        }
        // calculate the mid value
        int mid = (low + high)/2;

        // base case 2
        if (val == arr[mid]){
            return mid;
        }

        // recursive steps
        // when val is less than arr[mid]
        if (val < arr[mid]){
            return binarySearch(arr, val, low, mid-1);
        }
        // when val is greater than arr[mid], val > arr[mid]
        else{
            return binarySearch(arr, val, mid+1, high);
        }
    }
    public static void main(String[] args) {
        int[] ints = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        System.out.println(binarySearch(ints, 5, 0, 9));
        System.out.println(binarySearch(ints, 15, 0, 9));
        System.out.println(binarySearch(ints, 10, 0, 9));
        System.out.println(binarySearch(ints, 7, 0, 9));
    }
}
